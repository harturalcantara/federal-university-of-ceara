package application;

//import XML.*;
import Defines.*;
import application.Helper.*;
import java.util.*;
import java.io.*;

public class Algebra{

	XmlFile Configs;

	private int dimension;
	private List<String> sets;
	public String strError;

	private boolean ValidateInput(String input, String dimension){

		if(input.equals("") || dimension.equals("")){
			this.strError = "Exists no seted inputs\n";
			return false;
		}

		else{

			this.dimension = Helper.StringToInt(dimension);

			String obtainedInput = input.replace("{(", "").replace(")}", "").replace("),(", "&");
			this.sets = Arrays.asList(obtainedInput.split("&"));

			if(sets.size() < this.dimension){

				this.strError = "The number of subsets is lower than dimension\n";
				return false;
			}
		}

		return true;
	}

	public String GetError(){

		return this.strError;
	}


	public Double usualInternalProduct(List<Double> v, List<Double> w){

		if(v.size() != w.size()){
			this.strError = "The number of elements at this subsets is invalid\n";
			return 0.00;
		}
		else{

			Double Sum = 0.00;
			for (int it = 0; it < v.size(); it++) {
			  	
				Sum += v.get(it) * w.get(it);
			}

			return Sum;
		}
	}

	public Double InternalProduct(List<Double> v, List<Double> w){

		this.Configs = new XmlFile(Defines.AlgebraConfig);

		if(this.Configs.IsNotNull()){
			
			String rule = this.Configs.getElement("InternalProduct");

			if(rule.equals("usual")){
				return usualInternalProduct(v, w);
			}
		}

		return 0.00;
	}

	public List<Double> DotProduct(double scalar, List<Double> v){

		List<Double> vector = v;
		
		for (int it = 0; it < v.size(); it++) {
		  	Double value = vector.get(it)*scalar;

		  	vector.set(it,value);
		}

		return vector;		
	}

	public List<Double> Proj(List<Double> vector, List<Double> baseVector){

		Double vw = InternalProduct(vector, baseVector);
		Double ww = InternalProduct(vector, baseVector);
		
		
		return DotProduct((vw/ww), baseVector);
	}

	public List<String> GramSchmidt(int baseSet){

		List<String> strInternalSets = this.sets;
		List<String> resultSets = new ArrayList<String>();
		
		String strBase = strInternalSets.get(baseSet);
		resultSets.add(strBase);
		//strInternalSets.remove(baseSet);

		for(int it = 0; it < strInternalSets.size(); it++){

			if(it != baseSet){
				List<Double> uniqueSet = new ArrayList<Double>();

				uniqueSet = Helper.SetToSetValues(strBase);


				for (int itSet = 0; itSet < it; itSet++) {
					
					String currentSet = strInternalSets.get(itSet);
 

					List<Double> projection = Proj(uniqueSet, Helper.SetToSetValues(currentSet));

					uniqueSet = Helper.SubtractListDouble(uniqueSet, projection);
				}


				String set = Helper.SetValuesToSet(uniqueSet);
				resultSets.add(set);
			}
		}

		return resultSets;
	}

	public Algebra(String Input, String Dimension){

		if(ValidateInput(Input, Dimension)){

			//List<String> listSets = GramSchmidt(0);

			//System.out.println(Helper.ListSetToSetNotation(listSets));
		}
	}
}