<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://kit.fontawesome.com/9e8b7791f2.js" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="HeaderStyle.css">
</head>
<body>
	<header>
		<nav class = "navbar">
		<ul>
		<li><a class = "active" href = "ProductView.jsp"><img src = "logo.png" width = 50% height = "auto"></a></li>
		<li><a href = "loginForm.jsp">Login</a></li>
		<li><a href = "CartView.jsp"><i class="fa-solid fa-cart-shopping"></i></a></li>
		<li style = "li {float:right;}">  
			<div class = "search">
			  	<form method = "POST" action = "search">
              		<div class="input-group mb-3">
  						<input type="text" class="form-control" placeholder="Cerca.." aria-describedby="button-addon2">
  						<button class="btn btn-outline-secondary" type="button" id="button-addon2" value = "search"><i class="fa-solid fa-magnifying-glass"></i></button>
					</div>
				</form>
			</div>
        </li>
		</ul>
		</nav>
		<script>
		/* Funzione per mostrare/nascondere gli elementi del menu sulla navbar per dispositivi mobili */
		function toggleMenu() {
  			var x = document.querySelector(".navbar ul");
  			if (x.className === "responsive") {
    			x.className = "";
  			} else {
    			x.className = "responsive";
  			}
		}
</script>
	</header>
</body>
</html>