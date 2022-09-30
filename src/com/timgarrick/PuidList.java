package com.timgarrick;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
