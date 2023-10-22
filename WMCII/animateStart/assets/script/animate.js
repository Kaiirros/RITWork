//Created by Daniel McKee

var moving;

function $(id){
    return document.getElementById(id)
}

/**
 * Moves object right
 @param {String} stringId
 @returns {void}
 */
function right(stringId){

stopMoving();
 
 currentpos = $(stringId).style.left
 newpos = parseInt(currentpos)+1 + "px";

 $(stringId).style.left = newpos;

 moving = setTimeout(right,5, stringId);
}

/**
 * Moves object right
 @param {String} stringId
 @returns {void}
 */
function left(stringId){

stopMoving()
 
 currentpos = $(stringId).style.left
 newpos = parseInt(currentpos)-1 + "px";

 $(stringId).style.left = newpos;

 moving = setTimeout(left,5, stringId);
}

function stopMoving(){
    clearTimeout(moving);
}

function fadeOut(stringId){

    if ($(stringId).style.opacity >= 0){
        $(stringId).style.opacity = parseFloat($(stringId).style.opacity) - .01;
        setTimeout(fadeOut, 10, stringId);
        
        document.getElementsByTagName('button')[4].disabled = true;
    } else {
        document.getElementsByTagName('button')[4].disabled = false;
    }
   
}
