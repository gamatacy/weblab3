$(document).ready(function () {

    $(".check-button").click(function () {
            let x = $(".x-text-area").val();
            let y = $(".y-value").val();
            let r = $(".r-value").val();

            if (parseFloat(x) <= -3 || parseFloat(x) >= 5 || x == "") {
                changeCheckButtonText("Wrong X")
                return false
            }

            if (y == "") {
                changeCheckButtonText("Select Y")
                return false
            }

            if (r == "") {
                changeCheckButtonText("Select R")
                return false
            }



        }
    )

    function changeCheckButtonText(message) {
        $(".info-text-area").html(message)
        setTimeout(() => {
                $(".info-text-area").html("")
            },
            1000)
    }
})
