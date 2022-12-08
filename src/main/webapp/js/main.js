$(document).ready(function () {

    $(".check-button").click(function () {
            let x = $(".x-text-area").val();
            let y = $(".y-value").val();
            let r = $(".r-value").val();

            if (!(3 <= x <= 5)) {
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
            500)
    }
})
