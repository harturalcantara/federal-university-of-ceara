package padrao.comportamental.iterator;

public class Cliente{

	public static void main(String a[]){
		
		ColecaoContato clc = new ColecaoContato(20);
		clc.add(new Contato(1080,"Nome 1", "88888 - 88888"));
		clc.add(new Contato(1090,"Nome 2", "88888 - 88888"));
		clc.add(new Contato(1100,"Nome 3", "88888 - 88888"));
		
		while(clc.hasNext()){
			System.out.println(clc.next());
		}
		
	}
	
}
