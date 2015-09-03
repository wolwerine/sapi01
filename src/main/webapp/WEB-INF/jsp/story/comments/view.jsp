<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="/static/js/comment.view.js"></script>
</head>
<body>
    <div id="comment-id" class="hidden">${story.id}</div>
    <h1><spring:message code="Comment List"/></h1>
    <div class="well page-content">
        <h2 id="comment-title"><c:out value="${comment.title}"/></h2>
        <div>
            <p><c:out value="${comment.description}"/></p>
        </div>
        <div class="action-buttons">
            <a href="/comment/update/${comment.id}" class="btn btn-primary"><spring:message code="label.update.story.link"/></a>
            <a id="delete-comment-link" class="btn btn-primary"><spring:message code="label.delete.story.link"/></a>
        </div>
    </div>
    <script id="template-delete-comment-confirmation-dialog" type="text/x-handlebars-template">
        <div id="delete-comment-confirmation-dialog" class="modal">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">×</button>
                <h3><spring:message code="label.comment.delete.dialog.title"/></h3>
            </div>
            <div class="modal-body">
                <p><spring:message code="label.comment.delete.dialog.message"/></p>
            </div>
            <div class="modal-footer">
                <a id="cancel-comment-button" href="#" class="btn"><spring:message code="label.cancel"/></a>
                <a id="delete-comment-button" href="#" class="btn btn-primary"><spring:message code="label.delete.comment.button"/></a>
            </div>
        </div>
    </script>
</body>
</html>