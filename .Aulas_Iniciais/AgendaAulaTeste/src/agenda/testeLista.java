package agenda;

import java.util.List;

public class testeLista {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.getLista();
		for (Contato contato : contatos) {
			System.out.println("Código: " + contato.getId());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("E-mail: " + contato.getEmail());
			System.out.println("Data de Nascimento: " 
			+ contato.getDataNascimento().getTime()+"\n");
		}

	}

}
