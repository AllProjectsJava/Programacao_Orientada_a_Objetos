import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CadastroFuncionarios {
    private Set<Funcionario> funcionarios;
	
	public CadastroFuncionarios() {
		funcionarios = new TreeSet<>();
	}
	
	public void add(Funcionario funcionario) {
		if(funcionarios.add(funcionario) == false) {
			throw new FuncionarioDuplicadoException(funcionario);
		}
	}
	
	public List<String> getMeninasQueGanhamMaisDe4000(){
		/*
		List<String> resp = new LinkedList<>();

		for(Funcionario f:funcionarios) {
			if (f.getCodigo() >= 2000) {
				if (f.getSalarioBase() > 4000) {
					resp.add(f.getNome());
				}
			}
		}
		*/
		List<String> resp = funcionarios
				            .stream()
				            .filter(f->(f.getCodigo() >= 2000))
				            .filter(f->(f.getSalarioBase() > 4000))
				            .map(f->f.getNome())
				            .collect(Collectors.toList());
		return resp;
	}
	
	public double getGastoTotalComSalarios() {
		double total = funcionarios
				       .stream()
				       .mapToDouble(f->f.getSalarioBase())
				       .sum();
		return total;
	}
	
	public void aumentaHomens(double taxa) {
		funcionarios
		.stream()
		.filter(f->(f.getCodigo()<2000))
		.forEach(f->f.setSalarioBase(f.getSalarioBase()*taxa));
	}
}
