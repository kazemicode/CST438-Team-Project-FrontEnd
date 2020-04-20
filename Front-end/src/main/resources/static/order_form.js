
$( document ).ready(function() {
	
	$("#orderForm").submit(function(){
		
		$.ajax({
			url : '/order/summary',
			type : 'POST',
			dataType : 'json',
			data : $("#orderForm").serialize(),
			success : function() {
				console.log("Success");
			}
		})
	})
});
