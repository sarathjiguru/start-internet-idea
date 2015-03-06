package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlUpdate;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class UserAccount extends Model{

    @Id
    public String id;

    @Constraints.Required
    public String device_model;

    public static Model.Finder<String, UserAccount> find = new Model.Finder<>(String.class, UserAccount.class);


    //Constructor used only for testing
    public UserAccount(String a, String b) {
        id = a;
        device_model = b;
    }

    public UserAccount() {

    }

    public void newSignUp(String userId, String deviceModel){
        SqlUpdate insertUpdate= Ebean.createSqlUpdate("INSERT INTO "+"user_account" +
                "(id, device_model) values (:id,:device_model)");
        insertUpdate.setParameter("id", userId);
        insertUpdate.setParameter("device_model", deviceModel);

        Ebean.execute(insertUpdate);
    }
    public static Map<String,String> options(){
        LinkedHashMap<String,String> options = new LinkedHashMap<>();
        for(UserAccount c: UserAccount.find.orderBy("device_model").findList()) {
            System.out.println(c.id+","+c.device_model);
            options.put(c.id, c.device_model);
        }
        return options;
    }

    public static String findUserById(String id) {
        System.out.println(id+ " from retreive data");
        ExpressionList<UserAccount> userAccountExpressionList = UserAccount.find.select("id,device_model").where().idEq(id);
        return userAccountExpressionList.findList().get(0).id+":"+userAccountExpressionList.findList().get(0).device_model;
    }
}



