package controllers;

import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import static play.data.Form.form;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("GET render with data."));
    }

    public static Result home(String data) {
        System.out.println(data);
        DynamicForm dynamicForm = form().bindFromRequest();
        System.out.println(dynamicForm.toString());
        return ok(index.render(dynamicForm.toString()));
    }
}
