package com.intuit.coding_interview.petclinic;

import java.time.DayOfWeek;
import java.time.LocalTime;

public enum BusinessHours {

    START( LocalTime.of(8,0)),
    END( LocalTime.of(17,0));

    private LocalTime  time;

    public LocalTime getTime(){
        return this.time;
    }
    BusinessHours( LocalTime time ){
        this.time = time;
    }
}

