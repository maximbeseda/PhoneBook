<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

    <title>Регистрация</title>

    <!-- Bootstrap core CSS -->
    <link href="../../resources/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="http://getbootstrap.com/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../resources/dist/css/cover.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
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
                            <li><a href="login">Главная</a></li>
                            <li class="active"><a href="#">Регистрация</a></li>
                        </ul>
                    </nav>
                </div>
            </div>

            <div class="inner cover">
                <form:form method="POST" modelAttribute="userForm" class="form-signin">
                    <h2 class="form-signin-heading">Регистрация нового пользователя</h2>
                    <spring:bind path="fullName">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="fullName" class="form-control" placeholder="ФИО"
                                        autofocus="true"></form:input>
                            <form:errors path="fullName"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="login">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="login" class="form-control" placeholder="Логин"
                                        autofocus="true"></form:input>
                            <form:errors path="login"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="password">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="password" path="password" class="form-control"
                                        placeholder="Пароль"></form:input>
                            <form:errors path="password"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="confirmPassword">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="password" path="confirmPassword" class="form-control"
                                        placeholder="Подтвердите ваш пароль"></form:input>
                            <form:errors path="confirmPassword"></form:errors>
                        </div>
                    </spring:bind>

                    <button class="btn btn-lg btn-primary btn-block" type="submit">Зарегистрироваться</button>
                </form:form>


            </div>

            <div class="mastfoot">
                <div class="inner">
                    <p><a target="_blank" href="https://ua.linkedin.com/in/maxim-beseda-b6971012a">© Maxim Beseda
                        2017</a></p>
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
