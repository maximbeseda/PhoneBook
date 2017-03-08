<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>

    <jsp:attribute name="title">Новый контакт</jsp:attribute>

    <jsp:body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="contacts">Phone book</a>
                </div>

                <div class="navbar-collapse collapse">
                    <form class="navbar-form navbar-right" role="form">
                        <div class="form-group">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                    <c:out value=" ${fullName}"/></a></li>
                            </ul>
                        </div>
                        <a class="btn btn-danger" href="<c:url value="/logout" />" role="button">Выход</a>
                    </form>
                </div>
            </div>
        </nav>

        <div class="container">

            <div class="starter-template">

                <form:form method="POST" modelAttribute="contactForm" class="form-signin">
                    <h2 class="form-signin-heading">Добавить новый контакт</h2>
                    <spring:bind path="surname">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="surname" class="form-control" placeholder="Фамилия"
                                        autofocus="true"></form:input>
                            <form:errors path="surname"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="name">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="name" class="form-control" placeholder="Имя"></form:input>
                            <form:errors path="name"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="patronymic">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="patronymic" class="form-control"
                                        placeholder="Отчество"></form:input>
                            <form:errors path="patronymic"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="mobilePhone">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" id="phone" name="phone" path="mobilePhone" class="form-control"
                                        placeholder="Мобильный телефон"></form:input>
                            <form:errors path="mobilePhone"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="homePhone">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" id="homephone" name="homephone" path="homePhone" class="form-control"
                                        placeholder="Домашний телефон"></form:input>
                            <form:errors path="homePhone"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="email">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="email" path="email" class="form-control"
                                        placeholder="E-mail"></form:input>
                            <form:errors path="email"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="address">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="address" class="form-control"
                                        placeholder="Адрес"></form:input>
                            <form:errors path="address"></form:errors>
                        </div>
                    </spring:bind>

                    <button class="btn btn-lg btn-primary btn-block" type="submit">Добавить</button>
                </form:form>


            </div>

        </div>
        <!-- /.container -->


    </jsp:body>

</page:template>