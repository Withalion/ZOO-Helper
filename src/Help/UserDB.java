package Help;

import java.util.ArrayList;
import Models.*;
import java.io.*;

public class UserDB {
    public static ArrayList<User> users = new ArrayList<User>();

    public static void loadDB(){   //deserialize arraylist
        try {
            FileInputStream fileIn = new FileInputStream("UserBackup");
            ObjectInputStream ObjectIn = new ObjectInputStream(fileIn);
            users = (ArrayList) ObjectIn.readObject();
            ObjectIn.close();
            fileIn.close();
        }
        catch (IOException ioe) {
            System.out.println("UserFile not found");
            UserDB.fillDB();
        }
        catch (ClassNotFoundException c) {
            System.out.println("Class not found");
        }
    }

    public static void fillDB(){   //naplnenie databazy prototypmi ak neexistuje zaloha
        users.add(new Dieta(10001, "Janko"));
        users.add(new Dospeli(10002, "Marian"));
        users.add(new Senior(10003, "Imrich"));
        users.add(new Pokladnik(50001, "Marienka"));
        users.add(new Manazer(90001, "Alfonz"));
        users.add(new Osetrovatel(50002, "Edo", false,true, false,true,false,true,false,false));

    }

    public static void saveDB(){   //serialize arraylist
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
}