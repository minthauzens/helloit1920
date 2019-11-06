let currentStoneCount;
let vsHuman;        // maybe could be const -> this doesnt change after init but needs to be accessed
let isPlayer1Turn;
let winner;
let isPlayer1Human;
// let turn;

function startGame() {
    currentStoneCount = getMaxStones();
    vsHuman = getOpponent();
    isPlayer1Turn = true;
    isPlayer1Human = getWhoHasFirstTurn();
    // turn = 1;
    // ! toggleVisibility();
    displayStoneCount();

    

    if (isHumanTurn()){
        botTurn();
    }

    // getPlayerNames;

    // test if play vs another player or vs bot
    // with another prompt maybe game start doesnt;

    // add history

}

function isHumanTurn() {
    if (vsHuman) {
        return true;
    } else if ((isPlayer1Human && isPlayer1Turn)
        || (!isPlayer1Human && !isPlayer1Turn)) {
            console.log("HUMAN TURN")
        return true;
    } else{
        console.log("BOT TURN")
        return false;
    }
}

function getWhoHasFirstTurn() {
    return (document.querySelector('input[name="turn1"]:checked').value === "true");
}

function displayStoneCount() {
    document.getElementById("stoneCount").innerText = currentStoneCount;
}

function addToHistory(num) {
    const message = "amount taken " + num + ", left:"+ currentStoneCount;
    let node = document.createElement('li');
    let textnode = document.createTextNode(message);
    node.appendChild(textnode);
    document.getElementById("history").appendChild(node);
}

function take(num) {
    if (currentStoneCount >= num) {
        currentStoneCount -= num;
        displayStoneCount();
        checkEndGame();
        isPlayer1Turn = !isPlayer1Turn;
        addToHistory(num);
        // console.log(turn + ") amount taken " + num);
        // turn++;
    } else {
        // TODO: improve this with better design (css and display)
        alert("you cant take more than the current stone count!")
    }
    console.log('take test')
    if (!isHumanTurn()) {
        console.log('bot turn test')
        botTurn();
    }

}

function botTurn() {
    // check if can take
    let ran3;
    do {
        ran3 = Math.floor(Math.random() * 2) + 1; 
    } while (ran3 <= currentStoneCount)
    take(ran3);

}

function disableTake() {
    document.getElementsByClassName('take').disabled = true;
}

function checkEndGame() {
    if (currentStoneCount === 0) {
        winner = (isPlayer1Turn) ? "1" : "2";
        alert("winner player " + winner);
        // disableTake();
    }
}

function getMaxStones() {
    return Number((document.getElementById('maxStones').value) ? (document.getElementById('maxStones').value) : (document.getElementById('maxStones').getAttribute("placeholder")));
}

function getOpponent() {
    return (document.querySelector('input[name="versus"]:checked').value === "true");
}

function toggleVisibility() {
    document.getElementById('gameSetupContainer').classList.add("d-none");
    document.getElementById('gamePlayContainer').classList.remove("d-none");
}
