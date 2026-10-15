package com.patient;

// 호흡기 환자
public class RespiratoryPatient extends Patient {

    public RespiratoryPatient(String name) {
        super(name);
    }

    @Override
    public int getInitialHp() {
        return 60;
    }

    @Override
    public String getPatientType() {
        return "호흡기 환자";
    }
}