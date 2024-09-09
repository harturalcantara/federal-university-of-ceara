import Interface.*;
import application.Algebra;
import application.Helper.*;
import application.Helper;
import java.util.*;

public class Main {

    public static void main(String[] args) {

    	Algebra a = new Algebra("","");
        List<Double> v = Helper.SetToSetValues("1,2");
        List<Double> w = Helper.SetToSetValues("2,1");
    	
    	List<Double> t = a.Proj(v , w);

    	System.out.println(Helper.SetValuesToSet(t));
    }
}
