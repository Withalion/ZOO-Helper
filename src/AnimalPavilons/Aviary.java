package AnimalPavilons;

import Animals.Animal;

public class Aviary extends AnimalPavilon {
    public Aviary( Animal Occupant){
        if (Occupant != null){
            this.occupied = true;
            this.occupants.add(Occupant);
        }
    }
}