<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action ="http://localhost:8585/books/update" method ="post">
BOOKID : <input type = "text" name ="bookId"> <br>
BOOKNAME : <input type = "text" name ="bookName"> <br>
BOOKGENRE: <input type = "text" name ="bookGenre"> <br>
PRICE: <input type = "text" name ="price"> <br>
 <button type = "submit">update Book</button>

</form>
</body>
</html>