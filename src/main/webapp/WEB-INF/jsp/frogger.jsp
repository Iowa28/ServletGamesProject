<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Basic Frogger HTML Game</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="<c:url value="css/frogger.css"/>">
  <script type="text/javascript" src="<c:url value="js/frogger.js"/>"></script>
</head>
<body>
<canvas width="624" height="720" id="game"></canvas>

</body>
</html>