package com.timgarrick;

public class FieldIncrementData {
    private static FieldIncrementData instance = null;
    private long puid = 2000000000;
    private int puidDigits = 100;

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

    public String getNewPuidDigits(StringBuilder s) {
        int count = puidDigits;
        StringBuilder compare = new StringBuilder();


        for (PUID puid : PuidList.getInstance().getPuidList()) {

                compare.append(puid.getSurname().toLowerCase());
                compare.append(puid.getFirstname().toLowerCase().charAt(0));

                if (compare.toString().equals(s.toString())) {
                    count++;
                }

                compare.setLength(0);

            //System.out.println("returned count " + s + "" + count);
        }

        return s + Integer.toString(count);

    }
}
