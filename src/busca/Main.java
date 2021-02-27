package busca;

public class Main {

	public static void main(String[] args) {
		
		// Cadastrar os nos
		No no0 = new No(0);
		No no1 = new No(1);
		No no2 = new No(2);
		No no3 = new No(3);
		No no4 = new No(4);
		No no5 = new No(5);
		No no6 = new No(6);
		No no7 = new No(7);
		
		// Associar os nos
		no0.setNoEsquerda(no1);
		no0.setNoDireita(no2);
		
		no1.setNoEsquerda(no5);
		no1.setNoDireita(no6);
		
		no2.setNoEsquerda(no3);
		no2.setNoDireita(no4);
		
		no4.setNoEsquerda(no7);
		
		/*
		 *  Executar o algoritimo
		 */
		// Cria instancia informando o valor a ser encontrado
		BuscaLargura bel = new BuscaLargura(4);
		// Inicia o processamento passando o no principal
		bel.processarBusca(no0);
		// Exibe o resultado do processamento
		bel.exibirTextoResultado();
		
	}

}
