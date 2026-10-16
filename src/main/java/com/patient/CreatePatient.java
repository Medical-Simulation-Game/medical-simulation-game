package com.patient;

import java.util.Random;

public class CreatePatient {
    private final Random random = new Random();

    public Patient createRandomPatient(int patientNumber) {
        int type = random.nextInt(3);
        String name = "환자 " + patientNumber;

        switch (type) {
            case 0:
                return new CardiacPatient(name);
            case 1:
                return new TraumaPatient(name);
            default:
                return new RespiratoryPatient(name);
        }
    }
}
