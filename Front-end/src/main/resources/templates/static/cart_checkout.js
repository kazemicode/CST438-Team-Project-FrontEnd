// Variables
var tip = 0.00;
var subtotal = 0.00;
var finalCost = 0.00;

//To do: Calculate subtotal of all order line items
function calcSubTotal() {
    document.getElementById("subtotal").innerHTML = "subtotal: $" + subtotal;
}

//Returns final total - subtotal + tip
function calcFinal(subCost) {
    finalCost = parseInt(finalCost);
    finalCost = parseFloat(tip + subtotal);
    finalCost = finalCost.toFixed(2);
    document.getElementById("total").innerHTML = "total: $" + finalCost;
}

// jQuery Handlers
$(".checkoutButton").on("click", function(){

});

// If "Start Over" is clicked, goes back to the beginning
$(".startOver").on("click", function(){
    
});

// Adds tip to grand total on click 
$(".updateTotal").on("click", function(){
	calcFinal(subtotal);
});