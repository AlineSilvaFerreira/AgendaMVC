package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContatosDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	
	//Método salvar
	public void save(Contatos contatos) {

		String sql = "INSERT INTO contato (nome, telefone, email)" + " VALUES(?,?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, contatos.getNome());

			pstm.setString(2, contatos.getTelefone());

			pstm.setString(3, contatos.getEmail());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Método remover
	public void removeById(int id) {
		String sql = "DELETE FROM contato WHERE id = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// Metodo atualizar
	public void update(Contatos contatos) {
		String sql = "UPDATE contato SET nome = ?, telefone = ?, email = ?  where id = ?;";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, contatos.getNome());
			pstm.setString(2, contatos.getTelefone());
			pstm.setString(3, contatos.getEmail());
			pstm.setInt(4, contatos.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//Método listar
	public List<Contatos> getContatos() {

		String sql = "SELECT * FROM contato";

		List<Contatos> contatos = new ArrayList<Contatos>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Contatos cont = new Contatos();

				cont.setId(rset.getInt("id"));

				cont.setNome(rset.getString("nome"));

				cont.setTelefone(rset.getString("telefone"));

				cont.setEmail(rset.getString("email"));

				contatos.add(cont);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {

				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return contatos;
	}
	
	//Método buscar por id
	public Contatos getContatosById(int id) {

		String sql = "SELECT * FROM contato where id = ?";
		Contatos contatos = new Contatos();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			contatos.setNome(rset.getString("nome"));
			contatos.setTelefone(rset.getString("telefone"));
			contatos.setEmail(rset.getString("email"));
			contatos.setId(rset.getInt("id"));

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contatos;
	}
}
