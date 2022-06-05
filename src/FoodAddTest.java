import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FoodAddTest {

    Food food = new Food();


    @Test
    void addFoodIdealResponse() throws IOException {
        // The ideal input
        assertEquals(true,food.addFood("Butter Chicken", "This is an amazing way to eat the best chicken", 35.00, 670, "Adult Food"));


    }

    @Test
    void addFoodWrongFoodName() throws IOException {
        //Food name should be between 5 and 30 characters
        assertEquals(false,food.addFood("en", "This is an amazing way to eat the best chicken", 35.00, 670, "Adult Food"));

    }

    @Test
    void addFoodWrongFoodDescription() throws IOException {
        //Food description should be between 5 and 50 words
        assertEquals(false,food.addFood("Butter chicken", " chicken", 35.00, 670, "Adult Food"));

    }
    @Test
    void addFoodWrongCalorie() throws IOException {
        //It should not be possible to add foods with more than 1500 calorie
        assertEquals(false,food.addFood("Butter Chicken", "This is an amazing way to eat the best chicken", 35.00, 1600, "Adult Food"));
    }
    @Test
    void addFoodWrongFoodType() throws IOException {
        // Some other food type is entered
        assertEquals(false,food.addFood("Butter Chicken", "This is an amazing way to eat the best chicken", 35.00, 670, "Vegan Food"));


    }
    @Test
    void addFoodKidFoodError() throws IOException {
        //If the type of food is “Kid Food”, their calorie should be less than 800.
        assertEquals(false,food.addFood("Butter Chicken", "This is an amazing way to eat the best chicken", 35.00, 970, "Kid Food"));


    }
    @Test
    void addFoodWrongFoodPrice() throws IOException {
        //The price of each food should be between $5 and $150.
        assertEquals(false,food.addFood("Butter Chicken", "This is an amazing way to eat the best chicken", 235.00, 670, "Adult Food"));
    }
    @Test
    void addFoodWrongPriceForCalorie() throws IOException {
        //The price of foods with more than 1000 calories should be less than $100.
        assertEquals(false,food.addFood("Butter Chicken", "This is an amazing way to eat the best chicken", 135.00, 1270, "Adult Food"));


    }
}