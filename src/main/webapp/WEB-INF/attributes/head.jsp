<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Donate Blood</title>
    <meta name="generator" content="Bootply"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/jquery-ui.theme.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/jquery-ui.structure.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">
    <!-- Server responses get written here -->
    <script>
        $(document).ready(function () {

            var webSocket;
            var messages = document.getElementById("messages");
            var chatbox = document.getElementById("chatbox")


            function openSocket() {
                // Ensures only one connection is open at a time
                if (webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
                    //writeResponse("WebSocket is already opened.");
                    return;
                }
                // Create a new instance of the websocket
                webSocket = new WebSocket("ws://localhost:8080/care/chat");

                /**
                 * Binds functions to the listeners for the websocket.
                 */
                webSocket.onopen = function (event) {

                    if (event.data === undefined)
                        return;

                    writeResponse(event.data);
                };

                webSocket.onmessage = function (event) {
                    writeResponse(event.data);
                };

                webSocket.onclose = function (event) {
//                    writeResponse("Connection closed");
                };
            }

            function closeSocket() {
                webSocket.close();
            }

            function writeResponse(text) {

                text = JSON.parse(text)
                $("#senders").append("<li><a href=inbox?name=" + text.sender + ">" + text.sender + "</a></li>")
                html = "<div class=\'odd\'>" + text.sender + ": " + text.content + "</div>";
                chatbox.innerHTML += html;
            }

            /**
             * Sends the value of the text input to the server
             */
            function send() {
                var text = document.getElementById("messageinput").value;
                var json = new Object();
                json.sender = "${user.userName}";
                json.receiver = "${receiver}";
                json.content = text;
                json.dateTime = new Date().getTime();

                msg = JSON.stringify(json);
                webSocket.send(msg);
            }


            openSocket();

            $("#send_btn").click(function () {
                send();
                $("#messageinput").val("")
            })

            $(".date").datepicker({

                dateFormat: 'yy-mm-dd'
            })

        })
    </script>
</head>