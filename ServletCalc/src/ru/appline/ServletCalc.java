package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.server.ExportException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/get")

public class ServletCalc extends HttpServlet {

    Gson gson =new GsonBuilder().setPrettyPrinting().create();

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
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

       Double a  = jobj.get("a").getAsDouble();
       Double  b  = jobj.get("b").getAsDouble();
       String operation = jobj.get("operation").getAsString();
       Double result;

       if (operation == "+")
       {result = a + b;}
       else if (operation == "-")
       {result = a - b;}
       else if (operation == "*")
       {result = a * b;}
       else if (operation == "/")
       {result = a / b;}
       else
       {result = 0.0;}

           response.setContentType("application/json;charset=UTF-8");
       PrintWriter pw = response.getWriter();

       pw.print(result);
   }


}
