<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    .chatbox {

        margin-left: 5%;
        height: 15em;
        overflow: scroll;
    }
    /*.odd {*/

        /*color: red;*/
    /*}*/
    /*.even {*/

        /*color: green;*/
    /*}*/
</style>

<div class="panel col-lg-10 chatbox" id="chatbox">
    <c:forEach items="${m}" var="i" varStatus="loop">
        <div class="<c:if test='${(loop.index % 2) eq 0}'>odd</c:if>
        <c:if test='${(loop.index % 2) eq 1}'>even</c:if>">
            ${i.sender.userName}: ${i.content}
        </div>
    </c:forEach>
</div>
<div class="form-group form-inline" style="margin-left: 25%">
    <textarea type="text" id="messageinput" class="form-control" style="width: 50%"></textarea>
    <div id="send_btn" class="btn btn-danger">Send</div>
</div>
<div id="messages"></div>
