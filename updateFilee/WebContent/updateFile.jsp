<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css\webPage.css">
</head>
<body>

<h2>Please upload File</h2>
 <form action="updateF" enctype="multipart/form-data" method="post">
 <table>
 <tr>
 <td>Select file : </td>
 <td><input type="file" name="file2" /></td>
 </tr>
 <tr>
 <td>Submit : </td>
 <td><input type="submit" value="upload" /></td>
 </tr>
</table>
<p>${successful }</p>
 </form> 


</body>
</html>