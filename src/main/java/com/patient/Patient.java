package com.patient;


public abstract class Patient {

    protected String name;
    protected int hp;

    public Patient(String name) {
        this.name = name;
        this.hp = getInitialHp(); // 질병에 따라 hp 다름
    }


    // 자식 클래스마다 다르게 구현

    // 시작 HP는 자식이 결정
    public abstract int getInitialHp();

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
}
