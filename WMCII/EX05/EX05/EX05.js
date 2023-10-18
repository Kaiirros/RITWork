function jsStyle() {
    // function to change style
    // Change the color and the size of the font
    // in the paragraph with id='text'
    var text = document.getElementById("text");
    text.style.color = "red";
    text.style.fontSize = "2rem";
}

function getFormValues() {
    // function to send first and last names
    // to an 'alert' message.
    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    alert(fname + " " + lname)
}

function getOptions() {
	// function to display the number of options in an alert()
	var options = document.getElementsByTagName("option")
	var optionsList = "Options: \n";
	var array = Array.from(options)
	array.forEach(element => {
		optionsList += element.value + "\n"
	});

	alert(optionsList)

}
//Mouse over Functions
document.getElementById("rb").onmouseover = function() {mouseOver()};
document.getElementById("rb").onmouseout = function() {mouseOut()};

function mouseOver() {
  document.getElementById("rb").style.color = "red";
}

function mouseOut() {
  document.getElementById("rb").style.color = "black";
}

var first;
var second;
function multiply(){
	first = document.getElementById("firstoperand").value
	second = document.getElementById("secondoperand").value

	answer = (parseInt(first)*parseInt(second));

	document.getElementById("result").textContent = answer;
}
function divide(){
	first = document.getElementById("firstoperand").value
	second = document.getElementById("secondoperand").value

	answer = (parseInt(first)/parseInt(second));

	document.getElementById("result").textContent = answer;


}
