package com.patient;

// 심장 질환 환자
public class CardiacPatient extends Patient {

    public CardiacPatient(String name) {
        super(name);
    }

    @Override
    public int getInitialHp() {
        return 70;
    }

    @Override
    public String getPatientType() {
        return "심장 질환 환자";
    }
}
