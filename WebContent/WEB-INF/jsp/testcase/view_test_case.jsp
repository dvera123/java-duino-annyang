<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@include file="head_test_case.jsp" %>
<%@include file="modal_test_case.jsp" %>

</head>
<body>
	<h3>Test Case Page Title</h3>
	<div id="testCaseList">
		<%@include file="list_test_case.jsp" %>
	</div>
	<a href="#myModal" role="button" class="btn" data-toggle="modal">Launch demo modal</a>
</body>
</body>
</html>