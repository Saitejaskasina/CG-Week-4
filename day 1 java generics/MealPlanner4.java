interface MealPlan {}
class VegetarianMeal implements MealPlan {}

class Meal<T extends MealPlan> {}

public class MealPlanner4 {
    static <T extends MealPlan> void validateMeal(T meal) {
        System.out.println("Valid meal: " + meal.getClass().getSimpleName());
    }
}