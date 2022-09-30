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
    public PUID createPUID(String surname, String firstname) {

        return PuidList.getInstance().puidListAddUser(new PUID(surname, firstname));

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
        puid.setPuidname(puid.generatePuidName(puid.getPartialPuidname()));
        puid.setModifiedDate(new Date());
        return puid;
    }

    public PUID amendPUID(String puidname, String surname, String firstname, Boolean obsolete) {
        return amendPUID(findPUID(puidname), surname, firstname, obsolete);
    }

    public PUID findPUID(long id) {
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

    public void displayPUID(String puidname) {
        displayPUID(findPUID(puidname));
    }

    public void displayPUID(long id) {
        displayPUID(findPUID(id));
    }

    public void displayPUID(PUID puid) {
        System.out.println("PUID: " + puid.getPuid());
        System.out.println("PUIDname: " + puid.getPuidname());
        System.out.println("Name: " + puid.getFirstname() + " " + puid.getSurname());
        System.out.println("Obsolete: " + puid.getObsolete().toString() + "\n");
    }


    public void displayAllPUIDS() {
        for (PUID puid: PuidList.getInstance().getPuidList()
             ) {
            displayPUID(puid);
        }
    }

    public void displayAllPUIDS(int limit) {

        for (int i = 0; i < limit; i++) {
            displayPUID(PuidList.getInstance().getPuidList().get(i));

        }
    }
}
