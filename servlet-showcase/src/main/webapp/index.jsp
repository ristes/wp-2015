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
<%
  //  String name = request.getParameter("name");
//  request.setAttribute("name", name);
//  String works = request.getParameter("works");
//  request.setAttribute("works", works);
%>

<h1>Здраво Веб
  <%=request.getAttribute("name")%> :
  <%
    out.print(request.getAttribute("works"));

  %>
</h1>

<form action="hello.do?query=text" method="post">
  Name: <input type="text" name="name" value="${name}"/> <br/>
  Works: <input type="text" name="works" value="<%=request.getAttribute("works")%>"/> <br/>
  remember me: <input type="checkbox" name="showCompany" value="true">

  <hr/>
  <input value="Login" type="submit">
</form>

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
