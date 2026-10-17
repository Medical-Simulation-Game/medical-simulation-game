package com.patient;


import java.util.Random;

public abstract class Patient {

    protected String name;
    protected int hp;

    public Patient(String name) {
        this.name = name;
        this.hp = getInitialHp(); // 질병에 따라 hp 다름
    }


    // 자식 클래스에서 환자 종류에 따른 초기 HP 범위를 지정
    public abstract int getInitialHp();

    // 전달받은 범위 내에서 랜덤한 초기 HP 생성
    protected int getRandomHp(int min, int max){
        Random random = new Random();
        return random.nextInt(max-min+1) + min;
    };

    // 환자종류 알려주는 메서드
    public abstract String getPatientType();

    // HP 회복 (전달받은 amount만큼 회복됨)
    public void heal(int amount) {
        hp = Math.min(100, hp + amount); // hp 최대 100 넘지 못함
    }

    // HP 감소 (전달받은 amount만큼 깎임)
    public void takeDamage(int amount) {
        hp = Math.max(0, hp - amount); // hp 최소 0 보다 작아질 수 없음
    }

    // 현재 HP 반환
    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    // 환자 생존 여부
    public boolean isAlive() {
        return hp > 0;
    }


    // 자식 클래스가 각자의 증상 목록을 반환
    public abstract String[] getSymptoms();

    // 증상 4개 랜덤 추출
    public String[] getRandomSymptoms() {

        final int SYMPTOM_NUM = 2;

        String[] symptoms = getSymptoms();
        String[] result = new String[SYMPTOM_NUM];

        Random random = new Random();
        boolean[] selected = new boolean[symptoms.length];



        for (int i = 0; i < SYMPTOM_NUM; i++) {
            int index;

            do {
                index = random.nextInt(symptoms.length);
            } while (selected[index]);

            selected[index] = true;
            result[i] = symptoms[index];
        }

        return result;
    }


}
