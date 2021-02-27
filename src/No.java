import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Taciano
 */
public class No implements Cloneable {
	private int id;
	private String nome;
	private int valorHeuristica;
	private String[] array;

	private No noPai;
	private Queue<No> filhos;

	public No(int id, String nome, int valorHeuristica, String[] array) {
		this.id= id;
		this.nome= nome;
		this.valorHeuristica = valorHeuristica;
		this.array= array;
		this.filhos= new LinkedList<No>();
	}

	public No getClone() {
        try {
            return (No) super.clone();
        } catch (Exception e) {
            //System.out.println (" No not allowed. " );
            return this;
        }
    }
	
	/** ******************************************************************
	 * Gets and Sets
	 * *******************************************************************/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getValorHeuristica() {
		return valorHeuristica;
	}
	public void setValorHeuristica(int valorHeuristica) {
		this.valorHeuristica = valorHeuristica;
	}

	public String[] getArray() {
		return array;
	}
	public void setArray(String[] array) {
		this.array = array;
	}

	public Queue<No> getFilhos() {
		return filhos;
	}
	public void addFilho(No filho) {
		filho.setNoPai(this);
		getFilhos().add(filho);
	}

	public No getNoPai() {
		return noPai;
	}
	public void setNoPai(No noPai) {
		this.noPai = noPai;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "No [id=" + id + ", nome=" + nome + ", Pai=" + ", valorHeuristica=" + valorHeuristica + ", array="
				+ Arrays.toString(array) + ", filhos=" + filhos.size() + "]";
	}
	
	public String toStringResumido() {
		String texto = "- No ["+id+"]-"+nome+"("+valorHeuristica+") - Pai: "
				+ (getNoPai()!=null? "["+ getNoPai().getId()+"] "+getNoPai().getNome() : "--- ");
		texto= texto+ "\n      "+ array[0] +" | "+ array[1] +" | "+ array[2];
		texto= texto+ "\n      ----------- ";
		texto= texto+ "\n      "+ array[3] +" | "+ array[4] +" | "+ array[5];
		texto= texto+ "\n      ----------- ";
		texto= texto+ "\n      "+ array[6] +" | "+ array[7] +" | "+ array[8];		
		return texto;
	}	
	
}