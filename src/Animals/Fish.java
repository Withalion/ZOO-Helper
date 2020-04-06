package Animals;

public class Fish extends NotshowableAnimal {
    public Fish (String aName,int aAge, String aFoodType, int aMealPrice){
        this.Name = aName;
        this.setAge(aAge);
        this.setFoodType(aFoodType);
        this.setMealPrice(aMealPrice);
    }
}
