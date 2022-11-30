
function updateClock(){
    $(".time-cell").html(new Date().toLocaleTimeString('it-IT'))
}

updateClock()
setInterval(updateClock, 7000)