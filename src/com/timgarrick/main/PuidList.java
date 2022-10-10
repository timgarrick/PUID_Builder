package com.timgarrick.main;

import java.util.ArrayList;

public class PuidList {
    private ArrayList<PUID> puidList = new ArrayList<>();
    private static PuidList instance = null;

    private PuidList() {
    }

    public static PuidList getInstance() {
        if (instance == null) {
            instance = new PuidList();
        }

        return instance;
    }

    public PUID puidListAddUser(PUID puid){
        puidList.add(puid);
        return puid;
    }

    public ArrayList<PUID> getPuidList() {
        return puidList;
    }

    public void setPuidList(ArrayList<PUID> puidList) {
        this.puidList = puidList;
    }
}
