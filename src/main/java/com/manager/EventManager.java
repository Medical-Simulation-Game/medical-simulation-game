package com.manager;

import com.patient.Patient;

import java.util.Random;

// 랜덤 이벤트 발생
public class EventManager {

    private Random random = new Random();

    public void occurEvent(Patient patient) {

        // 0, 1, 2 중 무작위 선택
        int event = random.nextInt(3);

        switch (event) {
            case 0:
                System.out.println("🚨 환자 상태 악화!");
                // hp 10 깎음
                patient.takeDamage(10);
                break;

            case 1:
                System.out.println("🚁 의료 지원 도착!");
                // hp 15 회복
                patient.heal(15);
                break;

            case 2:
                System.out.println("별다른 이벤트가 없습니다.");
                break;
        }

        System.out.println("현재 HP: " + patient.getHp());
    }
}