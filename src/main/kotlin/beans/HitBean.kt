package beans

import database.ResultsDao
import jakarta.enterprise.context.SessionScoped
import jakarta.faces.context.FacesContext
import jakarta.inject.Named
import java.io.Serializable
import java.lang.NumberFormatException
import java.time.ZoneId
import java.time.ZonedDateTime

@Named
@SessionScoped
class HitBean() : Serializable {
    fun applyHit() {
        try {
            val startTime = System.nanoTime()

            val x = FacesContext.getCurrentInstance().externalContext.requestParameterMap["x"]?.toFloat()
            val y = FacesContext.getCurrentInstance().externalContext.requestParameterMap["y"]?.toFloat()
            val r = FacesContext.getCurrentInstance().externalContext.requestParameterMap["r"]?.toFloat()
            val offset = FacesContext.getCurrentInstance().externalContext.requestParameterMap["offset"]

            if (x == null || y == null || r == null || offset == null) {
                throw NullPointerException("Null param!")
            }

            if (x <= -3 || x >= 5) {
                throw NullPointerException("Wrong X!")
            }

            val result = AreaCheck.check(x, y, r)
            val execTime = (System.nanoTime() - startTime) / 10000

            val resultInfo = ResultBean()
            resultInfo.result = result
            resultInfo.x = x
            resultInfo.y = y
            resultInfo.r = r
            resultInfo.execTime = execTime
            resultInfo.time = ZonedDateTime.now().withZoneSameInstant(ZoneId.of(offset))

            ResultsDao.add(resultInfo)

        } catch (e: NumberFormatException) {
            println("No args passed")
        } catch (ne: NullPointerException) {
            println(ne.message)
        }
    }

    fun getHits(): MutableList<Any?> {
        return ResultsDao.getResults()
    }
}