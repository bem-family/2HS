/**
 * login and register
 */

$(".register_btn").click(function register(){
	if{
		var url = $(this).parents("form").attr("action");
		var data = $(this).parents("form").serialize();
		$.post(url, data, function(data){
			console.log(data.data)
			if(data.data == "success"){
				
			}else if(data.data == "userExists"){
				 
			}else{
				$.globalMessenger().post({
		            message: "验证错误，请检查后重新输入",
		            hideAfter: 2,
		            type: 'error',
		            //showCloseButton: true
		        });
			}
			
		});
	}
});