package com.treatment;

import com.patient.Patient;

import java.util.Random;

public abstract class Treatment {

    private static final Random random = new Random();

    public abstract String getName();
    public abstract int getRecoveryAmount();
    public abstract int getSuccessRate();

    public boolean treat(Patient patient) {
        System.out.println("\n[" + getName() + "] 시도!");

        if (!patient.isAlive()) {
            System.out.println("환자가 생존해 있지 않습니다.");
            return false;
        }

        if (random.nextInt(100) < getSuccessRate()) {
            patient.heal(getRecoveryAmount());  // 해당 치료의 회복량만큼 HP 회복

            System.out.println("치료 성공!");
            System.out.println("회복량: " + getRecoveryAmount());
            System.out.println("현재 HP: " + patient.getHp());

            return true;
        } else {
            patient.takeDamage(15);  // 15만큼 HP 감소

            System.out.println("치료 실패!");
            System.out.println("환자가 15의 피해를 입었습니다.");
            System.out.println("현재 HP: " + patient.getHp());

            return false;
        }
    }
}
