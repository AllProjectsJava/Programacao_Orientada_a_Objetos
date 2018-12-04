package Demo_Caixa_de_Mensagens;

public class MsgEmail {
    private EndEmail remetente;
    private EndEmail destinatario;
    private String assunto;
    private String texto;
    
	public MsgEmail(EndEmail remetente, EndEmail destinatario, String assunto, String texto) {
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public EndEmail getRemetente() {
		return remetente;
	}

	public EndEmail getDestinatario() {
		return destinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	@Override
	public String toString() {
		return "MsgEmail [remetente=" + remetente + ", destinatario=" + destinatario + ", assunto=" + assunto
				+ ", texto=" + texto + "]";
	}
}
