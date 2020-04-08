package Help;

import AnimalPavilons.*;
import Animals.*;

import java.io.*;
import java.util.ArrayList;

public class PavilonDB {
    public static ArrayList<AnimalPavilon> pavilons = new ArrayList<AnimalPavilon>();

    public static void loadDB(){   //deserialize arraylist
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

    public static void fillDB(){   //naplnenie databazy prototypmi ak neexistuje zaloha
        pavilons.add(new Paddock(AnimalDB.animals.get(0)));
        pavilons.add(new Terrarium(AnimalDB.animals.get(1)));
        pavilons.add(new Aviary(AnimalDB.animals.get(2)));
        pavilons.add(new Aquarium(AnimalDB.animals.get(3)));
        pavilons.add(new ButterflyGarden(AnimalDB.animals.get(4)));
        pavilons.add(new Aquarium(AnimalDB.animals.get(5)));
        pavilons.add(new Cage(AnimalDB.animals.get(6)));
        pavilons.add(new Terrarium(AnimalDB.animals.get(7)));
    }

    public static void saveDB(){   //serialize arraylist
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
}