package com.timgarrick;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<PUID> puidList = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            puidList.add(new PUID("Garrick", "Tim"));
        }

        for (PUID puid: puidList) {

            System.out.println(puid.getPuidname());

        }

    }
}
