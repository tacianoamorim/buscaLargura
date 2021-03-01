import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BuscaLargura {
	
	private static BuscaLargura instance;
	private Queue<No> nos = new LinkedList<No>();
	private String textoResposta;
	private int idxNo= 0;
	private int idxProfundidade= 1;
	private String[] arrayReferencia= new String[9];
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *  INSTANCIA
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	private BuscaLargura() {}

	public static BuscaLargura getIntance() {
		if (instance == null) {
			instance = new BuscaLargura();
		}
		return instance;
	}

	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *  ALGORITIMO DE CLASSIFICACAO
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	public void iniciarProcessamento(String[] arrayAleatorio, String[] arrayReferencia) {
		
		this.idxNo= 0;
		this.idxProfundidade= 1;
		this.arrayReferencia= arrayReferencia;
		
		No no= criarNo(arrayAleatorio);
		No noRef= criarNo(arrayReferencia);
		System.out.println("######################################################## ");
		System.out.println("# NIVEL "+ idxProfundidade++ );
		System.out.println("# PAI "+ no.toStringResumido());
		System.out.println("# REF "+ noRef.toStringResumido());
		System.out.println("######################################################## ");

		processarBusca(no);
	}
	
	public No preCalculo(String[] arrayAleatorio, String[] arrayReferencia) {
		this.idxNo= 0;
		this.idxProfundidade= 1;
		this.arrayReferencia= arrayReferencia;
		return criarNo(arrayAleatorio);
	}
	
	private boolean processarBusca(No no) {
		
		// Testa para ver se o resultado foi alcancado
		if ( no.getValorHeuristica() == 0 ) {
			obterResultadoNoPai(no);
			return true;

		} else {

			// Gera os filhos
			expandirNo(no);
			
			for (No noFilho : no.getFilhos() ) {
				if ( !existeArray(noFilho.getArray()) )
					this.nos.add(noFilho);
			}
			
			No noPonta = this.nos.poll();
			if ( noPonta != null && processarBusca(noPonta) ) {
				return true;
			}		
		}
		return false;
	}
	
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *  TRATAMENTO E EXIBICAO DE RESULTADO
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	public String exibirTextoResultado() {
		String msg= "O No objetivo não foi encontrado.";
		if ( this.textoResposta != null ) {
			msg= "O caminho percorrido foi: " + this.textoResposta;
		} 
		return msg;
	}
	
	private void obterResultadoNoPai(No no) {
		String retorno = "";
		No noValor = no;
		retorno += noValor.getNome()+ "("+ noValor.getValorHeuristica()+") ";
		while ( noValor.getNoPai() != null ) {
			noValor = noValor.getNoPai();
			retorno = noValor.getNome()+ "("+ noValor.getValorHeuristica()+")["+ Arrays.toString(noValor.getArray()) +"]  > " + retorno;
		}
		this.textoResposta = retorno;
	}
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *  CRIAR E EXPANDIR O NÓ
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	private No criarNo(String[] array) {
		String nome= "No_";
		int idx= ++idxNo;
		if ( idx < 10) {
			nome= "No_00"+ idxNo;
		} else if ( idx < 100) {
			nome= "No_0"+ idxNo;
		} else {
			nome= "No_"+ idxNo;
		}

		No no= new No( 
				idx, 
				nome, 
				BuscaLargura.getIntance().calcularHeuristica(array), 
				array
				);
		
		//System.out.println("- NEW NO -> "+ no);
		return no;
	}
	
	private void expandirNo(No no) {
		// identifica o no vazio
		int idxVazio= getIndex(no);
		
		System.out.println();
		System.out.println("# NIVEL "+ idxProfundidade++ );
		
		if ( idxVazio == 0 ) {
			// 1
			No no0= criarNo(trocaPosicaoArray(0, 1, no));
			no.addFilho(no0);
			// 3			
			No no1= criarNo(trocaPosicaoArray(0, 3, no));
			no.addFilho(no1);
			
		} else if ( idxVazio == 1 ) {
			// 0
			No no0= criarNo(trocaPosicaoArray(1, 0, no));
			no.addFilho(no0);			
			// 2	
			No no1= criarNo(trocaPosicaoArray(1, 2, no));
			no.addFilho(no1);	
			// 4
			No no2= criarNo(trocaPosicaoArray(1, 4, no));
			no.addFilho(no2);	
			
		} else if ( idxVazio == 2 ) {
			// 1
			No no0= criarNo(trocaPosicaoArray(2, 1, no));
			no.addFilho(no0);			
			// 5	
			No no1= criarNo(trocaPosicaoArray(2, 5, no));
			no.addFilho(no1);
			
		} else if ( idxVazio == 3 ) {
			// 0
			No no0= criarNo(trocaPosicaoArray(3, 0, no));
			no.addFilho(no0);			
			// 4	
			No no1= criarNo(trocaPosicaoArray(3, 4, no));
			no.addFilho(no1);	
			// 6
			No no2= criarNo(trocaPosicaoArray(3, 6, no));
			no.addFilho(no2);				
			
		} else if ( idxVazio == 4 ) {
			// 1
			No no0= criarNo(trocaPosicaoArray(4, 1, no));
			no.addFilho(no0);			
			// 3	
			No no1= criarNo(trocaPosicaoArray(4, 3, no));
			no.addFilho(no1);	
			// 5
			No no2= criarNo(trocaPosicaoArray(4, 5, no));
			no.addFilho(no2);
			// 7
			No no3= criarNo(trocaPosicaoArray(4, 7, no));
			no.addFilho(no3);
			
		} else if ( idxVazio == 5 ) {
			// 2
			No no0= criarNo(trocaPosicaoArray(5, 2, no));
			no.addFilho(no0);			
			// 4	
			No no1= criarNo(trocaPosicaoArray(5, 4, no));
			no.addFilho(no1);	
			// 8
			No no2= criarNo(trocaPosicaoArray(5, 8, no));
			no.addFilho(no2);
			
		} else if ( idxVazio == 6 ) {
			// 3
			No no0= criarNo(trocaPosicaoArray(6, 3, no));
			no.addFilho(no0);			
			// 7	
			No no1= criarNo(trocaPosicaoArray(6, 7, no));
			no.addFilho(no1);	
			
		} else if ( idxVazio == 7 ) {
			// 4
			No no0= criarNo(trocaPosicaoArray(7, 4, no));
			no.addFilho(no0);			
			// 6	
			No no1= criarNo(trocaPosicaoArray(7, 6, no));
			no.addFilho(no1);	
			// 8
			No no2= criarNo(trocaPosicaoArray(7, 8, no));
			no.addFilho(no2);
			
		} else if ( idxVazio == 8 ) {
			// 5
			No no0= criarNo(trocaPosicaoArray(8, 5, no));
			no.addFilho(no0);			
			// 7	
			No no1= criarNo(trocaPosicaoArray(8, 7, no));
			no.addFilho(no1);	
		}
		
		for (No noFilho : no.getFilhos()) {
			System.out.println("# FILHO "+ noFilho.toStringResumido());
		}
		System.out.println("######################################################## ");
		
	}	
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *  CALCULAR HEURISTICA
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * */	
	private int calcularHeuristica(String[] array) {
		int heuristica= 0;
		for (int i = 0; i < array.length; i++) {
			String letra= array[i];
			//System.out.print("Letra: "+ letra +"("+i+")"  );
			int qtdePassos= getQuantidadePassos(letra.trim(), i);
			heuristica= heuristica + qtdePassos;
			//System.out.println( " ("+qtdePassos+")");
		}
		return heuristica;
	}	
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *  TRATAMENTO NO ARRAY
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	private boolean existeArray(String[] array) {
		boolean achei= false;
		for (No no : this.nos) {
			if (array[0].equals(no.getArray()[0]) && 
				array[1].equals(no.getArray()[1]) && 
				array[2].equals(no.getArray()[2]) && 
				array[3].equals(no.getArray()[3]) && 
				array[4].equals(no.getArray()[4]) && 
				array[5].equals(no.getArray()[5]) && 
				array[6].equals(no.getArray()[6]) && 
				array[7].equals(no.getArray()[7]) && 
				array[8].equals(no.getArray()[8]) 
			) {
				achei= true;
				break;
			}
		}
		return achei;
	}
	
	private String[] trocaPosicaoArray(int idxAtual, int idxDestino, No noRef) {
		String[] array= clonarArray(noRef.getArray());
		array[idxDestino]= noRef.getArray()[idxAtual];
		array[idxAtual]= noRef.getArray()[idxDestino];
		return array;
	}

	private String[] clonarArray(String[] array) {
		String[] arrayClone= new String[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayClone[i]= array[i];
		}
		return arrayClone;
	}

	private int getIndex(No no) {
		int idx= 0;
		for (int i = 0; i < no.getArray().length; i++) {
			if ( "".equals(no.getArray()[i]) ) {
				idx= i;
				break;
			}
		}
		return idx;
	}
	
	private int getQuantidadePassos(String letra, Integer idxAtual) {
		int qtdePassos= 0;
		if ( !letra.trim().equals("")) {
			qtdePassos= getPassosDestinoOrigem(getIdxLetraRef(letra), idxAtual);
		}
		return qtdePassos;
	}
	
	private Integer getIdxLetraRef(String letra) {
		int idx= 0;
		for (int i = 0; i < arrayReferencia.length; i++) {
			if ( letra.trim().equals( arrayReferencia[i].trim() ) ) {
				idx= i;
				break;
			}
		}
		//System.out.println("    Target: ("+idx+")"  );
		return idx;
	}

	private int getPassosDestinoOrigem(Integer idxDesejado, Integer idxAtual) {
		int qtdePassos= 0;
		
		if ( idxDesejado != idxAtual) {
			
			if ( 
				( (idxDesejado == 0 && idxAtual == 1) || (idxDesejado == 1 && idxAtual == 0) ) ||
				( (idxDesejado == 0 && idxAtual == 3) || (idxDesejado == 3 && idxAtual == 0) ) ||
				( (idxDesejado == 1 && idxAtual == 2) || (idxDesejado == 2 && idxAtual == 1) ) ||
				( (idxDesejado == 1 && idxAtual == 4) || (idxDesejado == 4 && idxAtual == 1) ) ||	
				( (idxDesejado == 2 && idxAtual == 5) || (idxDesejado == 5 && idxAtual == 2) ) ||
				( (idxDesejado == 3 && idxAtual == 4) || (idxDesejado == 4 && idxAtual == 3) ) ||	
				( (idxDesejado == 3 && idxAtual == 6) || (idxDesejado == 6 && idxAtual == 3) ) ||
				( (idxDesejado == 4 && idxAtual == 5) || (idxDesejado == 5 && idxAtual == 4) ) ||
				( (idxDesejado == 4 && idxAtual == 7) || (idxDesejado == 7 && idxAtual == 4) ) ||
				( (idxDesejado == 5 && idxAtual == 8) || (idxDesejado == 8 && idxAtual == 5) ) ||
				( (idxDesejado == 6 && idxAtual == 7) || (idxDesejado == 7 && idxAtual == 6) ) ||
				( (idxDesejado == 7 && idxAtual == 8) || (idxDesejado == 8 && idxAtual == 7) ) 
			   ) {
				
				qtdePassos= 1;
			
			} else if ( 
					( (idxDesejado == 0 && idxAtual == 2) || (idxDesejado == 2 && idxAtual == 0) ) ||
					( (idxDesejado == 0 && idxAtual == 4) || (idxDesejado == 4 && idxAtual == 0) ) ||
					( (idxDesejado == 0 && idxAtual == 6) || (idxDesejado == 6 && idxAtual == 0) ) ||
					( (idxDesejado == 1 && idxAtual == 3) || (idxDesejado == 3 && idxAtual == 1) ) ||	
					( (idxDesejado == 1 && idxAtual == 5) || (idxDesejado == 5 && idxAtual == 1) ) ||
					( (idxDesejado == 1 && idxAtual == 7) || (idxDesejado == 7 && idxAtual == 1) ) ||
					( (idxDesejado == 2 && idxAtual == 4) || (idxDesejado == 4 && idxAtual == 2) ) ||
					( (idxDesejado == 2 && idxAtual == 8) || (idxDesejado == 8 && idxAtual == 2) ) ||					
					( (idxDesejado == 3 && idxAtual == 5) || (idxDesejado == 5 && idxAtual == 3) ) ||
					( (idxDesejado == 3 && idxAtual == 7) || (idxDesejado == 7 && idxAtual == 3) ) ||
					( (idxDesejado == 4 && idxAtual == 6) || (idxDesejado == 6 && idxAtual == 4) ) ||
					( (idxDesejado == 4 && idxAtual == 8) || (idxDesejado == 8 && idxAtual == 4) ) ||
					( (idxDesejado == 5 && idxAtual == 7) || (idxDesejado == 7 && idxAtual == 5) ) ||
					( (idxDesejado == 6 && idxAtual == 8) || (idxDesejado == 8 && idxAtual == 6) )
				    ) {
				
				qtdePassos= 2;
				
			} else if ( 
					( (idxDesejado == 0 && idxAtual == 5) || (idxDesejado == 5 && idxAtual == 0) ) ||
					( (idxDesejado == 0 && idxAtual == 7) || (idxDesejado == 7 && idxAtual == 0) ) ||
					( (idxDesejado == 1 && idxAtual == 6) || (idxDesejado == 6 && idxAtual == 1) ) ||
					( (idxDesejado == 1 && idxAtual == 8) || (idxDesejado == 8 && idxAtual == 1) ) ||
					( (idxDesejado == 2 && idxAtual == 3) || (idxDesejado == 3 && idxAtual == 2) ) ||
					( (idxDesejado == 2 && idxAtual == 7) || (idxDesejado == 7 && idxAtual == 2) ) ||
					( (idxDesejado == 3 && idxAtual == 8) || (idxDesejado == 8 && idxAtual == 3) ) ||
					( (idxDesejado == 5 && idxAtual == 6) || (idxDesejado == 6 && idxAtual == 5) )					
				    ) {
				
				qtdePassos= 3;

			} else if ( 
					( (idxDesejado == 0 && idxAtual == 8) || (idxDesejado == 8 && idxAtual == 0) ) ||
					( (idxDesejado == 2 && idxAtual == 6) || (idxDesejado == 6 && idxAtual == 2) ) 					
				    ) {
				
				qtdePassos= 4;
			}
			
		}
		
		return qtdePassos;
	}

}
