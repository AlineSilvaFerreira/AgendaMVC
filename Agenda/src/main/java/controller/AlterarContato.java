package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contatos;
import model.ContatosDAO;

@WebServlet("/Alterar")
public class AlterarContato extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int idContato = Integer.parseInt(req.getParameter("id"));
		ContatosDAO cdao = new ContatosDAO();
		Contatos contatoSelecionado = cdao.getContatosById(idContato);

		req.setAttribute("contatos", contatoSelecionado);
	
		RequestDispatcher rd = req.getRequestDispatcher("/update.jsp");

        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Contatos contatoAlterado = new Contatos();	
		
		contatoAlterado.setNome(req.getParameter("nome"));
		contatoAlterado.setTelefone(req.getParameter("telefone"));
		contatoAlterado.setEmail(req.getParameter("email"));
		contatoAlterado.setId(Integer.parseInt(req.getParameter("id")));
		
		ContatosDAO cd = new ContatosDAO();
		cd.update(contatoAlterado);	
		resp.sendRedirect("Listar");
	}
}
