package beans

import AreaCheck
import database.ResultsDao
import jakarta.enterprise.context.SessionScoped
import jakarta.enterprise.inject.spi.CDI
import jakarta.faces.context.FacesContext
import jakarta.inject.Named
import javax.persistence.*
import lombok.NoArgsConstructor
import java.io.Serializable
import java.lang.NumberFormatException
import java.time.*
import java.time.format.DateTimeFormatter

@Entity
@Named
@SessionScoped
@NoArgsConstructor
@Table(name = "results")
class ResultBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var result: Boolean? = null,
    var x: Float? = null,
    var y: Float? = null,
    var r: Float? = null,
    var time: ZonedDateTime? = null,
    var execTime: Long? = null
) : Serializable {

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


            val result = AreaCheck.check(x , y, r)
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

    fun getFormattedTime(): String {
        var offset = FacesContext.getCurrentInstance().externalContext.requestParameterMap["offset"].toString()
        if (offset == "null") offset = "Europe/Moscow"
        return time?.withZoneSameInstant(ZoneId.of(offset))?.toLocalTime()?.format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString()
    }

    override fun toString(): String {
        return "ResultBean(id=$id, result=$result, x=$x, y=$y, r=$r, time=$time, execTime=$execTime)"
    }


}