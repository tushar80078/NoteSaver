package com.servlets;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			int noteId=Integer.parseInt(request.getParameter("note_id").trim());
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tr=s.beginTransaction();
			
			Note note=(Note)s.get(Note.class, noteId);
			s.delete(note);
			tr.commit();
			s.close();
			response.sendRedirect("all_notes.jsp");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
