package me.yaman.can.sample.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import javax.servlet.http.HttpServletResponse

@RestController
class MainController{

    @Value("#{servletContext.contextPath}")
    private val servletContextPath: String? = null

    @GetMapping("/")
    fun swagger(response: HttpServletResponse) = response.sendRedirect("$servletContextPath/swagger-ui.html")

    @GetMapping("/greeting")
    fun greeding(@RequestParam(defaultValue = "Someone") name: String):Map<String,Any>{
        val greeding = mapOf("name" to name,"message" to "Hello $name!")
        return greeding
    }
}