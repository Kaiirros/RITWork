/*

CREATED BY DANIEL MCKEE FOR ISTE 340 CLIENT PROGRAMMING

Notes:
> Data is scalable and can take as many option inputs as needed/inputted
> Cookies save through the form, storing the first name of the user and printing it onto the title of the page (and the form is also validated)
> Local storage holds the user's last complete selection list history
> Code is a bit of a mess, left comments where it was most messy

This project was fun, and I am going to try to expand this further on my own time

*/
    var data = {

    //Each data set variable name is constructed on the chosen prompt with spaces and uppercase removed
    //ex. "Option Number One" will have the assosciated variable name of "optionnumberone"; This way I can easily take the string of the option chosen and just pass it through to get the next set
    init: ['You find yourself in a dimly lit cavern, alone and lacking any material possessions besides the clothes on your back. There are two passage ways in your view, what do you do?',
    'Explore the left passage way','Explore the right passage way'],

    exploretheleftpassageway: ['Entering the left passage way, there are no noticeable sounds besides the gentle dripping of a singular water droplet onto an eroded rock. Further ahead, you can see a light source...',
    'Search the light source','Look under the rock'],

    lookundertherock: ['You flip the rock over... really? Anyways, there is nothing so you flip it back. ',
    'Search the light source', 'Look under the rock again'],
    
    lookundertherockagain: ['Seriously? There is still nothing. ',
    'Search the light source','Check the rock one last time'],

    checktherockonelasttime: ['Oh? Wait a second, it looks like there is... oh, still nothing.',
    'Search the light source'],

    searchthelightsource: ['You approach the light source cautiously. As you gain closer, you realize it appears to be a shiny yet worn dagger, discarded onto the ground.',
    'Pick up the dagger','Leave the dagger'],

    pickupthedagger: ['You grab the dagger and gain a nice sense of security. Surely nothing can scare you now? As you continue forward, you can see an intimidating silhouette outlined by sunlight by the opening of the cave.',
     'Attack the silhouette with your dagger', 'Attempt to speak to it'],

    attackthesilhouettewithyourdagger:["You violently lash out against the outline striking it multiple times... it doesn't seem to be fighting back. After getting a closer look, it turns out to be multiple rocks stacked on top of each other. Good thing no one was there to witness that, or you'd be quite embarrassed.",
    'Leave the cave'],

    attempttospeaktoit: ["You attempt to speak with the outline, but it does not speak back... upon closer inspection, it seems to just be some rocks stacked on each other. Good thing you didn't try to attack it. That would be embarassing.",
    'Leave the cave'],

    leavethecave: ['You have successfully left the treacherous cave of horrors! Now to figure out how you got there... [END]',
    '[END]'],

    leavethedagger: ["You decide to leave the dagger where it lies. Maybe you're too good for it? (Or a little dense...) You continue down the left passage way until you come across an intimidating silhouette outlined by sunlight by the opening of the cave.",
    'Attempt to fist fight the outline','Attempt to speak to it'],

    attempttofistfighttheoutline: ['You engage in fisticuffs with the unidentified bogey. After a few good jabs, it begins to fall towards you. Only just realizing your aggressive foe was no more than a stack of rocks, you respond too slow, and are crushed by your enemy. Oh well. [END] ',
    '[END]'],

    exploretherightpassageway: ['Entering the right passage way, there is a slight breeze accompanying the pitch black cave. Moving further into the darkness, you brush up against multiple strands of what feels like hair...',
    'Continue forwards without question','Investigate the strands of hair'],

    continueforwardswithoutquestion: ['You continue to push forward, completely blind to what may lie ahead... OUCH. Deep fangs pierce into your arm followed quickly by a searing pain. Dozens of red eyes highlight the previously pitch black cave...',
    'Accept your fate','RUN DEEPER'],

    investigatethestrandsofhair: ["You feel up the suspicious hair on the side of the cave... you've never quite touched a large spider before, but if you did, you imagine this is what it would feel like.",
    'Try to pull the hair off the wall','Continue forwards without question'],

    trytopullthehairoffthewall: ['Okay... you try to pull the hair off of the wall... OUCH. Deep fangs pierce into your arm followed quickly by a searing pain. Dozens of red eyes highlight the previously pitch black cave...',
    'Accept your fate','RUN DEEPER'],

    acceptyourfate: ['You curl into a fetal position and think of happy things like Client Programming... It seems like this is the end for your story. [END]',
    '[END]'],

    rundeeper: ["You quickly push past the eyes and impending doom about to consume you. You feel like you're running for what feels like hours until you crash through a thin wall in the cave. Light floods your eyesight as you emerge out of the cave. You're safe now... time to figure out how you got there... [END]",
    '[END]']


    }

    var path = new Array()


//COOL ASS ANIMATION FROM THE LEFT (run when new box is created)
function fromLeftAnimation(dom, end, delta){
	let pos = parseInt(dom.style.marginLeft);
	if (pos < end){
		dom.style.marginLeft = pos + delta + "px";
		requestAnimationFrame( function(){fromLeftAnimation(dom, end, delta);});
	}
}


//Important, takes in the div that is being changed, removes everything after it if needed, and then makes new selection
function newOptionSelected(divContainer, option){

    if(document.getElementsByClassName('formContainer')[0]){
        document.getElementsByClassName('formContainer')[0].remove()
    }

    let current = path.indexOf(divContainer)
    let length = path.length;
    // for everything after the div that is changed, please delete it
    for (let i = current+1; i < length; i++){
        let d = path[i]
        d.remove();

    }
    generateNewSelection(option)

}


//Will take every selection chosen and construct it into a final form to save/review
function getFinalSelections(){

    //creation of final choices div
    let selections = document.getElementsByTagName('div');
    let formContainer = document.createElement('div');
    let formTitle = document.createElement('h2');
    formTitle.textContent = "Your exciting adventure!"
    formContainer.appendChild(formTitle);
    formContainer.setAttribute('class', 'formContainer');
    //====================================================

    let stringConstructor = "";

    //THIS ARRAY IS FOR SAVING THE PATH INTO LOCAL STORAGE
    let optionArray = new Array(selections.length-1)
    //====================================================




    for (let i = 0; i < selections.length-1; i++){
        let pText = document.createElement('p');
        stringConstructor = i+1 + ". " + selections[i].getElementsByTagName('select')[0].value;
        optionArray[i] = selections[i].getElementsByTagName('select')[0].value;
        pText.textContent = stringConstructor;
        formContainer.appendChild(pText);
    }

    //[SAVE WITH COOKIE/LOCALSTORAGE]=====
        saveRun(optionArray)
    //====================================

    //Little prompt that is chosen based on how many choices were selected
    let hThree = document.createElement('h3');
    if (selections.length-1 <= 3){
        hThree.textContent = "Wow. Can't say it was a long run, but it sure was fun!";
    } else if(selections.length-1 >= 7) {
        hThree.textContent = "You certainly were fascinated by that rock huh.";
    } else {
        hThree.textContent = "Look at that! I'm impressed. What adventures await you next?";
    }

    formContainer.appendChild(hThree);

    document.getElementsByTagName('body')[0].appendChild(formContainer);


}

//Initialization Function, start of form
function init(){

    //Takes localstorage history and constructs it on page
    if (localStorage.getItem('lastRun')){
        createHistory(localStorage.getItem('lastRun'))
    }

    //If cookie exists, display name on screen
    if (GetCookie('user_id')){
        useCookie()
    }


    //Creation of div container and inner elements
    let divContainer = document.createElement('div');
    divContainer.setAttribute('class', 'container');
    divContainer.style.marginLeft = "-1000px";

    //header
    let hEle = document.createElement('h3');
    hEle.setAttribute('class','question');

    //selection
    let selection = document.createElement('select');
    selection.setAttribute('class','select')

    //options
    let optionHolder = new Option("[Select Option]")
    optionHolder.setAttribute('class','option')
    selection.add(optionHolder);

    //Option Constructor (Uses length of dataset and creates context and options)
    for (let i=1; i < data.init.length; i++){
        var option = new Option(data.init[i])
        option.setAttribute('class','option')
        selection.add(option);
    }

    //Appending the created element
    divContainer.appendChild(hEle);
    divContainer.appendChild(selection);
    hEle.appendChild(document.createTextNode(data.init[0]));
    
    //Finally appends div to body
    document.getElementsByTagName('body')[0].appendChild(divContainer);
    selection.onchange = () => {newOptionSelected(divContainer, selection.value.toLowerCase().replace(/\s/g, ''))};
    path.push(divContainer);
    requestAnimationFrame( function() {fromLeftAnimation(divContainer, 10, 15);})

    }


    //-------------------------------------------------------------------------------

//This constructor function will continuously create a new selection based on the selection passed into it from the original init function
function generateNewSelection(selected){

    //DOM Creations ======================================
    let divContainer = document.createElement('div');
    divContainer.setAttribute('class', 'container');
    divContainer.style.marginLeft = "-1000px";
    let hEle = document.createElement('h3');
    hEle.setAttribute('class','question');
    let selection = document.createElement('select');
    selection.setAttribute('class','select')
    //====================================================

    //If one of the choices is [END], end the cycle
    if (data[selected][1] === "[END]"){

        let optionHolder = new Option("[END]")
        optionHolder.setAttribute('class','option')
        selection.add(optionHolder);

    } else {

        //Else, let the boys play (continue construction of questions)
        let optionHolder = new Option("[Select Option]")
        optionHolder.setAttribute('class','option')
        selection.add(optionHolder);

        for (let i=1; i < data[selected].length; i++){
            var option = new Option(data[selected][i])
            option.setAttribute('class','option')
            selection.add(option);
        }        
    }


    divContainer.appendChild(hEle);
    divContainer.appendChild(selection);
    hEle.appendChild(document.createTextNode(data[selected][0]));

    document.getElementsByTagName('body')[0].appendChild(divContainer);


    //when the selection option is changed, pass in what is selected to determine next dataset prompt
    selection.onchange = () => {newOptionSelected(divContainer, selection.value.toLowerCase().replace(/\s/g, ''))};

    path.push(divContainer);

    //Animation Creation (element, endPosition, rateOfChange)
    requestAnimationFrame( function() {fromLeftAnimation(divContainer, 10, 15);})

    if (data[selected][1] === '[END]'){
        getFinalSelections()
    }
}


//===================================[COOKIES (thank you for code)]================================================
function getCookieVal (offset) {
	var endstr = document.cookie.indexOf (";", offset);
	if (endstr == -1) { endstr = document.cookie.length; }
	return unescape(document.cookie.substring(offset, endstr));
	}

function GetCookie (name) {
	var arg = name + "=";
	var alen = arg.length;
	var clen = document.cookie.length;
	var i = 0;
	while (i < clen) {
		var j = i + alen;
		if (document.cookie.substring(i, j) == arg) {
			return getCookieVal (j);
			}
		i = document.cookie.indexOf(" ", i) + 1;
		if (i == 0) break; 
		}
	return null;
	}

function DeleteCookie (name,path,domain) {
	if (GetCookie(name)) {
		document.cookie = name + "=" +
		((path) ? "; path=" + path : "") +
		((domain) ? "; domain=" + domain : "") +
		"; expires=Thu, 01-Jan-70 00:00:01 GMT";
		}
	}

/////////
// use:
//		SetCookie('name', 'value', 3000);
//		SetCookie('name', 'value', 1000,false,false,false,true);
//		If set the secure (last arg) to true, you MUST be on an https connection!
/////////
function SetCookie (name,value,maxAge,path,domain,sameSite,secure) {
  document.cookie = name + "=" + escape (value) +
    ((maxAge) ? ";max-age=" + maxAge  : "") +
    ((path) ? ";path=" + path  : "") +
    ((domain) ? ";domain=" + domain : "") +
    ((sameSite) ? ";samesite=" + sameSite : ";samesite=strict") +
    ((secure) ? ";secure;" : ";");
}

//Takes in the last run through completed to save in local storage
function saveRun(run){
    //does browser understand local storage
	if(window.localStorage){
	    //if true, yay
		//do localStorage storage
		if(run){
			//something to store
            let jsonRun = JSON.stringify(run)
			localStorage.setItem("lastRun", jsonRun);

		}

		//
		if (localStorage.getItem('lastRun')){
			createHistory(localStorage.getItem('lastRun'));
		}
    } else {
        console.log("uh oh");
    }
}


function createHistory(storedItem){

    //Check to see if history exists, if so, remove it
    if (document.getElementById('history')){
        document.getElementById('history').remove();
        document.getElementById('historyTitle').remove()
    } 

    //Json parsing yada yada
    let storedArray = JSON.parse(storedItem)

    let form = document.getElementById('form')
    let span = document.createElement('span')
    span.setAttribute('id','history')

    //For the loop, take array of elements from form and add them to the history span
    for (let i=0; i < storedArray.length; i++){
        let pText = document.createElement('p');
        pText.textContent = storedArray[i];

        span.appendChild(pText);
    }

    let hThree = document.createElement('h3');
    hThree.setAttribute('id','historyTitle')
    hThree.textContent = "History (Last full run)";
    form.appendChild(hThree);
    form.appendChild(span);

}

function val(){

    let ret = true;

    //JS validation
        if(document.getElementById('fn').value == ''){
            ret = false;
        }
        if(document.getElementById('ln').value == ''){
            ret = false;
        }

        //if validation is true, make cookie using info inputted
        if (ret){
            cookieCreate();
        }

        return ret;
}

function cookieCreate(){

        if(GetCookie("user_id") == null){
            //first time 
            var name = document.getElementById('fn').value
            text = document.getElementById('supremeTitle').textContent

            text += ", " + name + "!";

            document.getElementById('supremeTitle').textContent = text;

            //write the cookie
            SetCookie('user_id', name);

            return true;
        }
        return false;
}

function useCookie(){

    //they have been here before
    text = document.getElementById('supremeTitle').textContent

    text = "Welcome back, " + GetCookie('user_id') + "! Choose Your Adventure!";

    document.getElementById('supremeTitle').textContent = text;


    //add to the hit count
}