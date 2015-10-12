<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>S&T HR</title>
    
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/font-awesome.min.css" rel="stylesheet">
    
    <link href="${pageContext.request.contextPath}/resources/css/print.css" rel="stylesheet" media="print">

  </head>

  <body>

    <div class="container">
		<h1>Report title</h1>
		
		<table class="table print-friendly">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${employees}">
				<tr>
					<td>${e.id}</td>
					<td>${e.firstName}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
    </div> <!-- /container -->

  </body>
</html>
