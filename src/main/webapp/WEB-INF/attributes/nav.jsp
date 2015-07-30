<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-static-top" style="position: fixed;top: 0;width: 100%">
    <div class="container">
        <a class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
            <span class="glyphicon glyphicon-chevron-down"></span>
        </a>

        <div class="nav-collapse collase">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="${pageContext.request.contextPath}/index">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/signup">Signup</a></li>
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/inbox">Inbox <i class="glyphicon glyphicon-chevron-down"></i></a>
                    <ul id="senders" class="dropdown-menu">

                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-right navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i>
                        <i class="glyphicon glyphicon-chevron-down"></i></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                        <li><a href="${pageContext.request.contextPath}/user/profile?name=${user.userName}">Profile</a></li>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- /.navbar -->