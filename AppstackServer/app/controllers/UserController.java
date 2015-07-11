package controllers;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.querybuilder.Select;
import models.CassandraSession;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;

import static com.datastax.driver.core.querybuilder.QueryBuilder.*;

public class UserController extends Controller {
    static final String[] KEYS = {"userId", "first_name", "last_name", "city"};
    static final String KEY_SPACE = "kunderaExamples";
    static final String TABLE = "user";

    public static Result persist() {
        ArrayList<String> getvalues = new ArrayList<>();

        getvalues.add("00011");
        getvalues.add("sarath");
        getvalues.add("C Bhargav");
        getvalues.add("Hill Colony");

        String[] values = new String[getvalues.size()];
        getvalues.toArray(values);

        CassandraSession.insert(insertInto(KEY_SPACE, TABLE).values(KEYS, values));
        return ok("User 00011 record inserted");
    }

    public static Result find() {
        Select findUser = select().all().from(KEY_SPACE, TABLE).where(eq("userId", "00011")).limit(1);
        ResultSet userRow = CassandraSession.execute(findUser);
        return ok("Found User in database with the following details:" + printUser(userRow));
    }

    public static Result edit() {
        ResultSet updatedRow = CassandraSession.execute(update(KEY_SPACE, TABLE)
                .with(set("city", "Nagarjuna Sagar"))
                .where(eq("userId", "00011")));

        return ok("Record updated:" + printUser(updatedRow));
    }

    public static Result erase() {
        ResultSet deletedRow = CassandraSession.execute(delete().from(KEY_SPACE, TABLE)
                .where(eq("userId", "00011")));
        return ok("Record deleted:" + printUser(deletedRow));
    }

    private static String printUser(ResultSet userRow) {
        if (userRow == null)
            return "Record not found";
        Row firstRow = userRow.one();
        return "\n--------------------------------------------------" + "\nuserId:"
                + firstRow.getString("userId")
                + "\nfirstName:"
                + firstRow.getString("first_name")
                + "\nlastName:" + firstRow.getString("last_name")
                + "\ncity:" + firstRow.getString("city");
    }
}