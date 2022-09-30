package com.timgarrick;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PUIDService {
    private static PUIDService instance = null;

    private PUIDService(){

    }

    public void initialise() {
        PuidList.getInstance();
    }

    //singleton class, dont need synchronized
    public static PUIDService getInstance() {
        if (instance == null) {
            instance = new PUIDService();
        }

        return instance;
    }

    //create a new PUID
    public boolean createPUID(String surname, String firstname) {
        PuidList.getInstance().puidListAddUser(new PUID(surname, firstname));
        return true;
    }

    //delete a PUID by object
    public boolean deletePUID(PUID puid) {
        try {
            puid.setObsolete(true);
            return true;
        } catch(Exception e) {
            System.out.println("Error: " + e + " when trying to delete PUID");
            return false;
        }
    }

    //delete puid by ID
    public boolean deletePUID(Long id) {
        try {
            findPUID(id).setObsolete(true);
            return true;
        } catch(Exception e) {
            System.out.println("Error: " + e + " when trying to delete PUID");
            return false;
        }
    }

    //delete puid by puidname
    public boolean deletePUID(String puidname) {
        try {
            findPUID(puidname).setObsolete(true);
            return true;
        } catch(Exception e) {
            System.out.println("Error: " + e + " when trying to delete PUID");
            return false;
        }
    }

    //need to be able to amend firstname, surname and obsolete
    public PUID amendPUID(PUID puid, String surname, String firstname, Boolean obsolete) {
        puid.setSurname(surname);
        puid.setFirstname(firstname);
        puid.setObsolete(obsolete);
        puid.setPuidname(puid.generatePuidName(surname, firstname));
        puid.setModifiedDate(new Date());
        System.out.println("Puid " + puid + " has been updated. Surname: " + puid.getSurname() +
                ", Firstname: " + puid.getFirstname());
        return puid;
    }

    public PUID findPUID(Long id) {
        for (PUID puid : PuidList.getInstance().getPuidList()) {
            if(puid.getPuid() == id) {
                return puid;
            }
        }
        System.out.println("Puid searched by ID returned no results");
        return null;
    }

    public PUID findPUID(String puidname) {
        for (PUID puid : PuidList.getInstance().getPuidList()) {
            if(puid.getPuidname().equals(puidname.toLowerCase())) {
                return puid;
            }
        }
        System.out.println("PUID seached by name returned no results");
        return null;
    }

    public ArrayList<PUID> listPUIDs() {
        return PuidList.getInstance().getPuidList();
    }

}
