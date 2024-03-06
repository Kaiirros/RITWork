const xhr = new XMLHttpRequest();
const url = "data/locations.json";
var shoppingLocations = [];

/// Added to process out of file jSON but for some reason I believe this is the issue for when the page is refreshed?
xhr.addEventListener("load", function () {
if (xhr.readyState === 4 && xhr.status === 200) {
    shoppingLocations = JSON.parse(xhr.response);

}

});

xhr.open("GET", url, true);
xhr.send();

var favorites = [];

function loadJSON(){

    clearDeck()

    if (localStorage.getItem('favorites')){
        favorites = JSON.parse(localStorage.getItem('favorites'))
    } else {
        let stringFavorites = JSON.stringify(favorites)
        localStorage.setItem('favorites', stringFavorites)
    }

    let locations = Object.values(shoppingLocations);
    locations.forEach((element) => {
        console.log("constructor run")
        cardCreator(element)
        
    });

}

function cardCreator(element){

    //Create Card
    let card = document.createElement('div');
    card.setAttribute('class','card')

    //Create Image
    let image = document.createElement('img');
    image.setAttribute('class','cardImage')
    image.setAttribute('src', ("assets/" + element["image"]))
    card.appendChild(image)

    //Create Name
    let name = document.createElement('h2');
    name.setAttribute('class','cardName')
    let nameContent = document.createTextNode(element["name"])
    name.appendChild(nameContent);
    card.appendChild(name)

    //Create Address
    let address = document.createElement('h3')
    let addressContent = document.createTextNode(element["address"])
    address.appendChild(addressContent)
    card.appendChild(address)

    //Create span for buttons
    let span = document.createElement('span');
    span.setAttribute('class','buttonRow')
    card.appendChild(span)

    //Create favorite button
    let favButton = document.createElement('button')

    favButton.setAttribute('class','favoriteButton')

    //If card is saved in favorites local storage, have card liked already
    if (JSON.parse(localStorage.getItem('favorites')).length == 0){
        favButton.setAttribute('class','favoriteButton')

    } else if (localStorage.getItem('favorites')){
        console.log(favorites.length)
        for (let i = 0; i < favorites.length; i++){
            if (JSON.stringify(favorites[i]) == JSON.stringify(element)){
                favButton.setAttribute('class','favoriteActive')
            }
        }
    }


    favButton.addEventListener('click', function() {favorite(element['id'], favButton);})
    span.appendChild(favButton)

    //Create info button
    let infoButton = document.createElement('button');
    infoButton.setAttribute('class','infoButton')
    infoButton.addEventListener('click', function() {information(element);})

    span.appendChild(infoButton)

    card.appendChild(span)

    document.getElementById('cardContainer').appendChild(card); 
}

function clearDeck(){
    let container = document.getElementById('cardContainer')
    let length = container.childNodes.length;

    //DELETE ALL CARDS PREVIOUSLY ON SCREEN TO REDRAW
    for (let i = 0; i < length; i++){
        let card = document.querySelector('.card')
        container.removeChild(card);
    }
}

function drawFavorites(){

    clearDeck()

    if(localStorage.getItem('favorites')){

        let locations = JSON.parse(localStorage.getItem('favorites'));
        locations.forEach((element) => {
            cardCreator(element)
        })
    }

}


function favorite(id, button){

    //Checks if class is the activated favorite button or unactivated
    if (button.className == 'favoriteActive'){
        button.setAttribute('class','favoriteButton')
        favorites.splice(favorites.indexOf(shoppingLocations[id]), 1)

    } else if (button.className == 'favoriteButton'){
        button.setAttribute('class','favoriteActive')
        favorites.push(shoppingLocations[id]);
    }

    let store = JSON.stringify(favorites);

    //stores updated favorites into local storage
    localStorage.setItem('favorites', store)

}

function information(element){
    //BIG DOM creation for info popup

    let div = document.createElement('div');
    div.setAttribute('class','information')

    //Create Image
    let image = document.createElement('img');
    image.setAttribute('class','informationImage')
    image.setAttribute('src', ("assets/" + element["image"]))
    div.appendChild(image)

    //Create Name
    let name = document.createElement('h1');
    name.setAttribute('class','informationName')
    let nameContent = document.createTextNode(element["name"])
    name.appendChild(nameContent);
    div.appendChild(name)

    //Create Address
    let address = document.createElement('h2');
    address.setAttribute('class','informationName')
    let addressContent = document.createTextNode(element["address"])
    address.appendChild(addressContent);
    div.appendChild(address)

    //Create Description
    let desc = document.createElement('p');
    desc.setAttribute('class','informationParagraph')
    let descContent = document.createTextNode(element["description"])
    desc.appendChild(descContent);
    div.appendChild(desc)

    let phone = document.createElement('h2');
    phone.setAttribute('class','informationName')
    let phoneContent = document.createTextNode(element["phone"])
    phone.appendChild(phoneContent);
    div.appendChild(phone)


    //Create close button
    let close = document.createTextNode("Close")

    let closeButton = document.createElement('button')
    closeButton.appendChild(close);
    closeButton.setAttribute('class','closeButton')
    closeButton.addEventListener('click', function() {
        div.remove()

    })
    div.appendChild(closeButton)




    document.getElementsByTagName('body')[0].appendChild(div); 

}