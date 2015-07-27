<div class="panel" style="padding-left: 20%; padding-right: 25%;">
  <h2>Register as Donor</h2>
  <form enctype="multipart/form-data" class="form-horizontal" role="form" action="signup" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="name">Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="name" id="name" placeholder="Enter name" >
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="user_name">User Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="user_name" id="user_name" placeholder="Enter username">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-10">
        <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter password">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="repwd">Re-enter password</label>
      <div class="col-sm-10">
        <input type="password" class="form-control" id="repwd" name="repwd" placeholder="Enter password again">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="age">Age:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="age" name="age" placeholder="Enter age">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="sex">Sex</label>
      <div class="col-sm-10">
        <select class="form-control" id="sex" name="sex">
          <option value="1">Male</option>
          <option value="1">Female</option>
        </select>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="type">Blood Type</label>
      <div class="col-sm-10">
        <select class="form-control" id="type" name="blood_type">
          <option value="A">A</option>
          <option value="B+">B+</option>
          <option value="B-">B-</option>
          <option value="O">O</option>
          <option value="AB">AB</option>
        </select>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="city">City</label>
      <div class="col-sm-10">
        <input class="form-control" placeholder="City" id="city" name="city">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="country">Country</label>
      <div class="col-sm-10">
        <input class="form-control" placeholder="Country" id="country" name="country">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="recent_medications">Recent Medications</label>
      <div class="col-sm-10">
        <textarea class="form-control" placeholder="Recent Medications" id="recent_medications" name="recent_medications"></textarea>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="allergies">Allergies</label>
      <div class="col-sm-10">
        <textarea class="form-control" placeholder="Allergies" id="allergies" name="allergies"></textarea>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="contact_info">Contact Info</label>
      <div class="col-sm-10">
        <textarea class="form-control" placeholder="Contact Infor" id="contact_info" name="contactInformation"></textarea>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="image">Photo</label>
      <div class="col-sm-10">
        <input type="file" class="form-control" placeholder="Your photo" id="image" name="image"></input>
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10" style="margin-left: 45%">
        <button type="submit" class="btn btn btn-danger">Register</button>
      </div>
    </div>
  </form>
</div>