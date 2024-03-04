var dinos = [
    {
       "id":          0,
       "name":        "Pisanosaurus",
       "Period":      "Late Triassic",
       "diet":        "Herbivorous",
       "length":      "0.9m",
    }
 ];

 function show(){
   
   let boxes = Object.values(dinos);
   console.log(boxes);
   boxes.forEach(element => console.log(element));
   
 }