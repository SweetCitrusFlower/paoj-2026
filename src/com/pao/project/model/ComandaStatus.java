package com.pao.project.model;

import com.pao.project.exception.StareaComenziiEsteTerminalaException;

public enum ComandaStatus {
    PLASATA,
    IN_PREGATIRE,
    PREGATITA,
    RIDICATA,
    LIVRATA,
    ANULATA;

    public static ComandaStatus getComandaStatusString(String str){
        switch(str.toUpperCase()){
            case "PLASATA" -> { return PLASATA; }
            case "IN_PREGATIRE" -> { return IN_PREGATIRE; }
            case "PREGATITA" -> { return PREGATITA; }
            case "RIDICATA" -> { return RIDICATA; }
            case "LIVRATA" -> { return LIVRATA; }
            default -> { return ANULATA; }
        }
    }

    public ComandaStatus next() {
        return switch (this) {
            case PLASATA -> IN_PREGATIRE;
            case IN_PREGATIRE -> PREGATITA;
            case PREGATITA -> RIDICATA;
            case RIDICATA -> LIVRATA;
            case LIVRATA, ANULATA -> throw new StareaComenziiEsteTerminalaException();
        };
    }

    public ComandaStatus anulare() {
        return switch (this) {
            case LIVRATA, ANULATA -> throw new StareaComenziiEsteTerminalaException();
            default -> ANULATA;
        };
    }
}