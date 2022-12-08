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

    fun getFormattedTime(): String {
        var offset = FacesContext.getCurrentInstance().externalContext.requestParameterMap["offset"].toString()
        if (offset == "null") offset = "Europe/Moscow"
        return time?.withZoneSameInstant(ZoneId.of(offset))?.toLocalTime()
            ?.format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString()
    }

    override fun toString(): String {
        return "ResultBean(id=$id, result=$result, x=$x, y=$y, r=$r, time=$time, execTime=$execTime)"
    }


}