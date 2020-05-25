package AnimalPavilons;

import Animals.Animal;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Táto trieda predstavuje základ každého pavilónu. Má 2 premenné Arraylist zvierat a to či je obsadené.
 */
public class AnimalPavilon implements Serializable{
    public boolean occupied;
    public ArrayList<Animal> occupants = new ArrayList<Animal>();
}
