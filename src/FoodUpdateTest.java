import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FoodUpdateTest {
    private Food food =new Food();
    @Test
    void updateFoodPrice() throws IOException {
      //It should not be possible to increase the food price by more than 10%.

        assertEquals(food.UpdateFood("menuitems.txt", "7",4,"77.5"),false);

    }

    @Test
    void updateFoodCalorie() throws IOException {
        //It should not be possible to change the food calorie.
        assertEquals(food.UpdateFood("menuitems.txt", "7",5,"200"),false);

    }
    @Test
    void updateFoodType() throws IOException {

        //It should not be possible to change the type of food to “Kid Food”, but it can be possible to change “Kid Food” to any other type.

        assertEquals(food.UpdateFood("menuitems.txt", "7",6,"Kid Food"),false);

    }
}