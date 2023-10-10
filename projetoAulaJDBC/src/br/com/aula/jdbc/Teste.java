package br.com.aula.jdbc;

import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.aula.dao.livroDAO;
import br.com.aula.model.Livro;

public class Teste {

	public static void main(String[] args) {
		livroDAO livroDAO = new livroDAO();
		Livro livro;
		
		int id = 0;
		String titulo= "", isbn="", autor="", editora="";
		
		int opcao = 0;
		String resposta;
		
		String menu = "Gestão de livros - Escolha uma das seguintes opções:";
		menu += "\n 1 - Cadastrar livro.";
		menu += "\n 2 - Editar livro.";
		menu += "\n 3 - Deletar livro.";
		menu += "\n 4 - Pesquisar livro por ISBN.";
		menu += "\n 5 - Listar livros.";
		menu += "\n 6 - Sair.";
		
		do {
			
			resposta = JOptionPane.showInputDialog(menu);
			opcao = Integer.parseInt(resposta);
			
			switch (opcao) {
			case 1:
				titulo = JOptionPane.showInputDialog("Informe o Titulo: ");
				isbn = JOptionPane.showInputDialog("Informe o ISBN: ");
				autor = JOptionPane.showInputDialog("Informe o AUTOR: ");
				editora = JOptionPane.showInputDialog("Informe o EDITORA: ");
				
				livro = new Livro(id, titulo, isbn, autor, editora);
				
				livroDAO.salvar(livro);				
				break;
			
			case 2:
				id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID: "));
				titulo = JOptionPane.showInputDialog("Informe o Titulo: ");
				isbn = JOptionPane.showInputDialog("Informe o ISBN: ");
				autor = JOptionPane.showInputDialog("Informe o AUTOR: ");
				editora = JOptionPane.showInputDialog("Informe o EDITORA: ");
				
				livro = new Livro(id, titulo, isbn, autor, editora);
				livroDAO.editar(livro);
				break;	
				
			case 3:
				id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID: "));
				
				livro = new Livro(id, titulo, isbn, autor, editora);
				livroDAO.excluir(livro);
				break;	
				
			case 4:
				isbn = JOptionPane.showInputDialog("Informe o ISBN: ");
				
				livro = new Livro(id, titulo, isbn, autor, editora);
				
				Livro livro2 = livroDAO.pesquisar(livro);
				
				System.out.println(livro2.toString());
				break;	
				
			case 5:
				List<Livro> livrosLista = livroDAO.listar();
				for (Livro obj : livrosLista) {
					System.out.println(obj.toString());
				}
				break;	

			default: System.out.println("Saindo...");
				break;
			}
			
			
		} while (opcao > 0 && opcao < 6);
	}

}
