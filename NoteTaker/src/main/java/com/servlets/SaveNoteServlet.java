package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SaveNoteServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			Note note=new Note(title, content, new Date());
			
			//System.out.println(note.getId()+" : "+note.getTitle());
			
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tr=s.beginTransaction();
			
			s.save(note);
			
			tr.commit();
			s.close();
			
			response.sendRedirect("add_notes_msg.jsp");
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<h1 style='text-align:center;'>Note Added Successfully !!!</h1>");
			//out.println("<h1 style='text-align:center;'><a href='all_notes.jsp'>View All Notes </a></h1>");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
			e.printStackTrace();
		}
		
		
	}

}
