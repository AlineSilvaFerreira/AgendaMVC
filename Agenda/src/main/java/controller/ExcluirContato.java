package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contatos;
import model.ContatosDAO;

@WebServlet("/Excluir")
public class ExcluirContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int idContato = Integer.parseInt(req.getParameter("id"));
		Contatos contatoExcluido = new Contatos();
		contatoExcluido.setId(idContato);

		ContatosDAO cdao = new ContatosDAO();

		cdao.removeById(idContato);

		resp.sendRedirect("Listar");
	}

}
