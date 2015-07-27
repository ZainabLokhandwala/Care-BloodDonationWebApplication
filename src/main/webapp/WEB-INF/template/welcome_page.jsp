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
        <h3 style="color: #080808; margin: 1em"><i>
            Welcome To Care,

            An online blood donation portal!
            This is a web application, which aims at connecting blood donors and receivers on a single platform just at
            the click of a finger.
            We all know emergencies can happen anytime and someone would be in eager need of blood, and CARE is the best
            platform for a donor to reach a receiver at this time of emergency or vice versa.

            <br>Donate blood today. And be a HERO!!</i>
        </h3>

        <div style="position: relative;background-image: url('/../../${pageContext.request.contextPath}/resources/images/welcome_pic.jpg'); min-height: 27em; background-position: center; background-repeat: no-repeat">
            <h1 style="text-align: center; bottom: 0%; left: 40%; position: absolute; color: black">Register Now!!!</h1>
        </div>
        <div>
            <a href="receiver/signup">
                <div class="btn btn-lg btn-danger" style="margin-left: 35%; float: left; margin-right: 1em">Start as
                    Receiver
                </div>
            </a>

            <a href="donor/signup">
                <div class="btn btn-lg btn-danger" style="float: left">Start as Donor</div>
            </a>
        </div>
    </div>
</div>

<!-- script references -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
</body>
</html>