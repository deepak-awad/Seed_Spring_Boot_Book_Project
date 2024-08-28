<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book</title>
</head>
<body>
 <h1>update Record By Id : </h1>
    <form action="/updatebook"  method="post">
      <br><br>
      		   <br><br> Book Id : &nbsp;&nbsp;&nbsp;<input type="text" size="20" name="bookId" id="bookId">
               <br><br> Book Name:&nbsp;&nbsp;&nbsp;<input type="text" size="20" name="bookName">
               <br><br> Book Price:&nbsp;&nbsp;&nbsp;<input type="text" size="20" name="bookPrice">
               <br><br> Author Name:&nbsp;&nbsp;&nbsp;<input type="text" size="20" name="authorName">
               <br><br> Published Date:&nbsp;&nbsp;&nbsp;<input type="text" size="20" name="publishedDate">
               <br><br> Book Genre:&nbsp;&nbsp;&nbsp;<input type="text" size="20" name="bookGenre">
               <br><br> <input type="submit" value="update Record"/>
    </form>
    
    <p>${message}</p>
</body>
</html>

<!--  
 <br><br> Published Date:&nbsp;&nbsp;&nbsp;<input type="text" size="20" name="publishedDate">
-->