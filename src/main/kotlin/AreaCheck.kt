import kotlin.math.pow

class AreaCheck {
    companion object{
        fun check(x: Float? , y: Float?, r: Float?): Boolean{

            if (x == null || y == null || r == null){
                return false
            }

            return  checkCircle(x, y, r) || checkSquare(x, y, r) || checkTriangle(x, y, r)
        }

        private fun checkTriangle(x: Float, y: Float, r: Float): Boolean {
            return (y <= ((r - x) / 2)) && (y in 0.0..r.toDouble()) && (x <= 0 && x >= -r)
        }
        private fun checkSquare(x: Float, y: Float, r: Float): Boolean {
            return (x <= r / 2 && x >= 0) && (y in 0.0..r.toDouble())
        }
        private fun checkCircle(x: Float, y: Float, r: Float): Boolean {
            return ( x.pow(2) + y.pow(2) <= (r).pow(2) && (x <= 0 && y <= 0) )
        }
    }


}