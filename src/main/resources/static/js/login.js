/**
 * login and register
 */

$(".register_btn").click(function register(event){
	 	event.preventDefault();
		var url = $(this).parents("form").attr("action");
		var data = $(this).parents("form").serialize();
		$.post(url, data, function(data){
			if(data.data == "success"){
				console.log("success");
			}else if(data.data == "userExists"){
				console.log("userExists");
			}else{
				console.log("error");
			}
			
		});
});