package controllers;

import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.receiveALink;

import static play.data.Form.form;

public class Application extends Controller {

    private static String link;
    private static String host;
    private static String guest;

    static Result okResult = ok("received the data");
    Result badRequestResult = badRequest("too much big link[More than 10 KB]. Looks something fishy!. Try hashing it. Right now we dont have hashing app. But we will plan it very soon!. Apologies");
    public static Result index() {
        return ok(receiveALink.render("Your new application is ready."));
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

}
