package com.treatment;

public class InjectionTreatment extends Treatment {

    @Override
    public String getName() {
        return "주사 치료";
    }

    @Override
    public int getRecoveryAmount() {
        return 50;
    }

    @Override
    public int getSuccessRate() {
        return 60;
    }
}
