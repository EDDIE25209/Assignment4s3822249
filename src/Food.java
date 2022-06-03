public class Food {

    private String foodID;

    private String foodName;

    private String foodDescription;

    private double foodPrice;

    private int foodCalorie;

    private String foodType;

    public Food (String foodID,String foodName, String foodDescription, double foodPrice, int foodCalorie, String foodType)

    {
        this.foodCalorie=foodCalorie;
        this.foodID=foodID;
        this.foodName=foodName;
        this.foodDescription=foodDescription;
        this.foodPrice=foodPrice;
        this.foodType=foodType;

    }

    public boolean AddFood(String foodID,String foodName, String foodDescription, double foodPrice, int foodCalorie, String foodType)

    {

        // add the information of food to a TXT file

        // if the food information is added to the TXT file, it should return true;

        // if the food information cannot be added to the TXT file, it should return false;
        return false;

    }

    public boolean UpdateFood(String foodID,String foodName, String foodDescription, double foodPrice, int foodCalorie, String foodType)

    {

        //  Update the information of a given food in a TXT file

        // if the food information is updated in the TXT file, it should return true;

        // if the food information cannot be updated in the TXT file, it should
        return false;

    }

}
