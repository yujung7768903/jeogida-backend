package com.godofparking.jeogidabackend.exception;

public class DuplicateParkingLotException extends RuntimeException{

    public DuplicateParkingLotException() {

    }

    public DuplicateParkingLotException(String message) {
        super(message);
    }

}
