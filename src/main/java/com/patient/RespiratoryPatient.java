package com.patient;

// 호흡기 환자
public class RespiratoryPatient extends Patient {

    public RespiratoryPatient(String name) {
        super(name);
    }

    @Override
    public int getInitialHp() {
        return getRandomHp(50, 70);
    }
    // 질병마다 위험도가 다르니 초기 HP 범위를 다르게 설정하고, 환자마다 랜덤 HP 부여

    @Override
    public String getPatientType() {
        return "호흡기 환자";
    }

    // 호흡기 환자 증상 목록
    private final String[] symptoms = {
            "숨을 들이마실 때 가슴 한쪽에 통증이 발생함",
            "호흡이 빨라지고 말을 길게 이어가기 어려움",
            "입술 주변이 푸르스름하게 변함",
            "가슴이 답답하지만 뚜렷한 통증은 없음",
            "갑자기 불안해하며 식은땀이 남",
            "한쪽 폐에서 호흡음이 약하게 들림",
            "맥박이 빨라지고 어지러움을 호소함",
            "숨을 내쉴 때 쌕쌕거리는 소리가 들림"
    };

    @Override
    public String[] getSymptoms() {
        return symptoms;
    }


}