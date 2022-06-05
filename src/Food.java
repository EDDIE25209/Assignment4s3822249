import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

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

    public boolean addFood(String foodName, String foodDescription, double foodPrice, int foodCalorie, String foodType) throws IOException
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
   // Food is updated according to the input of the column number,FOOD id and the proposed value of change if the criteria are met the txt file is updated
    public boolean UpdateFood(String File, String FoodID, int columnNo , String value) throws IOException {
        ArrayList <Food>foodItems= readFoodDetails(File);

        //Check is food item exists
        boolean foodExists=false;
        boolean changeMade =false;


       for(int i = 0 ; i< foodItems.size();i++)
       {
           if(foodItems.get(i).getFoodID().compareTo(FoodID)==0)
           {
               foodExists=true;

               if (columnNo==2)
               {
                   if(foodNameCheck(value))
                   {
                       foodItems.get(i).setFoodName(value);
                       writeFoodToText(foodItems);
                       changeMade=true;
                   }

               }else if (columnNo==3)
               {
                   if(foodDescriptionCheck(value))
                   {
                       foodItems.get(i).setFoodDescription(value);
                       writeFoodToText(foodItems);
                       changeMade = true;
                   }

               }else if(columnNo ==4)
               {
                   if(foodPriceCheck(foodItems.get(i).getFoodCalorie(),Double.parseDouble(value)))
                   {
                       if(Double.parseDouble(value)>(foodItems.get(i).foodPrice*1.10))
                       {
                           System.out.println("New Price cannot be increased by more than 10 percent - "+(foodItems.get(i).foodPrice*1.10));
                       }
                       else
                       {
                           foodItems.get(i).setFoodPrice(Double.parseDouble(value));
                           writeFoodToText(foodItems);
                           changeMade = true;
                       }
                   }


               }else if(columnNo ==5)
               {
                   System.out.println("Calories cannot be changed");

               }else if(columnNo ==6)
               {
                   if(foodTypeCheck(value))
                   {
                       if(value.compareTo("Kid Food")==0)
                       {
                           System.out.println("It should not be possible to change the type of food to “Kid Food” or the Food Type is already Kid Food");
                       }
                       else
                       {
                           foodItems.get(i).setFoodType(value);
                           writeFoodToText(foodItems);
                           changeMade = true;
                       }
                   }

               }else

                   {
                       System.out.println("Invalid Column number");
                   }

           }
       }
        if(!foodExists)
        {
            System.out.println("Food Item not found");
        }

        if(changeMade)
        {
            return true;
        }else return false;

    }
    public static ArrayList<Food> readFoodDetails(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner s= new Scanner(file);

        ArrayList<Food> foodList =new ArrayList<>();

        while(s.hasNextLine())
        {
            String line =s.nextLine();
            String[] foodItems = line.split("\\|");
            String foodID = foodItems[0];
            String foodName= foodItems[1];
            String foodDescription= foodItems[2];
            Double foodPrice= Double.parseDouble(foodItems[3]);
            Integer foodCalorie= Integer.parseInt(foodItems[4]);
            String foodType= foodItems[5];

            Food food = new Food(foodID,foodName,foodDescription,foodPrice,foodCalorie,foodType);
            foodList.add(food);
        }
        return foodList;
    }

    public void writeFoodToText(ArrayList<Food> foodItems) throws IOException {
            //Erase Old Contents

            File file1 = new File("menuitems.txt");
            PrintWriter writer = new PrintWriter(file1);
            writer.print("");
            writer.close();

            //Add the contents to be written into text file from the list

       for(int i = 0 ; i < foodItems.size();i++)
       {
           String outputText= foodItems.get(i).getFoodID()+"|"+foodItems.get(i).getFoodName()+"|"+foodItems.get(i).getFoodDescription()+"|"+foodItems.get(i).getFoodPrice()+"|"+foodItems.get(i).getFoodCalorie()+"|"+foodItems.get(i).getFoodType();

           FileWriter fw =new FileWriter(file1,true);
           PrintWriter pw = new PrintWriter(fw);
           pw.println(outputText);
           pw.close();
       }


        }

}
