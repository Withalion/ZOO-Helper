package Help;

import Animals.*;
import Models.*;

import java.io.*;
import java.util.ArrayList;

public class AnimalDB {
    public static ArrayList<Animal> animals = new ArrayList<Animal>();

    public static void loadDB(){   //deserialize arraylist
        try {
            FileInputStream fileIn = new FileInputStream("AnimalBackup");
            ObjectInputStream ObjectIn = new ObjectInputStream(fileIn);
            animals = (ArrayList) ObjectIn.readObject();
            ObjectIn.close();
            fileIn.close();
        }
        catch (IOException ioe) {
            System.out.println("AnimalFile not found");
            AnimalDB.fillDB();
        }
        catch (ClassNotFoundException c) {
            System.out.println("Class not found");
        }
    }

    public static void fillDB(){   //naplnenie databazy prototypmi ak neexistuje zaloha
        animals.add(new Cat("Boby", 4, "MEAT", 30));
        animals.add(new Amphibian("Mlok", 1, "WORMS", 2));
        animals.add(new Bird("Jerry", 3,"SEEDS, FRUITS", 4));
        animals.add(new Fish("Mlem", 1, "FISH FOOD", 2));
        animals.add(new Invertebrate( "Blob", 2, "NONE", 0));
        animals.add(new Mammal("Vincent", 8, "FISH", 10));
        animals.add(new Primate("Franta", 12, "FRUIT", 16));
        animals.add(new Reptile("Geko", 3, "VEGETABLE", 5));
    }

    public static void saveDB(){   //serialize arraylist
        if (animals != null) {
            try {
                FileOutputStream fileOut = new FileOutputStream("AnimalBackup");
                ObjectOutputStream ObjectOut = new ObjectOutputStream(fileOut);
                ObjectOut.writeObject(animals);
                ObjectOut.close();
                fileOut.close();
            } catch (IOException ioe) {
                System.out.println("AnimalData neboli backupnute");
            }
        }
    }
}
