package Help;

import java.util.ArrayList;
import Models.*;
import java.io.*;

/**
 * Trieda, ktorá obsahuje databázu používateľov, ktorí momentálne sú v zoo.
 * Serializácia aj deserializácia sa vždy dejú vo vlastnom vlákne oproti ostatnej logike programu.
 */
public class UserDB extends Thread{
    public static ArrayList<User> users = new ArrayList<User>();
    private Thread ActiveThread;

    /**
     * Načítanie databázy ak existuje záloha ak nie tak sa vytvoria predpísaní používatelia.
     */
    private void loadDB () {   //deserialize arraylist
        try {
            FileInputStream fileIn = new FileInputStream("UserBackup");
               ObjectInputStream ObjectIn = new ObjectInputStream(fileIn);
               users = (ArrayList) ObjectIn.readObject();
               ObjectIn.close();
               fileIn.close();
        } catch (IOException ioe) {
               System.out.println("UserFile not found");
               this.fillDB();
        } catch (ClassNotFoundException c) {
               System.out.println("Class not found");
        }
    }

    private void fillDB () {   //naplnenie databazy prototypmi ak neexistuje zaloha
        users.add(new Child(10001, "Janko"));
        users.add(new Adult(10002, "Marian"));
        users.add(new Senior(10003, "Imrich"));
        users.add(new Pokladnik(50001, "Marienka"));
        users.add(new Manager(90001, "Alfonz"));
        users.add(new Zookeeper(50002, "Edo", false, true, false, true, false, true, false, false));
    }

    /**
     * Uloženie databázy do súboru s názvom UserBackup.
     */
    private void saveDB () {   //serialize arraylist
        if (users != null) {
            try {
                FileOutputStream fileOut = new FileOutputStream("UserBackup");
                ObjectOutputStream ObjectOut = new ObjectOutputStream(fileOut);
                ObjectOut.writeObject(users);
                ObjectOut.close();
                fileOut.close();
            } catch (IOException ioe) {
                System.out.println("UserData neboli backupnute");
            }
        }
    }

    @Override
    public void run() {
        if (users.isEmpty()) loadDB();
        else saveDB();
    }

    @Override
    public synchronized void start() {
        if (ActiveThread == null){
            ActiveThread = new Thread(this);
            ActiveThread.start();
        }
    }
}
