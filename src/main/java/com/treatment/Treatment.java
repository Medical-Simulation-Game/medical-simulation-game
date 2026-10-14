package com.treatment;

import java.util.Random;

public abstract class Treatment {

    private String treatmentName; // 치료 이름
    private int recoveryAmount; // 회복량
    private int successRate; // 성공률

    private Random random = new Random();

    public Treatment(String treatmentName, int recoveryAmount, int successRate) {
        this.treatmentName = treatmentName;
        this.recoveryAmount = recoveryAmount;
        this.successRate = successRate;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public int getRecoveryAmount() {
        return recoveryAmount;
    }

    public int getSuccessRate() {
        return successRate;
    }
}
