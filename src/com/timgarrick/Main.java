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
        for (int i = 0; i < 1000; i++) {
            puidService.createPUID(surnames[i%2], firstnames[i%3]);
        }

/*        for (PUID puid: puidList.getPuidList())
        {
            System.out.println(puid.toString());

        }*/


        System.out.println(puidService.findPUID("SmithA126") + "\n");
        puidService.amendPUID(puidService.findPUID("SmithA126"),
                "Test", "Test", false);
        System.out.println(puidService.findPUID("testt101") + "\n");


    }
}
