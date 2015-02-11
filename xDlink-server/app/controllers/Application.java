package controllers;

import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.receiveALink;
import views.html.signup;

import static play.data.Form.form;


public class Application extends Controller {

    private static String link;
    private static String host;
    private static String guest;

    static Result okResult = ok("received the data");
    static Result badRequestResult = badRequest("too much big link[More than 10 KB]. Looks something fishy!. Try hashing it. Right now we dont have hashing app. But we will plan it very soon!. Apologies");
    public static Result index() {
        return render("Your new application is ready.");
    }

    private static Status render(String msg) {
        return ok(index.render(msg));
    }

    public static Result showLinkPage(){
        return ok(receiveALink.render("show link"));
    }
    //find a way to measure link size
    public static Result receiveALink() {
        Result aResult;
        System.out.println(request().body());
        DynamicForm linkRequest = form().bindFromRequest();
        link = linkRequest.get("link_at_client");
        host = linkRequest.get("host");
        guest = linkRequest.get("guest");
        aResult = okResult;
        System.out.println("link: " + link + " host:" + host + " guest:" + guest);
        return aResult;
    }

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
        aResult = okResult;
        System.out.println("userName: " +userName );
        System.out.println("model: " + model);

        return aResult;
    }

    public static Result preFlight(String all){
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST,OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");
        return ok();
    }


}
