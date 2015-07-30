<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
<tiles:insertAttribute name="head"></tiles:insertAttribute>
<body>
<tiles:insertAttribute name="nav"></tiles:insertAttribute>
<%--<div style="background-image:--%>
<%--url('../../${pageContext.request.contextPath}/resources/images/1.png');--%>
<%--min-height: 27em; background-position: center;--%>
<%--background-size: 100%; background-repeat: no-repeat">--%>
<%--<tiles:insertAttribute name="header"></tiles:insertAttribute>--%>
<header class="masthead" style="margin-top: 5em">
  <div class="container-fluid">
    <div class="panel panel-body" style="background-image:
            url('/../../${pageContext.request.contextPath}/resources/images/1.png');
            background-position: center; background-repeat: no-repeat">
      <div class="row">
        <div class="col col-sm-6">
          </br></br></br>
          <i><p class="lead" style="color: black">The blood you donate gives someone another chance at life. One
            day that someone may be a close relative, a friend, a loved one or even you.</p></i>
        </div>
        <div class="col col-sm-6">
          <div class="well pull-right">
            <img src="${pageContext.request.contextPath}/resources/images/carelogo-01.png">
          </div>
        </div>
      </div>
    </div>
  </div>
</header>
</div>
<!-- Begin Body -->
<div class="container">
  <div class="row">
    <tiles:insertAttribute name="donor_edit_form"></tiles:insertAttribute>
  </div>
</div>

<!-- script references -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
</body>
