package AnimalPavilons;

import Animals.Animal;

public class Cage extends AnimalPavilon{
    public Cage( Animal Occupant){
        if (Occupant != null){
            this.occupied = true;
            this.occupants.add(Occupant);
        }
    }
}
