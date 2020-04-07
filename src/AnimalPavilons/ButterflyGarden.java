package AnimalPavilons;

import Animals.Animal;

public class ButterflyGarden extends AnimalPavilon {
    public ButterflyGarden( Animal Occupant){
        if (Occupant != null){
            this.occupied = true;
            this.occupants.add(Occupant);
        }
    }
}
