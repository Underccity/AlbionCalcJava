var stompClient = null;

function connect() {
    var socket = new SockJS('/update-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/updateItems', function (greeting) {
            console.log(greeting);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}


function addCraft() {
    var divCraft = $('#newCrafts');
    var option = "";
    $('#newCraftSelect option').toArray().forEach( function(opt) {
  		option += "<option>" + opt.value + "</option>";
	})
	
    var newSelect = "<select class='form-select'>" + option + "</select>";
    var newInput = '<input class="form-control" type="text" placeholder="Количество" aria-label="Количество">';
    divCraft.append('<div class="row p-2">' + '<div class="col-6">' + newSelect  + '</div>' + '<div class="col-4"> ' +  newInput + '</div>' + '</div>');
}