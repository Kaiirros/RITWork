
function viewPhoto(image, containerID){

    let copyImage = new Image();
    copyImage.src = image.src;
    copyImage.style.position = "sticky";
    copyImage.style.zIndex = "5";
    copyImage.style.width = "30rem";
    copyImage.style.height = "30rem";
    copyImage.style.left = "50%";
    copyImage.style.transform = "translateX(-50%)";

    document.getElementById("content").style.filter = "blur(5px)";
    copyImage.style.filter = "none";

    document.getElementById("body").appendChild(copyImage);

    //Image Close Button
    newDiv = document.createElement("div");
    newDiv.style.position = "absolute";
    newDiv.style.top = "0";
    newDiv.style.right = "0";
    newDiv.style.backgroundColor = "red";
    newDiv.style.width = "5rem";
    newDiv.style.height = "5rem";
    newDiv.id = "close"
    document.getElementById("body").appendChild(newDiv);

    //document.getElementById("close").addEventListener("click", closePhoto(copyImage));
}

function closePhoto(copyImage){
    console.log("Removing child...");
    console.log(copyImage);

    if (copyImage.parentNode){
        copyImage.parentNode.removeChild(copyImage);
    }

    //document.getElementById("content").style.filter = "blur(0px)";
}