package nikos.com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
@RestController
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping(value = "/hello")
    public void getName(HttpServletRequest request, HttpServletResponse response, @RequestParam String name) throws IOException {
     response.setContentType("text/html");
     var writer = response.getWriter();
     writer.println("<html> <head> <title> Name </title> </head>");
     writer.println("<body> <h1 style = \" color: blue \" > hello" + name + "!" +" <h1/> <body/>");

     writer.close();
    }

    /*@GetMapping(value = "/seunome")
    public void getName(HttpServletRequest request, HttpServletResponse response) throws IOException {
     response.setContentType("text/html");
     var writer  = response.getWriter();
        writer.println("");
        writer.println("");
        writer.println("");
    }*/

    @GetMapping(value = "/endereço")
    public String endereco(@RequestParam(value = "ender", defaultValue = "NULL") String ender){
        return String.format("Seu Endereço: %s", ender = "AV.Jundiaí LOTE 26/Loja 04;"); 
    }
}
