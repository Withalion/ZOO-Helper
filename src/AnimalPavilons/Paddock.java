package AnimalPavilons;

import Animals.Animal;

public class Paddock extends AnimalPavilon {
    public Paddock( Animal Occupant){
        if (Occupant != null){
            this.occupied = true;
            this.occupants.add(Occupant);
        }
    }
}
