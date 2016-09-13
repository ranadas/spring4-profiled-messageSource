$(document).ready(
    function () {
        console.log("In custom js, declaring globals");
    }
);
// function to hide & show
var dispplayFunction = function (eventName) {
    if (eventName === 'create') {
        console.log(" Showing canvas 1");
        $('#canvas1').show();
        $('#canvas3').hide();
        document.getElementById('displaycan').innerHTML = "<strong>Displaying :</strong>" + 'CREATE';
    }
    else if (eventName === 'modify') {
        console.log(" Showing canvas 3");
        $('#canvas1').hide();
        $('#canvas3').show();
        document.getElementById('displaycan').innerHTML = "<strong>Displaying :</strong>" + 'MODIFY';

    }
    else if (eventName === 'all') {
        console.log(" Showing all canvas ");
        $('#canvas1').show();
        $('#canvas3').show();
        document.getElementById('displaycan').innerHTML = "<strong>Displaying :</strong>" + 'ALL';

    }
};