package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlUpdate;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class GoogleId extends Model {
    @Id
    public String id;

    @Constraints.Required
    public String registration_id;

    public static Model.Finder<String, GoogleId> find = new Model.Finder<>(String.class, GoogleId.class);

    public void firstTimeGoogleRegistration(String userId, String googleId){
        SqlUpdate insertUpdate= Ebean.createSqlUpdate("INSERT INTO "+ "google_id" +
                "(id, registration_id) values (:id,:google_id)");
        insertUpdate.setParameter("id", userId);
        insertUpdate.setParameter("google_id", googleId);

        Ebean.execute(insertUpdate);

    }

    public static String findUserById(String id) {

        ExpressionList<GoogleId> expressionList = GoogleId.find.select("id,registration_id").where().idEq(id);
        return expressionList.findList().get(0).id+":"+expressionList.findList().get(0).registration_id;
    }
}
