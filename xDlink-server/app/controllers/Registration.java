package controllers;

import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.signup;

import static play.data.Form.form;

public class Registration extends Controller{

    public static Result showRegister(){
        return ok(signup.render("register with your name"));
    }

    public static Result register(){
        System.out.println("in register");
        // Need to add the correct domain in here!!
        response().setHeader("Access-Control-Allow-Origin", "*");
        // Only allow POST
        response().setHeader("Access-Control-Allow-Methods", "POST");
        // Cache response for 5 minutes
        response().setHeader("Access-Control-Max-Age", "300");
        response().setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");         // Ensure this header is also allowed!


        Result aResult;
        System.out.println(request().body());
        DynamicForm registerReq = form().bindFromRequest();
        String userName = registerReq.get("uname");
        String model = registerReq.get("model");
        aResult = Application.okResult;
        System.out.println("userName: " +userName );
        System.out.println("model: " + model);

        return aResult;
    }

}
