package com.treatment;

public class MedicineTreatment extends Treatment {

    @Override
    public String getName() {
        return "약물 치료";
    }

    @Override
    public int getRecoveryAmount() {
        return 30;
    }

    @Override
    public int getSuccessRate() {
        return 80;
    }
}
