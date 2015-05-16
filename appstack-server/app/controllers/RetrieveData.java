package controllers;

import models.GoogleId;
import models.UserAccount;
import play.mvc.Controller;
import play.mvc.Result;

public class RetrieveData extends Controller {

    public static Result userAccountFor(String id){
        return ok("User Account"+UserAccount.findUserById(id));
    }

    public static Result googleIdFor(String id){
        return ok("User Registration"+ GoogleId.findUserById(id));
    }
}
