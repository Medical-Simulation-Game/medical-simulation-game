package com.treatment;

public class EmergencyTreatment extends Treatment {

    @Override
    public String getName() {
        return "응급 치료";
    }

    @Override
    public int getRecoveryAmount() {
        return 70;
    }

    @Override
    public int getSuccessRate() {
        return 40;
    }
}
