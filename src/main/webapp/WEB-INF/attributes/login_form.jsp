<div class="panel" style="padding-left: 20%; padding-right: 25%">
  <h2>Login as existing user</h2>
  <form class="form-horizontal" role="form" method="post" action="login">
    <div class="form-group">
      <label class="control-label col-sm-2" for="user_name">User Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="user_name" id="user_name" placeholder="Enter Username">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-10">
        <input type="password" class="form-control" name="pwd" id="pwd" placeholder="Enter password">
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10" style="margin-left: 45%">
        <button type="submit" class="btn btn btn-danger">Login</button>
      </div>
    </div>
  </form>
</div>