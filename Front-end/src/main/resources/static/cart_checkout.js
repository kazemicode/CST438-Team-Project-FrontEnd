// Variables
var subtotal = document.getElementById("sf_field").value;
var tip = document.getElementById("t_field").value;
var grand_total = document.getElementById("gt_field").value;


//Returns final total: subtotal + tip
function calcFinal() {
    grand_total = parseInt(grand_total);
    grand_total = parseFloat(tip + subtotal);
    grand_total = grand_total.toFixed(2);
    document.getElementById("total").innerHTML = "total: $" + grand_total;
}

// jQuery Handlers
// Submits order (if necessary)
$(".checkoutButton").on("click", function(){

});

// If "Start Over" is clicked, goes back to the beginning
$(".startOver").on("click", function(){
    
});

// Adds tip to grand total and updates grand total
$(".updateTotal").on("click", function(){
	calcFinal();
});