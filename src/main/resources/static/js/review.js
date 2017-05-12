$(".submit").click(function(){
	$.post("/review/add",{content:$("input").val()},function(data){alert(data);});
});