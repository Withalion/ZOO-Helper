package Help;

import Animals.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Trieda, ktorá obsahuje databázu zvierat, ktoré momentálne sú v zoo.
 * Serializácia aj deserializácia sa vždy dejú vo vlastnom vlákne oproti ostatnej logike programu.
 */
public class AnimalDB extends Thread{
    public static ArrayList<Animal> animals = new ArrayList<Animal>();
    private Thread ActiveThread;

    /**
     * Načítanie databázy ak existuje záloha ak nie tak sa vytvoria predpísané zvieratá.
     */
    private static void loadDB(){   //deserialize arraylist
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

    private static void fillDB(){   //naplnenie databazy prototypmi ak neexistuje zaloha
        animals.add(new Cat("Boby", 4, "MEAT", 30));
        animals.add(new Amphibian("Mlok", 1, "WORMS", 2));
        animals.add(new Bird("Jerry", 3,"SEEDS, FRUITS", 4));
        animals.add(new Fish("Mlem", 1, "FISH FOOD", 2));
        animals.add(new Invertebrate( "Blob", 2, "NONE", 0));
        animals.add(new Mammal("Vincent", 8, "FISH", 10));
        animals.add(new Primate("Franta", 12, "FRUIT", 16));
        animals.add(new Reptile("Geko", 3, "VEGETABLE", 5));
    }

    /**
     * Uloženie databázy do súboru s názvom AnimalBackup.
     */
    private static void saveDB(){   //serialize arraylist
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

    @Override
    public void run() {
        if (animals.isEmpty()) loadDB();
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
