<%--
  Created by IntelliJ IDEA.
  User: sncof
  Date: 19-Feb-22
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Medicine List</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container col-md-8">
        <h2 class="text-primary text-center mt-4">Medicine List</h2>
        <table class="table table-striped mt-3">
            <thead>
            <tr>
                <th>Medicine ID</th>
                <th>Medicine Brand</th>
                <th>Medicine Name</th>
                <th>Medicine Price</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="medicine" items="${medicines}">
                <tr>
                    <td> <c:out value="${medicine.medicine_id}"/> </td>'
                    <td> <c:out value="${medicine.medicine_brand}"/> </td>
                    <td> <c:out value="${medicine.medicine_name}"/> </td>
                    <td> <c:out value="${medicine.medicine_price}"/> </td>
                </tr>
            </c:forEach>
            </tbody>
            <p>Enter the id of medicine you want to delete:</p>
            <form action="servleturl" method="post">
                <input type="text" name="deleted_medicine_id" placeholder="Enter ID">
            </form>
            <button onclick="">Delete!</button>
        </table>
    </div>
</body>
</html>

