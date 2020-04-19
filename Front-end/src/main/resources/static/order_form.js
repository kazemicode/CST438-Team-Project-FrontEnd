/**
 * 
 */
// variables
var orderJSON = JSON.stringify($("#orderForm").serializeArray());

// 
$( document ).ready(function() {
	console.log(JSON.stringify($("#orderForm").serializeArray()));
	$.ajax({
		  type: "POST",
		  url: "/order/summary",
		  data: orderJSON,
		  success: function(){},
		  dataType: "json",
		  contentType : "application/json"
		});
	
});
