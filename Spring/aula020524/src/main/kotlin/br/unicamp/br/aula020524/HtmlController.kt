
package br.unicamp.cotuca.aula020524

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set 
import org.springframework.web.bind.annotation.GetMapping


@Controller
class HtmlController{

    @GetMapping("/")
    fun aula0205(model: Model): String {
        model["title"] =  "Aula 0205"
        return "aula0205"
    }
}