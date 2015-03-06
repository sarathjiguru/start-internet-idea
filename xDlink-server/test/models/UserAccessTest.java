package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.*;

public class UserAccessTest {
    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }


    @Test
    public void createAndRetrieveUser() {
        new UserAccount("jiguru.parents", "motoe").save();
        UserAccount myFirstDevice = UserAccount.find.where().eq("id", "jiguru.parents").findUnique();
        assertNotNull(myFirstDevice);
        assertEquals("motoe", myFirstDevice.device_model);
    }


}

