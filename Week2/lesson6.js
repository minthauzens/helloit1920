console.log("test");


// jQuery - topic our todays lesson
let counter = 0;

function jQueryTestFunctions() {
    counter++;

    // if there are multiple elements of selector returns array of them
    $('div').append("test")
    // appends to all the elements of the array
    // ie affects all the selected elements

    $('div').css("background-color", "black");

    // these selectors vwork the same as css selectors (can you use psaedo selectors?)

    $('body').append("<div> Button was pressed " + counter + " times </div>")
    // $('body').append(`<div> Button was pressed ${counter} times </div>`)
    // above lines are the same - for easier insert of variables
    // JS 2016 - standartā šī ērtā feature

    $('div').toggle()
    // toggle visibility -> hidden?

    $('div').toggleClass("className");
}

function count() {
    counter++;

    $("button").click(function () {
        alert("this button was already pressed");
    })

    // this overwrites the buttons onclick effekt to this after 1st time
}

// jQuery CORE is important
// https://api.jquery.com/category/core/

// jQuery('div') === $("div")

// $ - is a library and an object at the same time
// $('div) and $.holdReady

// $(window).load();
// $(document).ready(function () {
    
// });

// there is slight difference between these two

// jQuery can have multiple the same triggers

// $("button").onClick(alert("button 1"))
// $("button").onClick(alert("button 2"))

let lock;

function colorChange() {
    let red = Math.floor(Math.random()*256);
    let blue = Math.floor(Math.random()*256);
    let green = Math.floor(Math.random()*256);

    $('#colorME').css('background-color', `rgb(${red}, ${blue}, ${green})`);
    
    // if (lock) {
    //     clearTimeout(lock)
    // }

    // // sadi lai butu tikai pedeja vertiba
    // // setTimeout - izsauc funckiju pec timeout
    // lock = setTimeout(() => console.log("Delayed"), 2000);

    
    
}

function onPress() {
    setInterval(() => {
        colorChange();
    }, 100);
}

$(window).on('load', () => {
    // onPress();
    getJoke();
    // $('#colorME').click(colorChange)
    // console.log('test123')
})

// difficult to understand when to give function and when to give testFun() and when testFun

/* 
    each every HTTP request consists of:
    HTTP request:
        0. Type
        1. Address
        2. Headers
        3. Body

    HTTP resonse:
        1. Headers
        2. Body

    publicly available REST API

    Postman - 
    Advanced REST client
*/

function getJoke() {
    const url = 'http://api.icndb.com/jokes/random';
    const joke = $.get(url, (response) => {
        console.log(response)
        $('body').append(response.value.joke)
    });
    //this line would not display joke
    console.log(joke.responseJSON);

    setTimeout(()=>console.log(joke.responseJSON), 500);

    // js asyncron programming language
    // FOR REQUESTS - have to wait for result!!!!!

}


/// API - application programming interface

