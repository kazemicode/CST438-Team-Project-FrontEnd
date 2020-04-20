/**
 * 
 */
// variables
//const data = getFormDataAsJSON(form);


const formToJSON = elements => [].reduce.call(elements, (data, element) => {
	
	data[element.name] = element.value;
	return data;
	
}, {});

const handleFormSubmit = event => {
	
	event.preventDefault();
	
	const data = formToJSON(form.elements);
	
	const dataContainer = document.getElementById("orderForm");
	
	dataContainer.textContent = JSON.stringify(data, null, " ");
		
};

const form = document.getElementById("orderForm");
form.addEventListner('submit', handleFormSubmit);


const reducerFunction = (data, element) => {
	
	data[element.name] = element.value;
	
	console.log(JSON.stringify(data));
	
	return data;
};


// 
//$(document).ready(function() {
//	var form = $("#orderForm");
//	var orderJSON = JSON.stringify($("#orderForm").serializeArray());
//	var oReq = new XMLHttpRequest();
	

		

//		console.log("YEAH YEAH YEAHS");
//
//		$('#orderForm').submit(function() {	
//			alert("Submitted");
//		$.ajax({
//			  type: 'POST',	
//			  dataType: 'json',			  
//			  url: '/order/summary',
//			  data: $(this),	
//			  contentType : 'application/json'
//				  }).done(function () {
//				  console.log("YEAH YEAH YEAHS");
//			  }).fail(function(req, err) {
//				  console.log('oops: ' + err.toString()); 
//			  });
//		});		

//});
		

