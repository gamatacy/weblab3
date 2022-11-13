import jakarta.annotation.ManagedBean
import jakarta.enterprise.context.SessionScoped
import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.NoArgsConstructor
import java.time.LocalTime
import java.io.Serializable

@Entity
@ManagedBean
@SessionScoped
@NoArgsConstructor
class ResultBean(
    @Id
    var id: Int? = null,
    var result: Boolean? = null,
    var x: Float? = null,
    var y: Float? = null,
    var r: Float? = null,
    var time: LocalTime? = null,
    var execTime: Long? = null
): Serializable {

}