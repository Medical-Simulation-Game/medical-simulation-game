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

        // TODO: patient 메소드를 통해 환자 생존 여부 판단

        if (random.nextInt(100) < getSuccessRate()) {
            // TODO: patient에 구현된 메소드를 통해 회복량 전달

            System.out.println("치료 성공!");
            System.out.println("회복량: " + getRecoveryAmount());
            System.out.println("현재 HP: "); // TODO: patient에 구현된 메소드로 현재 HP 가져오기

            return true;
        } else {
            // TODO: patient에 구현된 메소드를 통해 데미지 15 전달

            System.out.println("치료 실패!");
            System.out.println("환자가 15의 피해를 입었습니다.");
            System.out.println("현재 HP: "); // TODO: patient에 구현된 메소드로 현재 HP 가져오기

            return false;
        }
    }
}
