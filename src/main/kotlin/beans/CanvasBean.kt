package beans

import jakarta.enterprise.context.RequestScoped
import jakarta.faces.context.FacesContext
import jakarta.inject.Named
import java.io.Serializable

@Named
@RequestScoped
class CanvasBean: Serializable {

    fun applyHit(){

        val x = FacesContext.getCurrentInstance().externalContext.requestParameterMap["x"]
        val y = FacesContext.getCurrentInstance().externalContext.requestParameterMap["y"]
        val r = FacesContext.getCurrentInstance().externalContext.requestParameterMap["r"]

        println("x: $x")
        println("y: $y")
        println("r: $r")

    }

}