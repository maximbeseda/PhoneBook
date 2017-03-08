<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>

    <jsp:attribute name="title">Список контактов</jsp:attribute>

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
                    <a class="navbar-brand" href="#">Phone book</a>
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
                <h1>Список ваших контактов</h1>

                <!--Button Group-->
                <div class="panel">
                    <div class="btn-toolbar">
                        <div class="btn-group">
                            <button id="add_contact" type="button" class="btn btn-primary">Создать</button>
                        </div>
                        <div class="btn-group">
                            <button id="edit_contact" type="button" class="btn btn-primary">Изменить</button>
                        </div>
                        <div class="btn-group">
                            <button id="delete_contact" type="button" class="btn btn-danger">Удалить</button>
                        </div>
                    </div>
                </div>

                <table id="example" class="display text-left" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th>ФИО</th>
                        <th>Телефон моб.</th>
                        <th>Телефон дом.</th>
                        <th>Адрес</th>
                        <th>E-mail</th>
                    </tr>
                    </thead>

                    <tfoot>
                    <tr>
                        <th>ФИО</th>
                        <th>Телефон моб.</th>
                        <th>Телефон дом.</th>
                        <th>Адрес</th>
                        <th>E-mail</th>
                    </tr>
                    </tfoot>

                    <tbody>
                    <c:forEach items="${allContacts}" var="contact">
                        <tr data-value="${contact.id}">
                            <td>${contact.surname} ${contact.name} ${contact.patronymic}</td>
                            <td>${contact.mobilePhone}</td>
                            <td>${contact.homePhone}</td>
                            <td>${contact.address}</td>
                            <td>${contact.email}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <form style="display: none" action="/contact_edit" method="POST" id="formidupdate">
                <input type="hidden" id="toUpdate" name="toUpdate" value=""/>
            </form>


        </div>
        <!-- /.container -->


    </jsp:body>

</page:template>