package com.timgarrick;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FieldIncrementData {
    private static FieldIncrementData instance = null;
    private long puid = 2000000000;
    private final int puidDigits = 100;

    private FieldIncrementData() {
    }

    //create singleton object
    public static FieldIncrementData getInstance() {
        if (instance == null) {
            instance = new FieldIncrementData();
        }

        return instance;
    }

    public long getPuid() {
        return puid;
    }

    public int getPuidDigits(){
        return this.puidDigits;
    }

    public long getNewPuid() {
        this.puid++;
        return puid;
    }

    public int getNewPuidDigits(String s) {
        ArrayList<PUID> reversedList = new ArrayList<PUID>(PuidList.getInstance().getPuidList());

        Collections.reverse(reversedList);

        for (PUID puid : reversedList) {
            if(puid.getPartialPuidname().equals(s))
            {
                int lastThreeDigits = Integer.parseInt(puid.getPuidname().substring(puid.getPuidname().length()-3));
                if(lastThreeDigits < 999) {
                    return lastThreeDigits + 1;

                } else {

                    return lastThreeDigits;
                }
            }
        }

        return puidDigits;

    }
}