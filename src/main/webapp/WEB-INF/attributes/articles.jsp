<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(document).ready(function () {

        $(".tabs").tabs();
    })
</script>
<style type="text/css">
    .person {

        width: 12em;
        height: 15em;
        background: #f8f1c6;
        margin-bottom: 1em;
        margin-right: 0.8em;
        margin-left: 0.8em;
        float: left;

    }

    .photo {

        width: 90%;
        height: 60%;
        margin: 5%;
    }

    .name {
        height: 1.5em;
        margin-left: 5%;
    }

    .blood-type {
        height: 1.5em;
        margin-left: 5%;
    }
</style>
<div class="container">
    <div class="tabs">
        <ul>
            <li><a href="#donors">Donors</a></li>
            <li><a href="#receivers">Receivers</a></li>
        </ul>
        <div class="row" id="donors">

                <div class="col col-sm-12" style="float:left;">
                    <div class="panel" style="padding: 1em;overflow: hidden;">
                        <c:forEach items="${donors}" var="i">
                        <div class="person">
                            <div class="photo">
                                <img src="${pageContext.request.contextPath}/user/image?name=${i.userName}" width="100%" height="100%">
                            </div>
                            <div class="name">Name: ${i.name}</div>
                            <div class="blood-type">Type: ${i.bloodGroup}</div>
                            <a href="${pageContext.request.contextPath}/user/profile?name=${i.userName}">
                                <div class="btn btn-default" style="width: 100%">Info</div>
                            </a>
                        </div>
                        </c:forEach>
                    </div>
                </div>
        </div>
        <div class="row" id="receivers">
            <c:forEach items="${receivers}" var="i">
                <div class="col col-sm-12">
                    <div class="panel" style="padding: 1em;overflow: hidden;">
                        <div class="person">
                            <div class="photo">
                                <img src="${pageContext.request.contextPath}/user/image?name=${i.userName}" width="100%" height="100%">
                            </div>
                            <div class="name">Name: ${i.name}</div>
                            <div class="blood-type">Type: ${i.bloodGroup}</div>
                            <a href="${pageContext.request.contextPath}/user/profile?name=${i.userName}">
                                <div class="btn btn-default" style="width: 100%">Info</div>
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>