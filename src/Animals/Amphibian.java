package Animals;

import Controllers.LoginController;

public class Amphibian extends NotshowableAnimal {
    public Amphibian (String aName,int aAge, String aFoodType, int aMealPrice){
        this.Name = aName;
        this.setAge(aAge);
        this.setFoodType(aFoodType);
        this.setMealPrice(aMealPrice);
    }

    /**
     * Prekonaná metóda rozhrania Feedable.
     * @return vrati string kde je napisane vsetko o zvierati
     */
    public String FeedME() {
        this.setHungry(false);
        LoginController.budget += this.getMealPrice();
        System.out.println("Potrava: " +this.getFoodType() +"\nCena potravy: "+this.getMealPrice() );
        return (this.getClass().getSimpleName()+"-> Name: "+this.Name+"\nFood Type: "+this.getFoodType()+"\nAge: "+this.getAge()+"\n");
    }
}
