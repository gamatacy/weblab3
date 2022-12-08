function updateClock(){
    $(".time-cell").html(new Date().toLocaleTimeString('it-IT'))
}

function updateHiddenClock(){
    $(".hidden-time-cell").val(Intl.DateTimeFormat().resolvedOptions().timeZone)
}

updateClock()
updateHiddenClock()
setInterval(updateClock, 7000)
setInterval(updateHiddenClock, 1000)