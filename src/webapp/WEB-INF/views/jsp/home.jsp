<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
                  rel="stylesheet">
</head>

<body>
    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">Name</th>
                <th scope="col">Author</th>
                <th scope="col">Price</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${bookList}" >
                <tr>
                    <td>${book.id}</td>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>

</html>