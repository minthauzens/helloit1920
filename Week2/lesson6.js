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
    
    if (lock) {
        clearTimeout(lock)
    }

    // sadi lai butu tikai pedeja vertiba

    lock = setTimeout(() => console.log("Delayed"), 2000);
    
}

$(window).on('load', () => {
    $('#colorME').click(colorChange)
    console.log('test123')
})

