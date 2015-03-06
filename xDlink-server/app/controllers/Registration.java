package controllers;

import models.UserAccount;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.signup;

import static play.data.Form.form;

public class Registration extends Controller{

    static UserAccount userAccount = new UserAccount();
    private static Result okResult = ok("Your device is registered successfully");

    public static Result showRegister(){
        return ok(signup.render("register with your device name"));
    }
    private static void setResponseHeaders() {
        // Need to add the correct domain in here!!
        response().setHeader("Access-Control-Allow-Origin", "*");
        // Only allow POST
        response().setHeader("Access-Control-Allow-Methods", "POST");
        // Cache response for 5 minutes
        response().setHeader("Access-Control-Max-Age", "300");
        response().setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");         // Ensure this header is also allowed!
    }

    public static Result registerDevice(){
        setResponseHeaders();
        Result aResult;
        DynamicForm registerReq = form().bindFromRequest();
        String userName = registerReq.get("uname");
        String model = registerReq.get("model");

        userAccount.newSignUp(userName,model);

        aResult = Registration.okResult;
        System.out.println("userName: " +userName );
        System.out.println("model: " + model);

        return aResult;
    }

    public static Result googleRegId(String id){
        setResponseHeaders();
        System.out.println("google registration id: "+id);
        return Registration.okResult;
    }

}
