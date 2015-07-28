<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<tiles:insertAttribute name="head"></tiles:insertAttribute>
<body>
<tiles:insertAttribute name="nav"></tiles:insertAttribute>
<tiles:insertAttribute name="header"></tiles:insertAttribute>
<tiles:insertAttribute name="search"></tiles:insertAttribute>
<!-- Begin Body -->
<div class="container">
    <div class="row">
        <c:if test="${type eq 0}">
            <tiles:insertAttribute name="donor"></tiles:insertAttribute>
        </c:if>
        <c:if test="${type eq 1}">
            <tiles:insertAttribute name="receiver"></tiles:insertAttribute>
        </c:if>
    </div>
</div>

<!-- script references -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
</body>
</html>