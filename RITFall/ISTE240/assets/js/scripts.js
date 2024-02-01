
function viewPhoto(image){

    //New Image Copy
    let copyImage = new Image();
    copyImage.src = image.src;
    copyImage.style.position = "fixed";
    copyImage.style.zIndex = "5";
    copyImage.style.width = "30rem";
    copyImage.style.height = "30rem";
    copyImage.style.left = "50%";
    copyImage.style.transform = "translate(-50%, -50%)";

    //Image Close Button
    newDiv = document.createElement("div");
    newDiv.style.position = "fixed";
    newDiv.style.backgroundColor = "red";
    newDiv.style.zIndex = "5";
    newDiv.style.width = "4rem";
    newDiv.style.height = "4rem";
    newDiv.style.top = "0";
    newDiv.style.right = "0";
    newDiv.style.backgroundImage = "url(cross.webp)"
    newDiv.style.backgroundSize = "cover";
    newDiv.id = "close"
    //---------------------

    document.getElementById("content").style.filter = "blur(5px)";
    copyImage.style.filter = "none";

    document.getElementById("body").appendChild(copyImage);
    
    document.getElementById("body").appendChild(newDiv);
    document.getElementById("close").onclick = closePhoto;

    function closePhoto(){
        newDiv.parentNode.removeChild(newDiv);
        copyImage.parentNode.removeChild(copyImage);
    
        document.getElementById("content").style.filter = "blur(0px)";
    }
}

