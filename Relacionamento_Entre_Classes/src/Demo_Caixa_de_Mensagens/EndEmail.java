package Demo_Caixa_de_Mensagens;

public class EndEmail {
    private String id;
    private String domain;

    public EndEmail(String id, String domain) {
		this.id = id;
		this.domain = domain;
	}

    public EndEmail(String end) {
    	int posA = end.indexOf('@');
    	id = end.substring(0, posA);
		this.domain = end.substring(posA+1,end.length());
	}

    public String getId() {
		return id;
	}

    public String getDomain() {
		return domain;
	}
    
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		EndEmail other = (EndEmail)obj;
		if (!domain.equals(other.domain))
			return false;
		if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString(){
    	return(id+"@"+domain);
    }
}
