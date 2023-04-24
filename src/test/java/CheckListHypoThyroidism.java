import java.util.ArrayList;
import java.util.Arrays;

public class CheckListHypoThyroidism {

	  public static ArrayList < String > IngredientsEliminationList;
	  public static ArrayList < String > IngredientsAddList= new ArrayList();
	  public static ArrayList < String > AllergyList= new ArrayList();
	

	  public static boolean checkMatchedingredients(String ingredientsList) {

	    boolean isingredientMatched = false;

	    try {
	      /*ExcelReaderUtility readInfo = new ExcelReaderUtility();
	      readInfo.main(null);
	      ArrayList < String > EliminatedList = readInfo.EliminationList;
	      //System.out.println("Inside checkMatchedingredients ingredientList" + ingredientsList);
	      //System.out.println("Inside checkMatchedingredients readInfo.EliminationList" + EliminatedList);*/

	      IngredientsEliminationList = new ArrayList < String > (Arrays.asList("Tofu", "Edamame", "Tempeh",
	        "Cauliflower", "cabbage", "Broccoli", "Kale", "Spinach", "Sweet potatoes",
	        "Strawberries", "Pine nuts", "Peanuts", "Peaches", "Green tea", "Coffee", "Alcohol",
	        "Soy milk", "White bread", "Cakes", " pastries", "Fried food", "sugar", "Processed food- ham",
	        " bacon", " salami", " sausages", "Frozen food", "Gluten", "Sodas", "Energy drinks ",
	        "containing caffeine", "Packaged food- noodles", "soups", "soup", "salad dressings",
	        "sauces", "Candies"));

	      for (String v: IngredientsEliminationList)

	      {
	        if (ingredientsList.toLowerCase().trim().contains(v)) {
	          isingredientMatched = true;
	          System.out.println("Eliminated$$$$$$$$$$$" + isingredientMatched + "because of " + v + " ingredient  " + "");
	          break;
	        }
	      }

	    } catch (Exception e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return isingredientMatched;

	  }

	  public static String checkToAddIngredients(String ingredientsList) {
	    String isIngredientAdd = "";

	    try {

	      IngredientsAddList = new ArrayList < String > (Arrays.asList("Saltwater fish", "oyesters", " shellfish", "eggs",
	        "Dairy", "milk", "Butter", "Cheese", "curd","curds", "Nuts", "Chicken", "Pumpkin seeds", "Seaweed", "Iodized salt", "Brazil nuts",
	        "Blue berries", "Low-fat yogurt",
	        "Brown rice", "quinoa", "Mushroom"));
	      
	      for (String toaddingredient: IngredientsAddList)

	      {
	        if (ingredientsList.contains(toaddingredient))
	        {
	          System.out.println("addedingredeint::" + ingredientsList + "because of " + toaddingredient + "recepid" + "");

	          isIngredientAdd = toaddingredient;

	          break;
	        }
	      }
	    } catch (Exception e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }

	    return isIngredientAdd;

	  }
	  
	  public static String checkAllergyIngredients(String ingredientsList) {
		    String isAllergyIngredient = "";

		    try {

		    	AllergyList = new ArrayList < String > (Arrays.asList("milk","soy","eggs","sesame","peanuts","walnut","almond","hazelnut",
		    		  "pecan","cashew","pistachio","shell fish","seafood"));
		      for (String allergyingredient: AllergyList)

		      {
		        if (ingredientsList.contains(allergyingredient)) //p_Ingredient
		        {
		          System.out.println("allergyingredient::" + ingredientsList + "because of " + allergyingredient + "recepid" + "");

		          isAllergyIngredient = allergyingredient;

		          break;
		        }
		      }
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }

		    return isAllergyIngredient;

		  }	
}
