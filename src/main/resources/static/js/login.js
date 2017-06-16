/**
 * login and register
 */

$("*[name='register-btn']").on("click", function register(){
		var url = $(this).parents("form").attr("action");
		var data = $(this).parents("form").serialize();
		$.post(url, data, function(data){
			if(data.data == "success"){
				console.log("success");
			}else if(data.data == "userExists"){
				console.log("userExists");
			}else{
				console.log(data);
			}
		});
});