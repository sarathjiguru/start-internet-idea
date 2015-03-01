package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class UserAccess extends Model{
    @Id
    public String id;

    @Constraints.Required
    public String device_model;

    public static Model.Finder<String, UserAccess> find = new Model.Finder<>(String.class, UserAccess.class);
    public static Map<String,String> options(){
        LinkedHashMap<String,String> options = new LinkedHashMap<>();
        for(UserAccess c: UserAccess.find.orderBy("device_model").findList()) {
            options.put(c.id, c.device_model);
        }
        return options;
    }
}
