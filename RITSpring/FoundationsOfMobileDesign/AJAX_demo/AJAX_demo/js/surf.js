const xhr = new XMLHttpRequest();
const url = "data/surfspots.json";
let output = "";

/// Load data with XMLHttpRequest
xhr.addEventListener("load", function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
        console.log(this.response);
        const Spots = JSON.parse(xhr.response);
        console.log(Spots);
        
        // This just sets the entire response into localStorage
        localStorage.setItem ("Spot Objects",JSON.stringify(Spots)); 

        for (let spot of Spots) {
            output += surfTemplate(spot);
        }
        addElement(output); 
    }
    function addElement (data_input) {
        // create a new div element, append it to main
        const newDiv = document.createElement("div");
        newDiv.id = "display";
        newDiv.insertAdjacentHTML('afterbegin', data_input);
      
        const currentDiv = document.getElementById("card_list");
        currentDiv.appendChild(newDiv);
      }
});

xhr.open("GET", url, true);
xhr.send();

function surfTemplate(spots){

 return `
    <div class = "spot" onclick="saveSelection(${spots.id})">
    <img class = "spot-photo" src = "${spots.photo}">
    <h2 class = "spot-name">${spots.spot}</h2>
    </div>`

}

 function saveSelection(sel) {
     localStorage.setItem ("selected",sel );
     window.open("details.html", "_self");
 }

 const list = (spot) => {
    let div = document.createElement("div")
    div.innerHTML = `
        <h2>${spot.spot}</h2>
        <ul>
            <li>Wavehold: ${spot.wavehold}</li>
            <li>Swell Direction: ${spot.swelldirection}</li>
            <li>Offshore: ${spot.offshore}</li>
            <li>Tide: ${spot.tide}</li>
        </ul>
        <img src=${spot.photo}>
    `
    // console.log(div)
    return div;
}

const listAll = () => {
    const display = document.getElementById("display")
    for(const spot of surfSpots) {
        display.appendChild(list(spot))
    }
}




