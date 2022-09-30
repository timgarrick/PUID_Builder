package com.timgarrick;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<PUID> createdUsers = new ArrayList<>();
        PUIDService puidService = PUIDService.getInstance();
        PuidList puidList = PuidList.getInstance();
        FieldIncrementData fieldIncrementData = FieldIncrementData.getInstance();
        String[] firstnames = {"Alex", "Alan", "Alicia", "Amy"};
        String[] surnames = {"Jones", "Smith"};

        //create a list of users to test
        for (int i = 0; i < 2000; i++) {
            puidService.createPUID(surnames[i%2], firstnames[i%3]);
        }

        //CRUD operations
        //Create new user
        PUID testUser = puidService.createPUID("Garrick", "Tim");
        PUID testUser2 = puidService.createPUID("Garrick", "Tim");
        puidService.createPUID("Garrick", "TIm");

        //retreive user
        puidService.displayPUID(testUser);
        puidService.displayPUID(testUser2);
        puidService.displayPUID(2000000995);
        puidService.displayPUID("garrickt102");

        //update user
        puidService.amendPUID(testUser,"Garck", "Tom", false);
        puidService.amendPUID(testUser2,"garik", "Tom", false);
        puidService.displayPUID(testUser);
        puidService.displayPUID(testUser2);

        //delete user
        puidService.deletePUID(testUser);
        puidService.displayPUID(testUser);

        //List all PUIDs
        //puidService.displayAllPUIDS();

        //List first 20 puids
        //puidService.displayAllPUIDS(20);


    }
}
