<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
<tiles:insertAttribute name="head"></tiles:insertAttribute>
<body>
<tiles:insertAttribute name="nav"></tiles:insertAttribute>
<tiles:insertAttribute name="header"></tiles:insertAttribute>
<!-- Begin Body -->
<div class="container">
    <div class="row">
        <div class="btn btn-lg btn-danger" style="margin-left: 30%; float: left; margin-right: 1em">Start as Receiver</div>
        <div class="btn btn-lg btn-danger" style="float: left">Start as Donor</div>
    </div>
</div>

<!-- script references -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
</body>
</html>