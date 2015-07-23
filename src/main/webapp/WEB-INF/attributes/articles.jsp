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

           <div class="col col-sm-12">
               <div class="panel" style="padding: 1em;overflow: hidden;">
                   <div class="person">
                       <div class="photo">
                           <img src="#">
                       </div>
                       <div class="name">Name: </div>
                       <div class="blood-type">Type: </div>
                       <div class="btn btn-default" style="width: 100%">Info</div>
                   </div>
                   <div class="person">
                       <div class="photo">
                           <img src="#">
                       </div>
                       <div class="name">Name: </div>
                       <div class="blood-type">Type: </div>
                       <div class="btn btn-default" style="width: 100%">Info</div>
                   </div>
                   <div class="person">
                       <div class="photo">
                           <img src="#">
                       </div>
                       <div class="name">Name: </div>
                       <div class="blood-type">Type: </div>
                       <div class="btn btn-default" style="width: 100%">Info</div>
                   </div>
               </div>
           </div>
       </div>
       <div class="row" id="receivers">

           <div class="col col-sm-12">
               <div class="panel" style="padding: 1em;overflow: hidden;">
                   <div class="person">
                       <div class="photo">
                           <img src="#" class="">
                       </div>
                       <div class="name">Name: </div>
                       <div class="blood-type">Type: </div>
                       <div class="btn btn-default" style="width: 100%">Info</div>
                   </div>
                   <div class="person">
                       <div class="photo">
                           <img src="#">
                       </div>
                       <div class="name">Name: </div>
                       <div class="blood-type">Type: </div>
                       <div class="btn btn-default" style="width: 100%">Info</div>
                   </div>

               </div>
           </div>
       </div>
   </div>
</div>