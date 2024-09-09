package application;
import java.util.*;

public class Helper{

	public static int StringToInt(String strValue){
		
		try {
	       
			if(strValue != null)
		       return  Integer.parseInt(strValue); 

		   	System.out.println("The string value is null\n");
		   	return 0;
                   
		} catch (NumberFormatException e) {
		  
		  	System.out.println("The number format was incorrect\n");
		} 

		return 0;
	}

	public static Double StringToDouble(String strValue){
		
		try {
	       
			if(strValue != null)
		       return  Double.parseDouble(strValue); 

		   	System.out.println("The string value is null\n");
		   	return 0.00;
                   
		} catch (NumberFormatException e) {
		  
		  	System.out.println("The number format was incorrect\n");
		} 

		return 0.00;
	}


	public static List<Double> ListStringToDouble(List<String> list){

		List<Double> doubleList = new ArrayList<Double>();

		for(int i = 0; i < list.size(); i++){

			doubleList.add(StringToDouble(list.get(i)));
		}

		return doubleList;
	}
	
	public static List<Double> SetToSetValues(String set){

		List<String> strValues =  Arrays.asList(set.split(","));

		return ListStringToDouble(strValues);
	}
	
	public static String SetValuesToSet(List<Double> setValues){

		String set = "";

		for(int i = 0; i < setValues.size(); i++){
			set += setValues.get(i).toString() +",";
		}
		
		if(set.length() > 0)
			set = set.substring(0,set.length()-1);

		return set;
	}


	  public static List<Double> SubtractListDouble(List<Double> v, List<Double> w){

		if(v.size() == w.size()){
			
			List<Double> doubleList = new ArrayList<Double>();

			for(int i = 0; i < v.size(); i++){
				System.out.println(v.get(i) + "-" + w.get(i));
				doubleList.add(v.get(i) - w.get(i));
			}

			return doubleList;
		}

		return new ArrayList<Double>();
	}

	public static String ListSetToSetNotation(List<String> listSets){

		String set = "{";

		for(int i = 0; i < listSets.size(); i ++){


			set += "(" + listSets.get(i) + "),";
		}

		if(listSets.size() > 0)
			set.substring(0,set.length()-1);

		set += "}";

		return set;
	}

}