$(document).ready(function () {
    let canvas = document.getElementById("graph")
    let ctx = canvas.getContext("2d")

    $("#graph").mousemove(function (event) {
        let r = $(".r-value").val();

         if (r != "") {
             $(".info-text-area").html((`X: ${getCoordinate(event.offsetX, "r", r).toString().substring(0,4)} Y: ${getCoordinate(event.offsetY, "y", r).toString().substring(0,4)}`))
         }
     })

     $("#graph").mouseout(function(){
         $(".info-text-area").html("")
     })


     $("#graph").click(function (event) {
         let r = $("#r-value").val();
         if (r == "") {
             $(".info-text-area").html("Select R")
             return false
         }

     })

})

function getCoordinate(coordinate, coordinate_name, r) {
    let segment = 154 / r
    if (coordinate_name == "r") {
        return (coordinate - 330) / segment
    } else {
        return (340 - coordinate) / segment
    }

}

function drawHit(result, x, y, ctx) {
    ctx.beginPath()
    if (result == "false"){
        ctx.fillStyle = "red"
    }else {
        ctx.fillStyle = "black"
    }
    ctx.arc(x, y, 3, 0, Math.PI * 2)
    ctx.fill()
}

function drawHits(){
    let canvas = document.getElementById("graph")
    let ctx = canvas.getContext("2d")
    let table = document.getElementById("results_data");
    for (let i = 0; i < table.rows.length; i++) {
        let r =table.rows[i].cells[3].innerText

        if (parseFloat(r) == parseFloat($(".r-value").val())){
            let result = table.rows[i].cells[0].innerText
            let x = table.rows[i].cells[1].innerText
            let y = table.rows[i].cells[2].innerText
            const x1 = (x/r*canvas.width/2+canvas.width/2)
            const y1 = canvas.height-(y/r*canvas.height/2+canvas.height/2)
            drawHit(result,x * (154 / r) + 330, Math.abs(y * (154 /r) - 340), ctx)
        }
    }
}

setInterval(drawHits, 1000)
