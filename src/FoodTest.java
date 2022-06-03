import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    Food food = new Food();


    @Test
    void addFoodIdealResponse() throws IOException {
        assertEquals(true,food.addFood("Butter Chicken", "This is an amazing way to eat the best chicken", 35.00, 670, "Adult Food"));


    }

    @Test
    void addFoodWrongFoodName() throws IOException {
        assertEquals(false,food.addFood("en", "This is an amazing way to eat the best chicken", 35.00, 670, "Adult Food"));

    }

    @Test
    void addFoodWrongFoodDescription() throws IOException {
        assertEquals(false,food.addFood("Butter chicken", " chicken", 35.00, 670, "Adult Food"));

    }
    @Test
    void addFoodWrongCalorie() throws IOException {
        assertEquals(false,food.addFood("Butter Chicken", "This is an amazing way to eat the best chicken", 35.00, 1600, "Adult Food"));
    }
    @Test
    void addFoodWrongFoodType() throws IOException {
        assertEquals(false,food.addFood("Butter Chicken", "This is an amazing way to eat the best chicken", 35.00, 670, "Vegan Food"));


    }
    @Test
    void addFoodKidFoodError() throws IOException {
        assertEquals(false,food.addFood("Butter Chicken", "This is an amazing way to eat the best chicken", 35.00, 970, "Kid Food"));


    }
    @Test
    void addFoodWrongFoodPrice() throws IOException {
        assertEquals(false,food.addFood("Butter Chicken", "This is an amazing way to eat the best chicken", 235.00, 670, "Adult Food"));
    }
    @Test
    void addFoodWrongPriceForCalorie() throws IOException {
        assertEquals(false,food.addFood("Butter Chicken", "This is an amazing way to eat the best chicken", 135.00, 1270, "Adult Food"));


    }
}