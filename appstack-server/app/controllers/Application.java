package controllers;

import models.UserAccount;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.receiveALink;

import static play.data.Form.form;


public class Application extends Controller {

    static Result okResult = ok("received the data");
    static Result badRequestResult = badRequest("too much big link[More than 10 KB]. Looks something fishy!. Try hashing it. Right now we dont have hashing app. But we will plan it very soon!. Apologies");
    public static Result index() {
        return render(UserAccount.options().get("1"));
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
        String link = linkRequest.get("link_at_client");
        String host = linkRequest.get("host");
        String guest = linkRequest.get("guest");
        aResult = okResult;
        System.out.println("link: " + link + " host:" + host + " guest:" + guest);
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
