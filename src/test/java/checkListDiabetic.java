import java.io.IOException;
import java.util.ArrayList;



public class checkListDiabetic 
{

public static ArrayList<String> eliminatedList = new ArrayList<String>();




	static boolean checkIngrediant1(String i_Ingredient) 
	{
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

		String p_Ingredient = i_Ingredient.toLowerCase();
		System.out.println("igredeintes coming" + p_Ingredient);

		boolean isIngrediant = true;
		for (String v : eliminatedList) {
			if (p_Ingredient.contains(v)) // p_Ingredient
			{
				System.out.println("Eliminated::" + p_Ingredient + "because of " + v + "recepid" + "");
				isIngrediant = false;
				break;
			}
		}

		return isIngrediant;

	}
	
	
	}
	
	



	
	


