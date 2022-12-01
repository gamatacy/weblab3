package beans
import jakarta.enterprise.context.SessionScoped
import jakarta.faces.context.FacesContext
import jakarta.inject.Named
import java.io.Serializable
import java.lang.NumberFormatException

@Named("coordinates")
@SessionScoped
class CoordinatesBean: Serializable {

    fun applyHit(){

        try {

            val x = FacesContext.getCurrentInstance().externalContext.requestParameterMap["x"]?.toFloat()
            val y = FacesContext.getCurrentInstance().externalContext.requestParameterMap["y"]?.toFloat()
            val r = FacesContext.getCurrentInstance().externalContext.requestParameterMap["r"]?.toFloat()



        }catch (e: NumberFormatException){
            println("No args passed")
        }


    }

}