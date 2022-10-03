package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contatos;
import model.ContatosDAO;

@WebServlet("/Inserir")
public class InserirContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		
		Contatos objContatos =  new Contatos();
		
		objContatos.setNome(nome);
		objContatos.setTelefone(telefone);
		objContatos.setEmail(email);
		
		ContatosDAO cdao = new ContatosDAO();		
		cdao.save(objContatos);
		
		response.sendRedirect("Listar");
		
	}

}
