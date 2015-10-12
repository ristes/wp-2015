<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- <link rel="shortcut icon" href="../../assets/ico/favicon.ico"> -->

  <title>Finki WP - Servlet Showcase</title>

  <!-- Custom styles for this template -->
  <link href="/resources/dist/style.css?rel=9876b30bed" rel="stylesheet">
</head>

<body>

<h1>Здраво Веб
  <%=request.getParameter("name")%>
  <%
    out.print(request.getParameter("name"));
  %>
</h1>

<div>
  Вие пристапувате од:
  <br/>
  <%
    String userAgent = request.getHeader("User-Agent");

    List<String> parts = Arrays.asList(userAgent.split(" "));
  %>

  <%
    for (String p : parts) {
  %>
  <%=p%><br/>
  <%
    }
  %>
</div>


</body>
</html>
