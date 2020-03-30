var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#kysymykset").show();
    }
    else {
        $("#kysymykset").hide();
    }
    $("#kysymys").html("");
}

function connect() {
  //  var socket = new SockJS('/gs-guide-websocket');
    var socket = new SockJS('/tenttisysteemi');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/newkysymys', function (kysymys) {
           // showKysymys(JSON.parse(kysymys.body).kysymysTeksti);
            showKysymys(JSON.parse(kysymys.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendKysymysTeksti() {
    stompClient.send("app/kysymys", {}, JSON.stringify({'kysymysTeksti': $("#kysymysTeksti").val()}));
}

function showKysymys(message) {
    $("#kysymys").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendKysymysTeksti(); });
});

