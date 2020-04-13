package Animals;

import Controllers.LoginController;

public class Fish extends NotshowableAnimal {
    public Fish (String aName,int aAge, String aFoodType, int aMealPrice){
        this.Name = aName;
        this.setAge(aAge);
        this.setFoodType(aFoodType);
        this.setMealPrice(aMealPrice);
    }

    public String FeedME() {
        this.setHungry(false);
        LoginController.budget += this.getMealPrice();
        System.out.println("Potrava: " +this.getFoodType() +"\nCena potravy: "+this.getMealPrice() );
        return (this.getClass().getSimpleName()+"-> Name: "+this.Name+"\nFood Type: "+this.getFoodType()+"\nAge: "+this.getAge()+"\n");
    }
}
