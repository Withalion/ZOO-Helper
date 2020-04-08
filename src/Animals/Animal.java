package Animals;

import Models.Feedable;
import java.io.Serializable;

public class Animal implements Feedable, Serializable {
    public String Name;
    private int Age;
    private String FoodType;
    private int MealPrice;
    private boolean Hungry = true;

    public int getAge(){
        return this.Age;
    }
    public void setAge(int AnimalAge){
        this.Age = AnimalAge;
    }
    public String getFoodType(){
        return this.FoodType;
    }
    public void setFoodType(String AnimalFoodType){
        this.FoodType = AnimalFoodType;
    }
    public int getMealPrice(){
        return this.MealPrice;
    }
    public void setMealPrice(int AnimalMealPrice) {
        this.MealPrice = AnimalMealPrice;
    }
    public void setHungry(boolean hunger){this.Hungry = hunger;}
    public boolean isHungry(){
        return this.Hungry;
    }

    @Override
    public String FeedME() {
        return "";
    }
}
