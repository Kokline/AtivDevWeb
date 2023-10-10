package br.com.aula.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aula.model.Livro;

public class livroDAO {
	private Connection conn = null;

	public livroDAO() {
		this.iniciarConexao();
	}

	public boolean estaDisconectada() {
		try {
			return this.conn.isClosed();
		} catch (SQLException e) {
			System.out.println("Exception Error: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public void checarConexao() {
		if (this.estaDisconectada()) {
			this.iniciarConexao();
		}
	}

	public void iniciarConexao() {
		try {
			this.conn = ConnectionFactory.getConnection();

			if (conn != null) {
				System.out.println("Conexão realizada com sucesso!");
			} else {
				System.out.println("Falha na conexão.");
			}
		} catch (Exception e) {
			System.out.println("Exception Error: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public void salvar(Livro livro) {
		String sql = "insert into livro (titulo, isbn, autor, editora) value (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement stm = null;

		try {
			this.checarConexao();
			conn = this.conn;

			stm = conn.prepareStatement(sql);

			// titulo, isbn, autor, editora
			stm.setString(1, livro.getTitulo());
			stm.setString(2, livro.getIsbn());
			stm.setString(3, livro.getAutor());
			stm.setString(4, livro.getEditora());

			stm.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, stm);
		}
	}

	public List<Livro> listar() {
		String sql = "select * from livro";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;

		int id;
		String titulo, isbn, autor, editora;

		try {
			this.checarConexao();
			conn = this.conn;

			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();

			List<Livro> livros = new ArrayList<Livro>();

			while (rs.next()) {
				id = rs.getInt("id");
				titulo = rs.getString("titulo");
				isbn = rs.getString("isbn");
				autor = rs.getString("autor");
				editora = rs.getString("editora");

				livros.add(new Livro(id, titulo, isbn, autor, editora));
			}

			System.out.println("Lista de livros criado com sucesso!");

			return livros;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, stm, rs);
		}
	}

	public void editar(Livro livro) {
		String sql = "update livro set titulo=?, isbn=?, autor=?, editora=? where id=?";

		Connection conn = null;
		PreparedStatement stm = null;

		try {
			this.checarConexao();
			conn = this.conn;
			stm = conn.prepareStatement(sql);

			stm.setString(1, livro.getTitulo());
			stm.setString(2, livro.getIsbn());
			stm.setString(3, livro.getAutor());
			stm.setString(4, livro.getEditora());

			stm.setInt(5, livro.getId());

			stm.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			ConnectionFactory.closeConnection(conn, stm);
		}

	}

	public void excluir(Livro livro) {
		String sql = "delete from livro where id=?";

		Connection conn = null;
		PreparedStatement stm = null;

		try {
			this.checarConexao();
			conn = this.conn;

			stm = conn.prepareStatement(sql);
			stm.setInt(1, livro.getId());

			stm.executeUpdate();

			System.out.println(livro.toString());
			System.out.println("Livro excluido com sucesso!");

		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			ConnectionFactory.closeConnection(conn, stm);
		}
	}

	public Livro pesquisar(Livro livro) {
		String sql = "select * from livro where isbn=?";

		int id;
		String titulo, isbn, autor, editora;

		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;

		try {
			this.checarConexao();
			conn = this.conn;
			stm = conn.prepareStatement(sql);

			stm.setString(1, livro.getIsbn());
			rs = stm.executeQuery();

			if (!rs.next())
				return null;

			id = rs.getInt("id");
			titulo = rs.getString("titulo");
			isbn = rs.getString("isbn");
			autor = rs.getString("autor");
			editora = rs.getString("editora");

			return new Livro(id, titulo, isbn, autor, editora);
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			ConnectionFactory.closeConnection(conn, stm, rs);
		}

	}
}
