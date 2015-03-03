package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class GoogleId extends Model {
    private static final String REGISTRATION_TABLE = "GOOGLE_ID";
    @Id
    public String id;

    @Constraints.Required
    public String registration_id;

    public static Model.Finder<String, GoogleId> find = new Model.Finder<>(String.class, GoogleId.class);
    public void insertRegisterId(String userId, String googleId){

        String insertQuery = "INSERT INTO "+ REGISTRATION_TABLE +
                "(id, registration_id) values (:id,:google_id)";

        SqlUpdate insertUpdate= Ebean.createSqlUpdate(insertQuery);
        insertUpdate.setParameter("id", userId);
        insertUpdate.setParameter("google_id", googleId);

        Ebean.execute(insertUpdate);

    }

}
