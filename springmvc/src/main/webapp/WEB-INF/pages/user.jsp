<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<html>
<head>
    <title>User Information</title>
</head>
<body>
    <h1>User Information</h1>
    <table>
        <tr>
            <th>ID:</th>
      <%--       <td><c:out>${user}</td> --%>
<%--             <c:out ${user}></c:out>
 --%>        </tr>
        <tr>
            <th>Email:</th>
            <td>${user}</td>
        </tr>
    </table>
    
<%--     
   <c:out value="${user}"></c:out> --%>