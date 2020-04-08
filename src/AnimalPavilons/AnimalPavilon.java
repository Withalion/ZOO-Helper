package AnimalPavilons;

import Animals.Animal;

import java.io.Serializable;
import java.util.ArrayList;


public class AnimalPavilon implements Serializable{
    public boolean occupied;
    public ArrayList<Animal> occupants = new ArrayList<Animal>();
}
