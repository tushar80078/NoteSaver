<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
<div class="container-fluid">
    	<%@include file="navbar.jsp"%>
    	<h1> Please Fill Your Note Detail</h1><br>
    	<!-- This is Add form -->
    	<h2 style="text-align: center; color:#43D518 ;">Note Added Successfully !!!</h2>
    	<h2 style="text-align: center; color:#43D518 ; font-weight:bold;">Add More !!!</h2>
    
    <form action="SaveNoteServlet" method="post">
    	
  	<div class="form-group ">
    <label for="title">Note Title</label>
    <input name="title" required type="text" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter Here">
    </div>
     
     
  	<div class="form-group">
    <label for="content" >Note Content</label>
   	<textarea name="content" required id="content" placeholder="Enter content herer" class="form-control" style="height:300px"></textarea>
   	</div>
   	
 	<div class="container text-center">
 		 <button type="submit" class="btn btn-primary">Add</button>
 	
 	</div>  	
 
 
</form>
    </div>


</body>
</html>