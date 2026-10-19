package com.treatment;

import com.patient.Patient;

import java.util.Random;

public abstract class Treatment {

    private static final Random random = new Random();

    public abstract String getName();
    public abstract int getRecoveryAmount();
    public abstract int getSuccessRate();

    public boolean treat(Patient patient) {
        if (!patient.isAlive()) {
            return false;
        }

        if (random.nextInt(100) < getSuccessRate()) {
            patient.heal(getRecoveryAmount());  // 성공 시 HP 회복
            return true;
        } else {
            patient.takeDamage(15);
            return false;
        }
    }
}
