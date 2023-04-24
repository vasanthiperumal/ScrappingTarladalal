import java.io.IOException;
import java.util.ArrayList;

import com.util.ExcelReader;

public class CheckList {
	
	
	
	  public static ArrayList<String> eliminatedList = new ArrayList<String>();
	  
	 
	
	
	static boolean checkIngrediant(String i_Ingredient) 
	{
		eliminatedList.add("salt");
		eliminatedList.add("chips");
		eliminatedList.add("pretzel");
		eliminatedList.add("crackers");
		eliminatedList.add("coffee");
		eliminatedList.add("tea");
		eliminatedList.add("caffeine");
		eliminatedList.add("alcohol");
		eliminatedList.add("soft Drink");
		eliminatedList.add("frozen food");
		eliminatedList.add("pickles");
		eliminatedList.add("processed food");
		eliminatedList.add("canned food");

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
	
	


