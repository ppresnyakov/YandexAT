package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Model;
import ru.appline.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.server.ExportException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/put")

public class ServletPut extends HttpServlet {

    private AtomicInteger counter = new AtomicInteger(5);
    Model model = Model.getInstance();
    Gson gson =new GsonBuilder().setPrettyPrinting().create();

   protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
       StringBuffer jb = new StringBuffer();
       String line;
       try {
           BufferedReader reader  = request.getReader();
           while ((line = reader.readLine()) != null){
               jb.append(line);
           }
       } catch (ExportException e){
           System.out.println("Error!");
       }

       JsonObject jobj = gson.fromJson(String.valueOf(jb), JsonObject.class);
       request.setCharacterEncoding("UTF-8");

       String  name  = jobj.get("name").getAsString();
       String  surname  = jobj.get("surname").getAsString();
       Double  salary  = jobj.get("salary").getAsDouble();
       Integer id = jobj.get("id").getAsInt();

       User user = new User(name, surname, salary);
       model.put(id, user);

       response.setContentType("application/json;charset=UTF-8");
       PrintWriter pw = response.getWriter();

       pw.print(gson.toJson(model.getFromList()));
   }


}
