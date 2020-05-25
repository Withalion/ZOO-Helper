package Help;

import AnimalPavilons.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Trieda, ktorá obsahuje databázu pavilónov, ktoré momentálne sú v zoo.
 * Serializácia aj deserializácia sa vždy dejú vo vlastnom vlákne oproti ostatnej logike programu.
 */
public class PavilonDB extends Thread{
    public static ArrayList<AnimalPavilon> pavilons = new ArrayList<AnimalPavilon>();
    private Thread ActiveThread;

    /**
     * Načítanie databázy ak existuje záloha ak nie tak sa vytvoria predpísané pavilóny.
     */
    private static void loadDB(){   //deserialize arraylist
        try {
            FileInputStream fileIn = new FileInputStream("PavilonBackup");
            ObjectInputStream ObjectIn = new ObjectInputStream(fileIn);
            pavilons = (ArrayList) ObjectIn.readObject();
            ObjectIn.close();
            fileIn.close();
        }
        catch (IOException ioe) {
            System.out.println("PavilonFile not found");
            PavilonDB.fillDB();
        }
        catch (ClassNotFoundException c) {
            System.out.println("Class not found");
        }
    }

    private static void fillDB(){   //naplnenie databazy prototypmi ak neexistuje zaloha
        pavilons.add(new Paddock(AnimalDB.animals.get(0)));
        pavilons.add(new Terrarium(AnimalDB.animals.get(1)));
        pavilons.add(new Aviary(AnimalDB.animals.get(2)));
        pavilons.add(new Aquarium(AnimalDB.animals.get(3)));
        pavilons.add(new ButterflyGarden(AnimalDB.animals.get(4)));
        pavilons.add(new Aquarium(AnimalDB.animals.get(5)));
        pavilons.add(new Cage(AnimalDB.animals.get(6)));
        pavilons.add(new Terrarium(AnimalDB.animals.get(7)));
    }

    /**
     * Uloženie databázy do súboru s názvom PavilonBackup.
     */
    private static void saveDB(){   //serialize arraylist
        if (pavilons != null) {
            try {
                FileOutputStream fileOut = new FileOutputStream("PavilonBackup");
                ObjectOutputStream ObjectOut = new ObjectOutputStream(fileOut);
                ObjectOut.writeObject(pavilons);
                ObjectOut.close();
                fileOut.close();
            } catch (IOException ioe) {
                System.out.println("PavilonData neboli backupnute");
            }
        }
    }

    @Override
    public void run() {
        if (pavilons == null) loadDB();
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
