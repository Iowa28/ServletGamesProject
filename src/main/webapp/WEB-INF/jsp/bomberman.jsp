<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Bomberman</title>
  <link rel="stylesheet" type="text/css" href="<c:url value="css/bomberman.css"/>">
  <script type="text/javascript" src="<c:url value="js/bomberman.js"/>"></script>
</head>
<body>
<canvas width="960" height="832" id="game"></canvas>
</body>
</html>