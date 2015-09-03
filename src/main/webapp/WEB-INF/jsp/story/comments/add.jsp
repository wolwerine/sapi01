<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="/static/js/story.form.js"></script>
</head>
<body>
    <h1><spring:message code="label.comment.add.page.title"/></h1>
    <div class="well page-content">
        <form:form action="/comment/add" commandName="comment" method="POST" enctype="utf8">
            <div id="control-group-title" class="control-group">
                <label for="comment-title"><spring:message code="label.comment.title"/>:</label>

                <div class="controls">
                    <form:input id="comment-title" path="title"/>
                    <form:errors id="error-title" path="title" cssClass="help-inline"/>
                </div>
            </div>
            <div id="control-group-description" class="control-group">
                <label for="comment-description"><spring:message code="label.comment.description"/>:</label>

                <div class="controls">
                    <form:textarea id="comment-description" path="description"/>
                    <form:errors id="error-description" path="description" cssClass="help-inline"/>
                </div>
            </div>
            <div class="action-buttons">
                <a href="/" class="btn"><spring:message code="label.cancel"/></a>
                <button id="add-comment-button" type="submit" class="btn btn-primary"><spring:message
                        code="label.add.comment.button"/></button>
            </div>
        </form:form>
    </div>
</body>
</html>