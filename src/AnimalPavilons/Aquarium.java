package AnimalPavilons;

import Animals.Animal;

public class Aquarium extends AnimalPavilon {
    public Aquarium( Animal Occupant){
        if (Occupant != null){
            this.occupied = true;
            this.occupants.add(Occupant);
        }
    }
}
