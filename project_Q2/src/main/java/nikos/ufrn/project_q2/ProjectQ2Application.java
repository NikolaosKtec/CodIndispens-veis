package nikos.ufrn.project_q2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
@Controller
public class ProjectQ2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjectQ2Application.class, args);
    }

    @GetMapping(value = "/forms")
    public void form(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        var writer = response.getWriter();
        writer.println(" <body> <form action = \"/responce\" target = \"_blank\" method = \"get \"> ");
        writer.println(" <label for = \"name\"> Nome: </label> <input name = \"name\" type = \"text\" required/>");
        writer.println(" <label for = \"email\"> Email: </label> <input name = \"email\" type = \"text\" required/>");
        writer.println(" <label for = \"senha\"> Senha: </label> <input name = \"senha\" type = \"password\" required/>");
        writer.println(" <label for = \"senha2\"> Confirmar senha: </label>");
        writer.println(" <input name = \"senha2\" type = \"password\" required>");
        writer.println("<div> <button   type = \"submit\"> enviar </button> </div> </form> </body>");
        writer.close();
        //response.sendRedirect("/responce");
    }

    @GetMapping(value="/responce")
    public void response(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        var name = request.getParameter("name");
        var email = request.getParameter("email");
        var senha = request.getParameter("senha");
        var senha2 = request.getParameter("senha2");
        var writer = response.getWriter();

       // writer.println("<div>"+name+"</div>");

        Pattern pt = Pattern.compile("^(?=..*[0-9])"+".{5,20}$");
        Matcher match = pt.matcher(senha);


        if(match.matches() & senha.equals(senha2)){
            writer.println("<p> cadastro realizado com sussesso!</p>");
        }else writer.println("<h1>senha fraca! são diferentes!</h1>");

        writer.close();


    }


}
