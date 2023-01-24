package me.whiteship.chapter01.item02.builder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

/*
    생성자에 매개변수가 많다면 빌더를 고려
        - 플루언트 API, 메소드 체이닝을 한다.
        - 계층적으로 설계된 클래스와 함께 사용하기 쉽다.
        - 점층적 생성자보다 클라이언트 코드를 읽고 쓰기가 훨씬 간결하고, 자바빈즈 setter보다 훨신 안전하다. ( immutable )

        - 다만 코드가 복잡해지고, 길어진다. ( Lombok Builder 어노테이션으로 해결 가능 )
 */
@Builder(builderClassName = "Builder")
@AllArgsConstructor(access = AccessLevel.PRIVATE)   // Builder 어노테이션은 자동으로 모든 파라미터를 받는 생성자를 생성한다. ( 생성자 호출을 제한하려면 access level을 통해 제한할 수 있다. )
public class NutritionFacts {
    private final int servingSize;     // (mL, 1회 제공량) - 필수
    private final int servings;        // (회, 총 n회 제공량) - 필수
    private final int calories;        // (1회 제공량당) - 선택
    private final int fat;             // (g/1회 제공량) - 선택
    private final int sodium;          // (g/1회 제공량) - 선택
    private final int carbohydrate;    // (g/1회 제공량) - 선택

    /*  Lombok Builder 어노테이션을 통해 간편하게 사용 가능
    public static class Builder {
        // 필수
        private final int servingSize;
        private final int servings;

        // Optional
        private int calories        = 0;
        private int fat             = 0;
        private int sodium          = 0;
        private int carbohydrate    = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize    = servingSize;
            this.servings       = servings;
        }

        public Builder calories(int val)
        { calories = val;     return this; }

        public Builder fat(int val)
        { fat = val;          return this; }

        public Builder sodium(int val)
        { sodium = val;       return this; }

        public Builder carbohydrate(int val)
        { carbohydrate = val; return this; }

        public NutritionFacts build() { return new NutritionFacts( this ); }
    }

    private NutritionFacts(Builder builder) {
        servingSize     = builder.servingSize;
        servings        = builder.servings;
        calories        = builder.calories;
        fat             = builder.fat;
        sodium          = builder.sodium;
        carbohydrate    = builder.carbohydrate;
    }
    */
    public static void main(String[] args) {
        // Builder를 사용하여 메소드 체이닝이 가능
        // Lombook 빌더를 사용하면 필수 필드를 생성자로 받을 수는 없다..
        NutritionFacts cocaCola = new Builder()
                .servingSize(100)
                .servings(10)
                .calories(100)
                .sodium(35)
                .carbohydrate(27).build();
    }
}
