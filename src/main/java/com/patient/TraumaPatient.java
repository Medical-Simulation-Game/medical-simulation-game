package com.patient;

// 외상 환자
public class TraumaPatient extends Patient {

    public TraumaPatient(String name) {
        super(name);
    }

    @Override
    public int getInitialHp() {
        return 85;
    }

    @Override
    public String getPatientType() {
        return "외상 환자";
    }
}

