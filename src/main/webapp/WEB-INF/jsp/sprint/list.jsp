<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="label.sprint.list.page.title"/></title>
</head>
<body>
    <h1><spring:message code="label.sprint.list.page.title"/></h1>
    <div>
        <a href="/sprint/add" id="add-button" class="btn btn-primary"><spring:message code="label.add.story.link"/></a>
    </div>
    <div id="sprint-list" class="page-content">
        <c:choose>
            <c:when test="${empty sprints}">
                <p><spring:message code="label.story.list.empty"/></p>
            </c:when>
            <c:otherwise>
                <c:forEach items="${ sprints}" var="sprint">
                    <div class="well well-small">
                        <a href="/almafa/${sprint.id}"><c:out value="${sprint.title}"/></a>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>