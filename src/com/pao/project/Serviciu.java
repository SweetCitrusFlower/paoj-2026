package com.pao.project;

public class Serviciu {
    private static class InstanceHolder {
        public static Serviciu instance = new Serviciu();
    }

    private Serviciu(){}

    public static Serviciu getInstance() { 
        return InstanceHolder.instance;
    }

}
