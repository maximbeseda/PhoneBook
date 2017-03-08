<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="ru">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="#">

    <title>Phone book</title>

    <!-- Bootstrap core CSS -->
    <link href="../../resources/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="http://getbootstrap.com/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../resources/dist/css/cover.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="http://getbootstrap.com/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="site-wrapper">
      <div class="site-wrapper-inner">
        <div class="cover-container">
          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Phone book</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li class="active"><a href="#">Главная</a></li>
                  <li><a href="registration">Регистрация</a></li>
                </ul>
              </nav>
            </div>
          </div>

          <div class="inner cover">
            <h1 class="cover-heading">Phone book</h1>
            <p class="lead">Храните все свои контакты в Phone book. Это простое, но эффективное приложение для хранения всех телефонов, e-mail, адресов, которые доступны для вас в любой момент.</p>
            <p class="lead">
              <!--Login form-->
              <spring:url value="/j_spring_security_check" var="loginUrl"/>
              <form class="navbar-form" role="form" action="${loginUrl}" method="post">
                <div class="form-group has-feedback">
                  <input type="text" placeholder="Логин" class="form-control" name="j_login" pattern="^[a-zA-Z]{3,}$" required>
                </div>
                <span class="glyphicon form-control-feedback"></span>
                <div class="form-group">
                  <input type="password" placeholder="Пароль" class="form-control" name="j_password" pattern="^[\S]{5,}$" required>
                </div>
                <span class="glyphicon form-control-feedback"></span>
                <button type="submit" class="btn btn-md btn-primary">Войти</button>
              </form>
              <c:if test="${param.error ne null}">
                <div class="alert alert-danger alert-dismissable">
                  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                  <strong>Неверный логин или пароль!</strong> Повторите попытку еще раз.
                </div>
              </c:if>
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p><a target="_blank" href="https://ua.linkedin.com/in/maxim-beseda-b6971012a">© Maxim Beseda 2017</a></p>
            </div>
          </div>

        </div>

      </div>

    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../resources/dist/js/jquery.min.js"><\/script>')</script>
    <script src="../../resources/dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="http://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>