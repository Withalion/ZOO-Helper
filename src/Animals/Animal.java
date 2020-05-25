package Animals;

import Help.Feedable;
import java.io.Serializable;

/**
 * Základná trieda pre zviera obsahuje vek, meno, druh žrádla, cenu žrádla a to či je zviera hladné.
 * Implementuje metódu FeedME.
 */
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
