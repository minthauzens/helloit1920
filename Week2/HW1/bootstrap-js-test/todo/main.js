/**
 * TODO LIST Version 1
 * DOM
 */

let textField = document.getElementById('textField');
let button = document.getElementById('taskButton');
let taskList = document.querySelector('#taskList');

// difference between getElementById and querySelector
// šķietami querySelector ir plasāks

button.onclick = function () {

    let newTask = document.createElement('LI');
    let taskText = textField.value;
    let taskTextNode = document.createTextNode(taskText);

    let checkbox = document.createElement('input');
    checkbox.type = 'checkbox';

    checkbox.onclick = function () {
        newTask.setAttribute('style', 'text-decoration: line-through; opacity: 0;');
        // newTask.setAttribute('style', '');


        window.setTimeout(function () {
            taskList.removeChild(newTask);
        }, 2000);
    }

    newTask.appendChild(checkbox);
    newTask.appendChild(taskTextNode);
    taskList.appendChild(newTask);

    textField.value = '';

}
