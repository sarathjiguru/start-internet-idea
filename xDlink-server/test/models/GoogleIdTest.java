package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.*;

public class GoogleIdTest {
    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }


    @Test
    public void shouldInsertIntoTable() {
        GoogleId googleId = new GoogleId();
        String userId = "jiguru.parents";
        googleId.firstTimeGoogleRegistration(userId, "A dummy registration id");
        GoogleId insertedRecord = GoogleId.find.where().eq("id",userId).findUnique();
        assertNotNull(insertedRecord);
    }

}