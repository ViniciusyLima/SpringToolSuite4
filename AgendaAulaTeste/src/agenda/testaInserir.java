package agenda;

import java.util.Calendar;

public class testaInserir {

	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Vanderson");
		contato.setEndereco("Rua 1");
		contato.setEmail("teste@tete.com");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO dao = new ContatoDAO();
		dao.adicionar(contato);
		System.out.println("Gravado com sucesso!!");
		
	}

}
