package agenda;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDAO {
	
	private Connection connection;

	public ContatoDAO() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void adicionar(Contato contato) {
		String sql = "insert into contatos " 
					+ "(nome,email,endereco,dataNascimento)" 
					+ " values(?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			// setar os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt =
					this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void Atualizar(Contato contato) {
		String sql = "UPDATE contatos SET coluna1 = valor, coluna2 = valor where";
	}
}
	
	