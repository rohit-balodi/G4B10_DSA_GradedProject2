package com.skyscrapper;

public class Main {

    public static void main (String[] args) {

        final int FAILURE = 1;
        final int SUCCESS = 0;

        Service ss = new Service();

        int result;
        ss.getInformation();
        ss.assembleFloors();
    }
}