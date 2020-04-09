<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <link rel="stylesheet" type="text/css" href="css/style.css"/>
     <title>User Home Page</title>
</head>
<body>
<header>
  <jsp:include page='header.jsp'></jsp:include>
</header>

<section>
  <nav>
    <jsp:include page='leftpanel.jsp'></jsp:include>
  </nav>
  
  <article>
    <jsp:include page='centerpanel.jsp'></jsp:include>
  </article>
</section>

<footer>
  <jsp:include page='footer.jsp'></jsp:include>
</footer>

</body>
</html>