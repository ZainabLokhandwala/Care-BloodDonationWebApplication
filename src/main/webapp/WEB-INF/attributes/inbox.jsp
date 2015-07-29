<script>
    $(document).ready(function(){

        var webSocket;
        var messages = document.getElementById("messages");


        function openSocket(){
            // Ensures only one connection is open at a time
            if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED){
                //writeResponse("WebSocket is already opened.");
                return;
            }
            // Create a new instance of the websocket
            webSocket = new WebSocket("ws://localhost:8080/care/chat");

            /**
             * Binds functions to the listeners for the websocket.
             */
            webSocket.onopen = function(event){

                if(event.data === undefined)
                    return;

                writeResponse(event.data);
            };

            webSocket.onmessage = function(event){
                writeResponse(event.data);
            };

            webSocket.onclose = function(event){
                writeResponse("Connection closed");
            };
        }

        /**
         * Sends the value of the text input to the server
         */
        function send(){
            var text = document.getElementById("messageinput").value;
            var json = new Object();
            json.sender = "${user.userName}";
            json.receiver = "${receiver}";
            json.content = text;
            json.dateTime = new Date().getTime();

            msg = JSON.stringify(json);
            webSocket.send(msg);
        }

        function closeSocket(){
            webSocket.close();
        }

        function writeResponse(text){
            messages.innerHTML += "<br/>" + text;
        }

        openSocket();

        $("#send_btn").click(function() {
            send();
        })


    })
</script>

<div>
    <input type="text" id="messageinput"/>
</div>
<div>
    <button type="button" id="send_btn" >Send</button>
</div>
<!-- Server responses get written here -->
<div id="messages"></div>

<!-- Script to utilise the WebSocket -->
<script type="text/javascript">

</script>