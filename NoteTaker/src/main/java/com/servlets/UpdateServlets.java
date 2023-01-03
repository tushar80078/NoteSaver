package com.servlets;

import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;

import com.entities.Note;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class UpdateServlets extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			Note note=new Note(title, content, new Date());
			
			//int noteId=Integer.parseInt(request.getParameter("note_id").trim());
	    	Session s=FactoryProvider.getFactory().openSession();
			int noteId = note.getId();
			System.out.println(noteId);
			
			
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
