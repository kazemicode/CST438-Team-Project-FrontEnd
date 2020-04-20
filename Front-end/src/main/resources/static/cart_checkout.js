// Variables
var subtotal = document.getElementById("sf_field").value;
var tip = document.getElementById("t_field").value;
var grand_total = document.getElementById("gt_field").value;

//Returns final total: subtotal + tip
function calcFinal() {
    grand_total = parseFloat(tip + subtotal);
    grand_total = grand_total.toFixed(2);
}

// jQuery Handlers
// Submits order (if necessary)
$(".checkoutButton").on("click", function(){

});

// Adds tip to grand total and updates grand total
$(".updateTotal").on("click", function(){
	calcFinal();
	
});

$(".tip").on("change", function(){
	calcFinal();
});