<div class="container">
  <div class="row">
    <div class="col col-sm-12">

      <div class="panel-title">
        <div class="panel-body">
          <div class="col col-sm-12">
            <form class="form-group" action="${pageContext.request.contextPath}/search">
              <div class="input-group">
                <input type="text" class="input-lg form-control" placeholder="Search keyword" name="key">

                <div class="input-group-btn">
                  <button type="submit" class="btn btn-lg"><i
                          class="glyphicon glyphicon-search"></i></button>
                </div>
              </div>
              <div class="form-inline">
                <div class="radio">
                  <h4><label for="by-city"> <input id="by-city" class="radio-button" type="radio" name="search_type" value="city"> Search by City</label></h4>
                </div>
                <div class="radio">
                  <h4> <label for="by-bloodtype"><input class="radio-button" id="by-bloodtype" type="radio" name="search_type" value="group"> Search by Blood Type</label></h4>
                </div>
                <input class="form-control" name="option_value" placeholder="Enter your criteria here">
              </div>
            </form>
          </div>
          <%--<div class="col col-sm-1">--%>
          <%--<h4><i class="glyphicon glyphicon-chevron-down">More</i></h4>--%>
          <%--</div>--%>
        </div>
      </div>

    </div>
  </div>
</div>