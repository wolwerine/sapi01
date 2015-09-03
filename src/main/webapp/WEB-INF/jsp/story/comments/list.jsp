<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1><spring:message code="label.comment.list.page.title"/></h1>
    <div>
        <a href="/comment/add" id="add-button" class="btn btn-primary"><spring:message code="label.add.comment.link"/></a>
    </div>
    <div id="comment-list" class="page-content">
        <c:choose>
            <c:when test="${empty comments}">
                <p><spring:message code="label.comment.list.empty"/></p>
            </c:when>
            <c:otherwise>
                <c:forEach items="${ comments}" var="comment">
                    <div class="well well-small">
                        <a href="/comment/${comment.id}"><c:out value="${comment.title}"/></a>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>