package beans

import database.ResultsDao
import jakarta.enterprise.context.SessionScoped
import jakarta.inject.Named
import javax.persistence.*
import lombok.NoArgsConstructor
import java.io.Serializable
import java.time.LocalDate

@Entity
@Named("result")
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
    var time: LocalDate? = null,
    var execTime: Long? = null
): Serializable {

    fun select(){
        ResultsDao.getResults()
    }

}