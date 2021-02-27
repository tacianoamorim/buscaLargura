package busca;
public class ProcessarAlgoritimo {

	private static ProcessarAlgoritimo instance;

	private ProcessarAlgoritimo() {
	}

	public static ProcessarAlgoritimo getIntance() {
		if (instance == null) {
			instance = new ProcessarAlgoritimo();
		}
		return instance;
	}

	public void iniciarProcessamento22(String[] array) {
		
		
//		System.out.println("######################################################## ");
//		System.out.println("# NIVEL 0 ");
//		System.out.println("######################################################## ");
//		No no= BuscaLargura.getIntance().criarNo(array);
		
		// Nivel 01
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
//		String[] array01= {"B", "H", "C", "A", "F", "D", "G", "", "E"};
//		No no01= new No(1, 
//				"No_01", 
//				BuscaLargura.getIntance().calcularHeuristica(array01), array01);
//
//		// Nivel 02 
//		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 		
//		String[] array02= {"B", "H", "C", "A", "F", "D", "", "G", "E"};
//		No no02= new No("No_02", BuscaLargura.getIntance().calcularHeuristica(array02), array02);
//		String[] array03= {"B", "H", "C", "A", "", "D", "G", "F", "E"};
//		No no03= new No("No_03", BuscaLargura.getIntance().calcularHeuristica(array03), array03);
//		String[] array04= {"B", "H", "C", "A", "F", "D", "G", "E", ""};
//		No no04= new No("No_04", BuscaLargura.getIntance().calcularHeuristica(array04), array04);		
//		
//		no01.addFilho(no02);
//		no01.addFilho(no03);
//		no01.addFilho(no04);
//		
//		// Nivel 03
//		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
//		String[] array05= {"B", "H", "C", "", "A", "D", "G", "F", "E"};
//		No no05= new No("No_05", BuscaLargura.getIntance().calcularHeuristica(array05), array05);
//		String[] array06= {"B", "", "C", "A", "H", "D", "G", "F", "E"};
//		No no06= new No("No_06", BuscaLargura.getIntance().calcularHeuristica(array06), array06);
//		String[] array07= {"B", "H", "C", "A", "D", "", "G", "F", "E"};
//		No no07= new No("No_07", BuscaLargura.getIntance().calcularHeuristica(array07), array07);
//		
//		no03.addFilho(no05);
//		no03.addFilho(no06);
//		no03.addFilho(no07);
//		
//		// Nivel 04
//		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
//		String[] array08= {"B", "H", "C", "A", "", "D", "G", "F", "E"};
//		No no08= new No("No_08", BuscaLargura.getIntance().calcularHeuristica(array08), array08);
//		String[] array09= {"", "B", "C", "A", "H", "D", "G", "F", "E"};
//		No no09= new No("No_09", BuscaLargura.getIntance().calcularHeuristica(array09), array09);
//		String[] array10= {"B", "C", "H", "A", "H", "D", "G", "F", "E"};
//		No no10= new No("No_10", BuscaLargura.getIntance().calcularHeuristica(array10), array10);
//		
//		no06.addFilho(no08);
//		no06.addFilho(no09);
//		no06.addFilho(no10);
//	
//		// Nivel 05
//		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
//		String[] array11= {"A", "B", "C", "", "H", "D", "G", "F", "E"};
//		No no11= new No("No_11", BuscaLargura.getIntance().calcularHeuristica(array11), array11);
//		String[] array12= {"B", "", "C", "A", "H", "D", "G", "F", "E"};
//		No no12= new No("No_12", BuscaLargura.getIntance().calcularHeuristica(array12), array12);
//		
//		no09.addFilho(no11);
//		no09.addFilho(no12);
//		
//		
//		// Nivel 05
//		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
//		String[] array13= {"", "B", "C", "A", "H", "D", "G", "F", "E"};
//		No no13= new No("No_13", BuscaLargura.getIntance().calcularHeuristica(array13), array13);
////		String[] array14= {"A", "B", "C", "H", "", "D", "G", "F", "E"};
////		No no14= new No("No_14", BuscaLargura.getIntance().calcularHeuristica(array14), array14);
//		String[] array15= {"A", "B", "C", "G", "H", "D", "", "F", "E"};
//		No no15= new No("No_15", BuscaLargura.getIntance().calcularHeuristica(array15), array15);		
//		
//		no11.addFilho(no13);
////		no11.addFilho(no14);
//		no11.addFilho(no15);		
		
//		/*
//		 *  Executar o algoritimo
//		 */
//		// Inicia o processamento passando o no principal
//		BuscaLargura.getIntance().processarBusca(no);
//		
//		// Exibe o resultado do processamento
//		String msg= BuscaLargura.getIntance().exibirTextoResultado();		
//		System.out.println(msg);
	}
	
}
