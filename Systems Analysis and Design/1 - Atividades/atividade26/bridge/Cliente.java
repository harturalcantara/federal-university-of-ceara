package bridge;

public class Cliente {
	public static void main(String[] args) {
		
		Abstracao abstracoes0 = new AbstracaoRefinada(new ImplementacaoA());
		Abstracao abstracoes1 = new AbstracaoRefinada(new ImplementacaoB());
        
		Abstracao[] abstracoes = {abstracoes1, abstracoes0};
        
		for(Abstracao abstracao : abstracoes)
            abstracao.operacao();
		
    }
}
