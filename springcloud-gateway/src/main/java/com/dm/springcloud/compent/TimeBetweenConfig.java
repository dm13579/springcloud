package com.dm.springcloud.compent;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TimeBetweenConfig {

    private LocalTime startTime;

    private LocalTime endTime;

}
