

function favorite(item){
    if(localStorage.getItem("favorites")){
        favs = JSON.parse(localStorage.getItem("favorites"))
    }
    favs.push(item);
    localStorage.setItem("favorites", JSON.stringify(favs));
}
