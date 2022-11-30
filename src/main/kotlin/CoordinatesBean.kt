
import jakarta.enterprise.context.SessionScoped
import jakarta.faces.context.FacesContext
import jakarta.inject.Named
import java.io.Serializable

@Named("coordinates")
@SessionScoped
class CoordinatesBean: Serializable {

    fun applyHit(){

        val x = FacesContext.getCurrentInstance().externalContext.requestParameterMap["x"]
        val y = FacesContext.getCurrentInstance().externalContext.requestParameterMap["y"]
        val r = FacesContext.getCurrentInstance().externalContext.requestParameterMap["r"]

        println(FacesContext.getCurrentInstance().externalContext.requestParameterMap.toString())
        println(x)
        println(y)
        println(r)

    }
}