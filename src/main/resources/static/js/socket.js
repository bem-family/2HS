/**
 * socket 
 */
var currentUser;
$(document).ready(function(){
	if($("*[name='user']").text() != ""){
		currentUser = $("*[name='user']").text();
		initSocket();
	}
});

function initSocket(){
	var socket = new SockJS('/websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function (frame) {
		stompClient.subscribe('/topic/' + currentUser, function (greeting) {
			
		});
	});
}