package com.pao.laboratory06.exercise3;

public interface PlataOnlineSMS extends PlataOnline{
    default boolean trimiteSMS(String mesaj){
        throw new ClassCastException("Acest tip de clasa nu are acces la SMS"); 
    };
}
