$(".submit").click(function(){
	$.post("/review/add",{content:$("input").val(),top_id:$(".task").data("uid")},function(data){alert(data);});
})
$(".delete_review").click(function(){
	var self = this;
	$.post("/review/remove/"+$(this).data("uid"),
	function(data){
		if(data){
			console.log(data);
			$(self).parent(".tab").remove();
		}
	});
})
