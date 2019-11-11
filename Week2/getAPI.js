// cmd echo
// cmd more

/*
    TODO:
        * disable buttons if GET request hasnt gotten its response
*/

const apiUrl = 'https://api.chucknorris.io/jokes/';

$(window).on("load", () => {
    console.log('window loaded');
    getCategories();

    //todo: only allow max 10 jokes to display
    
})


function getAJoke(url) {
    const joke = $.get(url, (response) => {
        console.log(response);
        $('#contentContainer').append($('<p>', { 
            text : response.value 
        }));
    })
}

function getARandomJoke() {
    const url = apiUrl + "random";
    getAJoke(url);
}

function getCategories() {
    const url = apiUrl + "categories";
    const categories = $.get(url, (response) => {
        $.each(response, function (i, category) {
            $('#categoriesSelect').append($('<option>', { 
                value: category,
                text : category 
            }));
        });
    })
}

function getAJokeByCategory() {
    const category = $("#categoriesSelect > option:selected").val();
    console.log(category);
    if (category === "") {
        alert('please select valid category: ' + category);
        return;
    }
    const url = apiUrl + `random/?category=${category}`;
    getAJoke(url);
}

function get10JokesByQuery(){
    const query = $("#textQuery").val();
    console.log(query);
    if (query === "") {
        alert("empty query");
        return;
    }
    const url = apiUrl + `search?query=${query}`;
    $.get(url, (response) => {
        // console.log(response);
        $.each(response.result, function (i, joke) {
            if (i < 10) {
                // console.log(joke)
                $('#contentContainer').append($('<p>', { 
                    text : joke.value 
                }));
            }
        });
        // $("#contentContainer").append(response.value);
    })
}