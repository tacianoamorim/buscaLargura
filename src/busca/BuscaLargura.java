package busca;

import java.util.LinkedList;
import java.util.Queue;

public class BuscaLargura {
	
	private Queue<No> nos = new LinkedList<No>();
	private int valorBusca;
	private String textoResposta;
	
	public BuscaLargura(int valorBusca) {
		this.valorBusca= valorBusca;
	}

	public boolean processarBusca(No no) {
		// Testa para ver se o resultado foi alcancado
		if ( no.getValor() == this.valorBusca ) {
			obterResultadoNoPai(no);
			return true;
			
		} else {
			if ( no.getNoEsquerda() != null ) {
				this.nos.add(no.getNoEsquerda());
			}
			if ( no.getNoDireita() != null ) {
				this.nos.add(no.getNoDireita());
			}
			
			for (No nov : nos) {
				System.out.print("Nos " + nov.getValor() );
				if ( nov.getNoPai() != null ) {
					System.out.print(" Pai: "+ nov.getNoPai().getValor());
				}
				if ( nov.getNoEsquerda() != null ) {
					System.out.print(" Esq: "+ nov.getNoEsquerda().getValor() );
				}
				if ( nov.getNoDireita() != null ) {
					System.out.print(" Dir: "+ nov.getNoDireita().getValor());
				}
				System.out.println();
			}
			No noPonta = this.nos.poll();
			if ( noPonta != null && processarBusca(noPonta) ) {
				return true;
			}
		}
		return false;
	}
	
	private void obterResultadoNoPai(No no) {
		String retorno = "";
		No noValor = no;
		retorno += noValor.getValor();
		while ( noValor.getNoPai() != null ) {
			noValor = noValor.getNoPai();
			retorno = noValor.getValor() + " " + retorno;
		}
		this.textoResposta = retorno;
	}
	
	public void exibirTextoResultado() {
		if ( this.textoResposta != null ) {
			System.out.println("O caminho percorrido será: " + this.textoResposta);
		} else {
			System.out.println("O valor " + this.valorBusca + " não foi encontrado.");
		}
	}
	

}
