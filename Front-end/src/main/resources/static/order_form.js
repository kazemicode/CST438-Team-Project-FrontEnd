
/**
 * 
 */
// variables
const form = document.getElementById("orderForm");
const data = getFormDataAsJSON(form);


// 
$(document).ready(function() {
//	var form = $("#orderForm");
//	var orderJSON = JSON.stringify($("#orderForm").serializeArray());
//	var oReq = new XMLHttpRequest();
	

		

		console.log("YEAH YEAH YEAHS");

		$('#orderForm').submit(function() {	
			alert("Submitted");
		$.ajax({
			  type: 'POST',	
			  dataType: 'json',			  
			  url: '/order/summary',
			  data: $(this),	
			  contentType : 'application/json'
				  }).done(function () {
				  console.log("YEAH YEAH YEAHS");
			  }).fail(function(req, err) {
				  console.log('oops: ' + err.toString()); 
			  });
		});		

});
		

