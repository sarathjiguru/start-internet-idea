package models;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.Insert;

public class CassandraSession {
    private static final Session session = Cluster.builder().addContactPoint("127.0.0.1").build().connect();
    public static Session getSession(){
        return session;
    }

    public static void insert(Insert values) {
        session.execute(values);
    }

    public static ResultSet execute(Statement statement) {
        return session.execute(statement);
    }
}
