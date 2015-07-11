package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by sarath on 6/6/15.
 */
public class CSRF extends Controller {

    public static Result preFlight(String all){
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST,OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");
        return ok();
    }
}
