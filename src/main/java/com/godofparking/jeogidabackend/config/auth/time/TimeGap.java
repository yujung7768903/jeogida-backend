package com.godofparking.jeogidabackend.config.auth.time;

import lombok.Data;

@Data
public class TimeGap {
    private Integer hour;
    private Integer minute;

    public TimeGap() {
        hour = 0;
        minute = 0;
    }
}
