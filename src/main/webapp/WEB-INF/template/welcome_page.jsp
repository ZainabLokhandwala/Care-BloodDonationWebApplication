<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
<tiles:insertAttribute name="head"></tiles:insertAttribute>
<body>
<tiles:insertAttribute name="nav"></tiles:insertAttribute>
<tiles:insertAttribute name="header"></tiles:insertAttribute>
<!-- Begin Body -->
<div class="container">
    <div class="row" style="background-image: url('/../../${pageContext.request.contextPath}/resources/images/welcome_pic.jpg'); min-height: 27em; background-position: center; background-repeat: no-repeat">
        <h3 style="color: #080808; margin: 1em"><i>
            Welcome To Care,

            An online blood donation portal!
            This is a web application, which aims at connecting blood donors and receivers on a single platform just at the click of a finger.
            We all know emergencies can happen anytime and someone would be in eager need of blood, and CARE is the best platform for a donor to reach a receiver at this time of emergency or vice versa.

            <br>Donate blood today. And be a HERO!!</i>
        </h3>
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