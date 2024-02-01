function jsStyle() {
    // function to change style
    // Change the color and the size of the font
    // in the paragraph with id='text'

    text.style.color = "red";
    text.style.fontSize = "2rem";

}

function moveText(){
    var text = document.getElementById("text");
	pos = text.style.left;
	text.style.left = (parseInt(pos) + 10) + "px";
}

function getFormValues() {
    // function to send first and last names
    // to an 'alert' message.
    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    alert(fname + " " + lname)
}

function howMany(){
	inputCount = 0;
	textCount = 0;

	form = document.getElementById("regForm");
	array = form.getElementsByTagName("input");

	for (i = 0; i < array.length; i++){
		inputCount++;
		if (array[i].type == "text"){
			textCount++;
		}
	}


	console.log("Total Input Elements: " + inputCount)
	console.log("Total Text Input Elements: " + textCount)
	
}

function colorChanger() {
	color = document.getElementById("mySelect").value;
	document.getElementById("colorDiv").style.backgroundColor = color;

}
//Mouse over Functions
document.getElementById("rb").onmouseover = function() {mouseOver()};
document.getElementById("rb").onmouseout = function() {mouseOut()};

function mouseOver() {
  document.getElementById("rb").style.color = document.getElementById("mySelect").value;
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


	document.getElementById("result").appendChild(document.createTextNode(answer));

}
function divide(){
	first = document.getElementById("firstoperand").value
	second = document.getElementById("secondoperand").value

	answer = (parseInt(first)/parseInt(second));
	document.getElementById("result").appendChild(document.createTextNode(answer));


}
