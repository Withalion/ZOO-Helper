package AnimalPavilons;

import Animals.Animal;

public class Terrarium extends AnimalPavilon {
    public Terrarium(Animal Occupant){
        if (Occupant != null){
            this.occupied = true;
            this.occupants.add(Occupant);
        }
    }
}
