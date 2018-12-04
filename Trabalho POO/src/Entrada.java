import java.util.Set;

public class Entrada {
	private int contador;
	private Set<Integer> set;
	
	public Entrada(Set<Integer> set) {
		super();
		this.contador = 1;
		this.set = set;
	}

	public boolean addIndice(Integer num) {
		return this.set.add(num);
	}
	
	public void incrementaContador() {
		this.contador++;
	}
	
	public int getContador() {
		return contador;
	}
	
	public Set<Integer> getSet() {
		return set;
	}

	@Override
	public String toString() {
		return ": " + set + "\n";
	}
}
