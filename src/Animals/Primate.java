package Animals;

public class Primate extends ShowableAnimal {
    public Primate (String aName,int aAge, String aFoodType, int aMealPrice){
        this.Name = aName;
        this.setAge(aAge);
        this.setFoodType(aFoodType);
        this.setMealPrice(aMealPrice);
    }
}
