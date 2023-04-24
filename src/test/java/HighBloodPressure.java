
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.util.ExcelReader;

public class HighBloodPressure extends BaseTest {
	public static ArrayList<String> recipeid = new ArrayList<String>();
	public static ArrayList<String> recipeName = new ArrayList<String>();
	public static ArrayList<String> ingredientList = new ArrayList<String>();
	public static ArrayList<String> prepTime = new ArrayList<String>();
	public static ArrayList<String> cookTime = new ArrayList<String>();
	public static ArrayList<String> prepMethod = new ArrayList<String>();
	public static ArrayList<String> NutrientList = new ArrayList<String>();
	public static ArrayList<String> RecipeUrlList = new ArrayList<String>();
	public static  String nutrients ;
	public static String ct;

	@Test
	public static void highBloodPressure() throws InterruptedException, IOException {

		driver.findElement(By.xpath("//input[@id='ctl00_txtsearch']")).sendKeys("High Blood Pressure");
		driver.findElement(By.id("ctl00_imgsearch")).click();
		for (int p = 1; p <= 3; p++) {

			System.out.println("onpage:" + p);
			// String url
			/*
			 * ="https://www.tarladalal.com/RecipeSearch.aspx?term=High%20Blood%20Pressure&pageindex="
			 * +p; driver.get(url);
			 */

			
			  List<WebElement> RecipeList =
			  driver.findElements(By.xpath("//div[@class='rcc_recipecard']"));
			  System.out.println(RecipeList.size());
			 
			driver.findElement(By.xpath("//div[@id='cardholder']//div[3]//a[" + p + "]")).click();
			Thread.sleep(2000);

			for (int k = 1; k < RecipeList.size(); k++)

			{
				try
				{
				
				// recipe id
				WebElement r_id = driver.findElement(By.xpath("(//div[@class='rcc_recipecard'])[" + k + "]//span"));
				String s = r_id.getText();
				String formattedrecipeid = s.substring(8, s.length() - 9);
				// recipeid.add(formattedrecipeid.trim());
				System.out.println(formattedrecipeid);
				System.out.println(s);

				// Recipe name

				WebElement recipename = driver.findElement(
				By.xpath("//div[@class='rcc_recipecard'][" + k + "]//span[@class='rcc_recipename']/a"));
				String r = recipename.getText();
				System.out.println("Recipe Name:" + r);
				// recipeName.add(r);

				// click on Recipe
				driver.findElement(By.xpath("//div[@class='rcc_recipecard'][" + k + "]//span[@class='rcc_recipename']/a")).click();
				Thread.sleep(1000);

				// ingredient
				String Ingrediants = driver.findElement(By.xpath("//div[@id='rcpinglist']")).getText();
				System.out.println("Ingrediants are : " + Ingrediants);
				boolean isIngrediant = CheckList.checkIngrediant(Ingrediants);

				
				  // preparation Time
				WebElement Preptime =driver.findElement(By.xpath("//p//time[1]"));
				String pt = Preptime.getText();
				 

				// cook time
				
				  WebElement Cooktime = driver.findElement(By.xpath("//p//time[2]")); 
				  ct = Cooktime.getText();
				 

				// preparation method
				
				  WebElement Prepmethod =
				  driver.findElement(By.xpath("//div[@id='recipe_small_steps']")); String pm =
				  Prepmethod.getText();
				 
				// nutrients
				
				  try
				  { 
					   nutrients = driver.findElement(By.xpath("//div[@id='rcpnuts']")).getText();
				  
				  }
				  catch(Exception e) 
				  {
					  System.out.println("not available");
				  }
				  
					String strUrl = driver.getCurrentUrl();
					RecipeUrlList.add(strUrl);
					System.out.println("Recipe URL : " + strUrl);
				 
				if (isIngrediant)
				{
					recipeid.add(formattedrecipeid.trim());
					recipeName.add(r);

					ingredientList.add(Ingrediants);
					System.out.println("Ingrediants are : " + Ingrediants);

					
					  prepTime.add(pt); System.out.println("Preperation Time is : " + pt);
					 
					
					  try { cookTime.add(ct); System.out.println("Cooking Time is : " +
					  Cooktime.getText()); } catch (Exception e) { cookTime.add("NA"); }
					 
					Thread.sleep(4000);

					// preparation method
					
					  prepMethod.add(pm); System.out.println("Preperation Method is : " +
					  Prepmethod.getText());
					 
					Thread.sleep(4000);
					
					
					  try
					  {
					  
					  NutrientList.add(nutrients); 
					  System.out.println("Nutrient Values are : " + nutrients); 
					  } 
					  catch(Exception e) 
					  {
						  NutrientList.add("NA"); 
					  }
				
				

				}
				Thread.sleep(6000);
				String Url = "https://www.tarladalal.com/RecipeSearch.aspx?term=high%20blood%20pressure&pageindex=" + p;
				driver.get(Url);
				Thread.sleep(6000);

			}
			catch(Exception e)
			  {
				System.out.println("no such element"+e.getMessage());
			  }
			 

		}
		System.out.println(recipeName.size());
		
		ExcelReader xlreader = new ExcelReader(".\\datafiles\\SmartScrapers.xlsx");
		xlreader.setcelldata("HyperTension", 0, 0, "recipeid");
		xlreader.setcelldata("HyperTension", 0, 1, "recipename");

		xlreader.setcelldata("HyperTension", 0, 2, "ingrediant");

		xlreader.setcelldata("HyperTension", 0, 3, "preparation Time");
		xlreader.setcelldata("HyperTension", 0, 4, "cook Time");

		xlreader.setcelldata("HyperTension", 0, 5, "preparation method");
		xlreader.setcelldata("HyperTension", 0, 6, "Nutrients");
		xlreader.setcelldata("HyperTension", 0, 7, "url");
		
				
				for (int a = 0; a <=recipeName.size(); a++) 
				{
					try
					{
					xlreader.setcelldata("HyperTension", a+1, 0, recipeid.get(a));
					xlreader.setcelldata("HyperTension", a+1, 1, recipeName.get(a));
					xlreader.setcelldata("HyperTension", a+1, 2, ingredientList.get(a));

					xlreader.setcelldata("HyperTension", a+1, 3, prepTime.get(a));
					xlreader.setcelldata("HyperTension", a+1, 4, cookTime.get(a));
					xlreader.setcelldata("HyperTension", a+1, 5, prepMethod.get(a)); 
					xlreader.setcelldata("HyperTension", a+1, 6, NutrientList.get(a));
					xlreader.setcelldata("HyperTension", a+1, 7, RecipeUrlList.get(a));
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}

				}
		 
	}

}}
