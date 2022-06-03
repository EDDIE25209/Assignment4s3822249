import java.io.*;

public class Food {


    private String foodID;

    private String foodName;

    private String foodDescription;

    private double foodPrice;

    private int foodCalorie;

    private String foodType;

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getFoodCalorie() {
        return foodCalorie;
    }

    public void setFoodCalorie(int foodCalorie) {
        this.foodCalorie = foodCalorie;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public Food (String foodID,String foodName, String foodDescription, double foodPrice, int foodCalorie, String foodType)

    {
        this.foodCalorie=foodCalorie;
        this.foodID=foodID;
        this.foodName=foodName;
        this.foodDescription=foodDescription;
        this.foodPrice=foodPrice;
        this.foodType=foodType;

    }
    public Food(){}

    public boolean AddFood(String foodName, String foodDescription, double foodPrice, int foodCalorie, String foodType) throws IOException
    {
        // All the criteria check methods done for it to be a valid entry. Methods were made for checking each criteria
        if(foodNameCheck(foodName) && foodCalorieCheck(foodCalorie,foodType) && foodDescriptionCheck(foodDescription) && foodTypeCheck(foodType) && foodPriceCheck(foodCalorie,foodPrice))
        {
            //Check the number of lines to calculate the food ID number to be added
            File file1 =new File("menuitems.txt");
            long nextFoodID = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader(file1))) {
                while (reader.readLine() != null) nextFoodID++;
            } catch (IOException e) {
                e.printStackTrace();
            }

           // Creating the output text to be written into the file
           String outputText= (nextFoodID+1)+"|"+foodName+"|"+foodDescription+"|"+foodPrice+"|"+foodCalorie+"|"+foodType;

            FileWriter fw =new FileWriter(file1,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(outputText);
            pw.close();
            return true;
        }
        else return false;

    }

    // This method ensures that criteria food name is between 5 to 30 characters
    private boolean foodNameCheck(String foodName)
    {
        if (foodName.length()>30 || foodName.length()<5)
        {
            System.out.println("Food Name should be between 5 to 30 Characters ");
            return false;
        }else
            {return true;}
    }

    // This method ensures that criteria food description is between 5 to 50 words

    private boolean foodDescriptionCheck(String foodDescription)
    {
        int numOfWords = 1;

        for (int i = 0; i < foodDescription.length() - 1; i++)
        {
            if ((foodDescription.charAt(i) == ' ') && (foodDescription.charAt(i + 1) != ' '))
            {
                numOfWords++;
            }
        }
       if(numOfWords<5 || numOfWords >50 )
       {
           System.out.println(" Food Description should be between 5 and 50 words");
           return false;
       }else return true;

    }


    // Only the valid food types names are allowed to proceed here
    private boolean foodTypeCheck(String foodType)
    {
        if(foodType.compareTo("Kid Food")==0 || foodType.compareTo("Adult Food")==0 || foodType.compareTo("Healthy Food")==0 || foodType.compareTo("ElderlyFood Food")==0 ){
            return true;

        }
        else
        {
            System.out.println("The type of food can be Kid Food, Adult Food, Healthy Food, or Elderly Food");
            return false;
        }
    }

    // This Method ensures that It should not be possible to add foods with more than 1500 calorie
    //If the type of food is “Kid Food”, their calorie should be less than 800.
    private boolean foodCalorieCheck(int foodCalorie,String foodType)
    {
        if (foodCalorie>1500)
        {
            System.out.println("Calories cant be greater than 1500");
            return false;
        }
        else if(foodType.compareTo("Kid Food")==0 && foodCalorie>799)
        {
            System.out.println("For Kid Food calorie should be less than 800");
            return false;
        }
       else return true;
    }

    // This Method ensures that the price of each food should be between $5 and $150.
    //The price of foods with more than 1000 calories should be less than $100.


    private boolean foodPriceCheck(int foodCalorie,double foodPrice)
    {
        if (foodPrice>150.00 || foodPrice<5.00)
        {
            System.out.println("The price of each food should be between $5 and $150");
            return false;
        }
        else if(foodCalorie>1000 && foodPrice>= 100)
        {
            System.out.println("The price of foods with more than 1000 calories should be less than $100");
            return false;
        }
        else return true;
    }

    public boolean UpdateFood(String foodID,String foodName, String foodDescription, double foodPrice, int foodCalorie, String foodType)

    {

        //  Update the information of a given food in a TXT file

        // if the food information is updated in the TXT file, it should return true;

        // if the food information cannot be updated in the TXT file, it should
        return false;

    }

}
