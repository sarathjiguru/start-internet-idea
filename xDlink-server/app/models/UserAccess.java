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
    public Long id;

    @Constraints.Required
    public String name;

    public static Model.Finder<Long, UserAccess> find = new Model.Finder<>(Long.class, UserAccess.class);
    public static Map<String,String> options(){
        LinkedHashMap<String,String> options = new LinkedHashMap<>();
        for(UserAccess c: UserAccess.find.orderBy("name").findList()) {
            options.put(c.id.toString(), c.name);
        }
        return options;
    }
}
