package me.whiteship.chapter01.item02.telescopingconstructor;


/*
    정적 팩터리와 생성자에 선택적 매개변수가 많을 때 고려할 수 있는 방안
    1. 점층적 생성자 패턴 또는 생성자 체이닝
        - 확장하기 어려우며, 매개변수가 늘어나면 클라이언트 코드를 작성하거나 읽기 어렵다.
 */
public class NutritionFacts {

    private final int servingSize;     // (mL, 1회 제공량) - 필수
    private final int servings;        // (회, 총 n회 제공량) - 필수
    private final int calories;        // (1회 제공량당) - 선택
    private final int fat;             // (g/1회 제공량) - 선택
    private final int sodium;          // (g/1회 제공량) - 선택
    private final int carbohydrate;    // (g/1회 제공량) - 선택

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args){
        // 매개변수가 늘어나면 클라이언트 코드를 작성하거나 읽기 어렵다.
        NutritionFacts nutritionFacts = new NutritionFacts(10,10);
    }
}
