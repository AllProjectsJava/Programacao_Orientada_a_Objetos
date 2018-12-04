package Ex_5_FilaBanco;

public class Cliente implements Comparable<Cliente>{
    private String senha;
    private boolean eGestante;
    private boolean eIdoso;
    
    public Cliente(String umaSenha, boolean gestante, boolean idoso){
        senha = umaSenha;
        eGestante = gestante;
        eIdoso = idoso;
    }
    
    public String getSenha(){
        return(senha);
    }
    
    public boolean gestante(){
        return(eGestante);
    }
    
    public boolean idoso(){
        return(eIdoso);
    }

	@Override
	public String toString() {
		return "Cliente [senha=" + senha + ", eGestante=" + eGestante + ", eIdoso=" + eIdoso + "]";
	}

	@Override
	public int compareTo(Cliente outro) {
        if (this.gestante() && !outro.gestante()){
            return(-1);
        }else if (!this.gestante() && outro.gestante()){
            return(1);
        }else if (this.gestante() && outro.gestante()){
            return(0);
        }else if (!this.gestante() && !outro.gestante()){
            if (this.idoso() && !outro.idoso()){
                return(-1);
            }else if (!this.idoso() && outro.idoso()){
                return(1);
            }else{
                return(0);
            }
        }
        return(0);
        }   
}

