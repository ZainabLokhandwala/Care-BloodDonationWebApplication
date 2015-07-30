<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="panel" style="overflow: hidden;height: 100%;" >
  <div class="panel" style="float: left; width: 70%;">
    <h2>Receiver Profile</h2>
    <form enctype="multipart/form-data" class="form-horizontal" role="form" action="signup" method="post">
      <div class="form-group">
        <label class="control-label col-sm-2" for="name">Name:</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="name" disabled value="${profile.name}" name="name">
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-sm-2" for="user_name">User Name:</label>
        <div class="col-sm-10">
          <input disabled value="${profile.userName}" type="" class="form-control" name="user_name" id="user_name" placeholder="Enter username">
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-sm-2" for="age">Age:</label>
        <div class="col-sm-10">
          <input disabled value="${profile.age}" type="text" class="form-control" id="age" name="age" placeholder="Enter age">
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-sm-2" for="sex">Sex</label>
        <div class="col-sm-10">
          <input disabled value="<c:if test='${profile.sex eq false}'>Male</c:if><c:if test='${profile.sex eq true}'>Female</c:if>" id ="sex" class="form-control">
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-sm-2" for="type">Blood Type</label>
        <div class="col-sm-10">
          <input disabled value="${profile.bloodGroup}" id="type" class="form-control">
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-sm-2" for="city">City</label>
        <div class="col-sm-10">
          <input disabled value="${profile.city}" class="form-control" placeholder="City" id="city" name="city">
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-sm-2" for="country">Country</label>
        <div class="col-sm-10">
          <input disabled value="${profile.country}" class="form-control" placeholder="Country" id="country" name="country">
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-sm-2" for="recent_medications">Recent Medications</label>
        <div class="col-sm-10">
          <input disabled value="${profile.recentMedications}" class="form-control" placeholder="Quanity needed" id="recent_medications" name="quantity_needed">
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-sm-2" for="allergies">Allergies</label>
        <div class="col-sm-10">
          <textarea disabled value="" class="form-control" placeholder="Allergies" id="allergies" name="allergies">${profile.allergies}</textarea>
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-sm-2" for="contact_info">Contact Info</label>
        <div class="col-sm-10">
          <textarea disabled class="form-control" placeholder="Contact Infor" id="contact_info" name="contactInformation">${profile.contactInformation}</textarea>
        </div>
      </div>
    </form>
  </div>
  <div class="panel" style="width: 30%; float:left; margin-top: 5em;">
    <table>
      <tr>
        <td ><img src="${pageContext.request.contextPath}/user/image?name=${profile.userName}" width="100%" height="180em">
          <a href="${pageContext.request.contextPath}/inbox?name=${profile.userName}"><div class="form-control btn btn-danger">Inbox</div></a></td>
      </tr>
    </table>
  </div>
</div>