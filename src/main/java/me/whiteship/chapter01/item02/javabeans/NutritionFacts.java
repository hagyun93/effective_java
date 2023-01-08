package me.whiteship.chapter01.item02.javabeans;

/*
    정적 팩터리와 생성자에 선택적 매개변수가 많을 때 고려할 수 있는 방안
    1. 자바 빈즈 패턴 ( setter )
        - 완전한 객체를 만드려면 메서드를 여러번 호출해야한다. ( setter ) - 일관성이 무너진 상태가 될 수 있다.
        - 클래스를 불변 ( immutable ) 하게 만들수 없다.
 */
public class NutritionFacts {
    private int servingSize = -1;    // (mL, 1회 제공량) - 필수 ( 기본값 없음 )
    private int servings = -1;       // (회, 총 n회 제공량) - 필수 ( 기본값 없음 )
    private int calories = 0;        // (1회 제공량당) - 선택
    private int fat = 0;             // (g/1회 제공량) - 선택
    private int sodium = 0;          // (g/1회 제공량) - 선택
    private int carbohydrate = 0;    // (g/1회 제공량) - 선택

    public NutritionFacts(int servingSize, int servings) {
        this.servingSize = servingSize;
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts(10, 10);
        nutritionFacts.setCalories(100);

    }

}
