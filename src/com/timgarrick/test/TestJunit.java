package com.timgarrick.test;
import com.timgarrick.main.PUID;
import com.timgarrick.main.PUIDService;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {

    @Test
    public void createUser() {
        PUIDService puidService = PUIDService.getInstance();
        PUID testUser = puidService.createPUID("Garrick", "Tim");
    }

}
