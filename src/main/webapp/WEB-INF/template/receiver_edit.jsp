<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
<tiles:insertAttribute name="head"></tiles:insertAttribute>
<body>
<tiles:insertAttribute name="nav"></tiles:insertAttribute>
<header class="masthead" style="margin-top: 5em">
  <div class="container-fluid">
    <div class="panel panel-body" style="background-image:
            url('/../../${pageContext.request.contextPath}/resources/images/2.png');
            background-position: center; background-repeat: no-repeat">
      <div class="row">
        <div class="col col-sm-6">
          </br></br></br>
          <i>
            <p class="lead" style="color: black">
              A life may depend on a gesture from you, a bottle of Blood.
            </p>
          </i>
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
<!-- Begin Body -->
<div class="container">
  <div class="row">
    <tiles:insertAttribute name="receiver_edit_form"></tiles:insertAttribute>
  </div>
</div>

<!-- script references -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
</body>