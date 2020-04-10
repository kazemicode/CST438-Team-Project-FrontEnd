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
    var timestamp = new Date($.now());
    
    if (finalCost > 0) {
        $("#order_confirm_msg").html('Your order has been confirmed ' + '<br />' + timestamp + '');
        $("#order_confirm_msg").show();

        // Disable cart update and checkout buttons after order confirmation
        $(".startOver").attr("disabled", true);
        $(".checkoutButton").attr("disabled", true);
    }
    else {
        $("#order_confirm_msg").html('Error: Empty cart');
        $("#order_confirm_msg").show();
    }
});

// If "Start Over" is clicked, goes back to the beginning
$(".startOver").on("click", function(){
    // Calls function to start over
});

// Adds tip to grand total on click 
$(".updateTotal").on("click", function(){
	// Calls function to add tip to total
});