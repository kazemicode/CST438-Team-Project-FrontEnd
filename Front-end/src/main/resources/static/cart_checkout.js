$(document).ready(function() {
	
	// Adds tip to grand total and updates grand total
	$(".updateTotal").on("click", function(){
		var sub = parseFloat($("#subtotal_field").text());
		var tip = parseFloat($("#tip_field").val());
		$("#grand_total_field").html(tip + sub);
	});

});