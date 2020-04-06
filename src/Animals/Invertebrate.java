package Animals;

public class Invertebrate extends NotshowableAnimal {
    public Invertebrate (String aName,int aAge, String aFoodType, int aMealPrice){
        this.Name = aName;
        this.setAge(aAge);
        this.setFoodType(aFoodType);
        this.setMealPrice(aMealPrice);
    }
}
