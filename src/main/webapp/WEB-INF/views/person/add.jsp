<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>Add student</h1>
<form:form method="post" modelAttribute="person">
    <form:input path="login"/>
    <form:input path="password"/>
    <form:input path="email"/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>