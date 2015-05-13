<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1><spring:message code="label.story.list.page.title"/></h1>
    <div>
        <a href="/story/add" id="add-button" class="btn btn-primary"><spring:message code="label.add.story.link"/></a>
    </div>
    <div id="story-list" class="page-content">
        <c:choose>
            <c:when test="${empty stories}">
                <p><spring:message code="label.story.list.empty"/></p>
            </c:when>
            <c:otherwise>
                <c:forEach items="${ stories}" var="story">
                    <div class="well well-small">
                        <a href="/story/${story.id}"><c:out value="${story.title}"/></a>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>