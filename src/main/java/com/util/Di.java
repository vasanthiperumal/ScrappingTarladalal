package com.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Di {

	static WebDriver driver;
	public static ArrayList recipeNameList = new ArrayList();
	public static ArrayList recipeid = new ArrayList();
	public static ArrayList ingredientList = new ArrayList();
	public static ArrayList prepTimeList = new ArrayList();
	public static ArrayList cookTimeList = new ArrayList();
	public static ArrayList prepMethodList = new ArrayList();
	public static ArrayList NutrientList = new ArrayList();
	public static ArrayList RecipeUrlList = new ArrayList();
	public static ArrayList<String> eliminatedList= new ArrayList<String>();
	
	public static void setup() {
		
		WebDriverManager.chromedriver().setup();			 	   
        ChromeOptions ops = new ChromeOptions();
        ops.setAcceptInsecureCerts(true);
        ops.addArguments("--remote-allow-origins=*"); 
        driver = new ChromeDriver(ops);    
        driver.manage().window().maximize();
        driver.navigate().to("https://www.tarladalal.com/");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	
    	
    	driver.findElement(By.name("ctl00$txtsearch")).sendKeys("diabetic");
        driver.findElement(By.id("ctl00_imgsearch")).click();
        driver.findElement(By.xpath("//a[@href='recipes-for-indian-diabetic-recipes-370']")).click();
      
        //driver.get("https://tarladalal.com/recipes-for-indian-diabetic-recipes-370");
		driver.manage().deleteAllCookies();
		
	}
	
	public static void recipedetails() throws InterruptedException, IOException {
		
//		for ( int p =1 ; p <=23 ; p++)
//        {
//        	WebElement Page = driver.findElement(By.xpath("//div[@id='cardholder']//div//a[contains(text(),'"+p+"')]"));
//        	Page.click();
//        	System.out.println("onpage"+p);
//        	
//        }
		 for ( int p =1 ; p <=7 ; p++)
	        {
			 
			 
			 
			 System.out.println("onpage"+p);
				String url = "https://tarladalal.com/recipes-for-indian-diabetic-recipes-370?pageindex="+p;//;
	        	//Thread.sleep(3000);
	        	driver.get(url);
		//driver.get("https://tarladalal.com/RecipeSearch.aspx?term=diabetic&pageindex="+p);
        List<WebElement> RecipeList = driver.findElements(By.xpath("//div[@class='recipelist']//article"));
	    System.out.println("Recipe list count is: "+RecipeList.size());
		
	    
	    for ( int k=1; k<=RecipeList.size(); k++)  {
	    	String s_recipeName ;
	    	String s_recipe_id ; 
	    	String s_Ingredients ;
		System.out.println("valueok"+k);
			
		WebElement recipeName = driver.findElement
				(By.xpath("//article["+k+"]//div[@class='rcc_rcpcore']/span[1]/a"));
    	//System.out.println("Name of Recipe : "+recipeName.getText());
		
    	WebElement recipe_id =
	  			  driver.findElement(By.xpath("//article["+k+"]//div[@class='rcc_rcpno']/span")); 
  
    	
    	
    	s_recipeName = recipeName.getText();
    	//recipeNameList.add(recipeName.getText());
    	
    											//article[3]//div[@class='rcc_rcpno']/span
    		s_recipe_id = recipe_id.getText();
	        	//System.out.println(s_recipe_id);
	        	
	        	String formattedrecipeid =  s_recipe_id.substring(8, s_recipe_id.length()-9);
	        	//recipeid.add(formattedrecipeid.trim());	        	
	        	System.out.println(formattedrecipeid); 
	        	
	        	 // click recipeName
	        	recipeName.click();
	        	//driver.findElement(By.xpath("//div[@class='rcc_recipecard']["+k+"]//span[@class='rcc_recipename']/a")).click();
	        	Thread.sleep(1000);
	        	WebElement Ingrediants = driver.findElement(By.xpath("//div[@id='rcpinglist']"));
	        	s_Ingredients = Ingrediants.getText();
	        	boolean s = checkIgredients(s_Ingredients);
	        	
	        	
	        	if (s)
	        	{
	        		recipeNameList.add(s_recipeName);
	        		recipeid.add(formattedrecipeid.trim());
		        	ingredientList.add(s_Ingredients);
		        	System.out.println("Ingrediants are : "+Ingrediants.getText());
		        	
		        	WebElement PrepTime = driver.findElement(By.xpath("//p//time[1]"));
		        	prepTimeList.add(PrepTime.getText());      	
		        	System.out.println("Preperation Time is : "+ PrepTime.getText());
		        	try {
		        	WebElement CookTime = driver.findElement(By.xpath("//p//time[2]"));
		        	cookTimeList.add(CookTime.getText());
		        	System.out.println("Cooking Time is : "+CookTime.getText());
		        	}catch (Exception e ) {cookTimeList.add("NA");};
		        	
		        	WebElement PrepMethod = driver.findElement(By.xpath("//div[@id='recipe_small_steps']"));
		        	prepMethodList.add(PrepMethod.getText());
		        	System.out.println("Preperation Method is : "+PrepMethod.getText());
		        	
		        	Thread.sleep(4000);
		        	try
		        	{
		        	WebElement Nutrients = driver.findElement(By.xpath("//div[@id='rcpnuts']"));
		        	NutrientList.add(Nutrients.getText());
		        	System.out.println("Nutrient Values are : "+Nutrients.getText());
		        	} catch (Exception e) {NutrientList.add("NA");};
		        	String strUrl = driver.getCurrentUrl();
		        	//String strUrl = driver.getCurrentUrl();
		        	RecipeUrlList.add(strUrl);
		        	System.out.println("Recipe URL : "+strUrl);
	        	}
//	        	
	        	
	        	//Thread.sleep(7000);
	        	//driver.navigate().back();
	        	String url1 = "https://tarladalal.com/recipes-for-indian-diabetic-recipes-370?pageindex="+p;//;
	        	
	        	driver.get(url1);
	        	Thread.sleep(5000);
	        	//Thread.sleep(8000);
	        	
		}
	       }
		 
		 
		 
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Diabeties_Recipes");
			sheet.createRow(0);
			sheet.getRow(0).createCell(0).setCellValue("RecipeId");
			sheet.getRow(0).createCell(1).setCellValue("Recipe Name");
			sheet.getRow(0).createCell(2).setCellValue("Recipe Category(Breakfast/lunch/snack/dinner)");
			sheet.getRow(0).createCell(3).setCellValue("Food Category(Veg/non-veg/vegan/Jain)");
			sheet.getRow(0).createCell(4).setCellValue("Ingredients");
			sheet.getRow(0).createCell(5).setCellValue("Preparation Time");
			sheet.getRow(0).createCell(6).setCellValue("Cooking Time");
			sheet.getRow(0).createCell(7).setCellValue("Preparation method");
			sheet.getRow(0).createCell(8).setCellValue("Nutrient values");
			sheet.getRow(0).createCell(9).setCellValue("Targetted morbid conditions (Diabeties/Hypertension/Hypothyroidism)");
			sheet.getRow(0).createCell(10).setCellValue("Recipe URL");
			
			int rowno=1;
//
			for(int i = 0; i <recipeNameList.size() ; i++)
			{
				XSSFRow row=sheet.createRow(rowno++);
				row.createCell(0).setCellValue(recipeid.get(i).toString())	;
				row.createCell(1).setCellValue(recipeNameList.get(i).toString());
				row.createCell(4).setCellValue(ingredientList.get(i).toString());
				row.createCell(5).setCellValue(prepTimeList.get(i).toString());
				row.createCell(6).setCellValue(cookTimeList.get(i).toString());
				row.createCell(7).setCellValue(prepMethodList.get(i).toString());
				row.createCell(8).setCellValue(NutrientList.get(i).toString());
				//row.createCell(9).setCellValue(NutrientList.get(i).toString());
				row.createCell(10).setCellValue(RecipeUrlList.get(i).toString());
			}
			System.out.println("Total Recipe Count"+recipeNameList.size());
			FileOutputStream FOS = new FileOutputStream(".\\datafiles\\Diabeties.xlsx");
			workbook.write(FOS);
			FOS.close();
	}
	
	/*
	 * Method to check ingredeint List
	 */
	public  static  boolean checkIgredients(String i_Ingredient)
	{
		
		

		String p_Ingredient = i_Ingredient.toLowerCase();
		System.out.println("igredeintes coming"+p_Ingredient);
		
		eliminatedList.add("cream of rice");
		eliminatedList.add("rice flour");
		eliminatedList.add("rice rava");
		eliminatedList.add("corn");
		eliminatedList.add("sugar");
		eliminatedList.add("white rice");
		eliminatedList.add("white bread");
		eliminatedList.add("pasta");
		eliminatedList.add("soda");
		eliminatedList.add("flavoured water");
		eliminatedList.add("gatorade");
		eliminatedList.add("apple juice");
		eliminatedList.add("orange juice");
		eliminatedList.add("pomegranate juice");
		eliminatedList.add("flavoured curd");
		eliminatedList.add("yogurt");
		eliminatedList.add("corn flakes");
		eliminatedList.add("puffed rice");
		eliminatedList.add("bran flakes");
		eliminatedList.add("instant oatmeal");
		eliminatedList.add("honey");
		eliminatedList.add("maple syrup");
		eliminatedList.add("jaggery");
		eliminatedList.add("sweets");
		eliminatedList.add("candies");
		eliminatedList.add("chocolates");
		eliminatedList.add("refined");
		eliminatedList.add("all purpose flour");
		eliminatedList.add("alcoholic beverages");
		eliminatedList.add("bacon");
		eliminatedList.add("sausages");
		eliminatedList.add("hot dos");
		eliminatedList.add("deli meats");
		eliminatedList.add("chicken nuggets");
		eliminatedList.add("chciken patties");
		eliminatedList.add("bacon");
		eliminatedList.add("jams");
		eliminatedList.add("jelly");
		eliminatedList.add("mango");
		eliminatedList.add("cucumber");
		eliminatedList.add("tomatoes");
		eliminatedList.add("pineapple");
		eliminatedList.add("peaches");
		eliminatedList.add("mangos ");
		eliminatedList.add("pear");
		eliminatedList.add("mixed");
		eliminatedList.add("fruit");
		eliminatedList.add("mandarine");
		eliminatedList.add("oranges");
		eliminatedList.add("cherries");
		eliminatedList.add("chips");
		eliminatedList.add("mayonnaise");
		eliminatedList.add("palmolein oil");
		eliminatedList.add("powdered milk");
		eliminatedList.add("beans");
		eliminatedList.add("peas");
		eliminatedList.add("corn");
		eliminatedList.add("doughnuts");
		eliminatedList.add("cakes");
		eliminatedList.add("pastries");
		eliminatedList.add("cookies");
		eliminatedList.add("croissants");
		eliminatedList.add("sweetened tea");
		eliminatedList.add("coffee");
		eliminatedList.add("packaged snacks");
		eliminatedList.add("soft drinks");
		eliminatedList.add("banana");
		eliminatedList.add("melon");
		eliminatedList.add("dairy milk");
		eliminatedList.add("butter");
		eliminatedList.add("cheese");

		
		//ing compare with arraylist
		boolean isIngrediant=true;
		
		for(String v:eliminatedList)
		
		{
			
			
			
			if (p_Ingredient.contains(v)) //p_Ingredient
			{
				System.out.println("Eliminated::"+p_Ingredient+"because of "+v+"recepid"+"");
				
				isIngrediant=false;
				
				
				break;
			}
		}


		return isIngrediant;
			
			
	
	}
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		setup();
		recipedetails();
								
		
	}
	
}
