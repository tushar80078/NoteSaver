<%@page import="com.entities.Note"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container-fluid">
    	<%@include file="navbar.jsp"%>
    	<h1>Edit Your Note</h1><br>
    	<%
    	int noteId=Integer.parseInt(request.getParameter("note_id").trim());
    	Session s=FactoryProvider.getFactory().openSession();
		
		Note note=(Note)s.get(Note.class, noteId);
    	%>
    	
    	<form action="UpdateServlets" method="post">
    	
	  	<div class="form-group ">
	    <label for="title">Note Title</label>
	    <input name="title" required type="text" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter Here" value="<%= note.getTitle() %>">
	    </div>
	     
	     
	  	<div class="form-group">
	    <label for="content" >Note Content</label>
	   	<textarea    name="content" required id="content" placeholder="Enter content herer" class="form-control" style="height:300px"></textarea>
	   	</div>
	   	
	 	<div class="container text-center">
	 		 <button type="submit" class="btn btn-primary">Add</button>
	 	
	 	</div>  	
	 
 
		</form>
		
    	
    </div>
    
    <script>
			let dv=document.getElementById("content");
			dv.defaultValue.innerHtml=dv.value="<%= note.getContent() %>";
	</script>
</body>
</html>