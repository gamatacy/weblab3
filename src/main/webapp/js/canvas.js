import * as main from "./main.js";

$(document).ready(function () {
    let canvas = document.getElementById("graph")
    let ctx = canvas.getContext("2d")

    // $("#graph").mousemove(function (event) {
    //     let r = $("#r-value").val();
    //
    //     if (r != "") {
    //         $(".check-button").html((`X: ${getCoordinate(event.offsetX, "r", r).toString().substring(0,4)} Y: ${getCoordinate(event.offsetY, "y", r).toString().substring(0,4)}`))
    //     }
    // })
    //
    // $("#graph").mouseout(function(){
    //     $(".check-button").html("check")
    // })
    //
    //
    // $("#graph").click(function (event) {
    //     let r = $("#r-value").val();
    //
    //     if (r == "") {
    //         main.changeCheckButtonText("Select R")
    //         return false
    //     }
    //
    //     drawHit(event.offsetX, event.offsetY, ctx)
    //
    // })

})

function drawHit(x, y, ctx) {
    ctx.beginPath()
    ctx.arc(x, y, 3, 0, Math.PI * 2)
    ctx.fill()
}

function loadData() {
    console.log("funworks")
    let canvas = document.getElementById("graph")
    let ctx = canvas.getContext("2d")
    $(".hit-value").each(function (i,element){
        console.log(element.value)
        let data = JSON.parse(element.value)
        ctx.beginPath()
        drawHit(data.x * (154 / data.r) + 330, Math.abs(data.y * (154 / data.r) - 340), ctx)
        ctx.fill()
    })
}