
function viewPhoto(image, container){
    copyImage = document.createElement("img");
    node = document.createAttribute(image.src)
    copyImage.appendChild(node)

    copyImage.style.zIndex = "5"
    copyImage.style.marginLeft= "auto"
    copyImage.style.marginRight="auto"
    copyImage.style.width = "20rem"
    copyImage.style.height = "20rem"


    contr = document.getElementById(container);
    contr.appendChild(copyImage);

}