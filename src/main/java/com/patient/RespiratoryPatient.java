package com.patient;

// 호흡기 환자
public class RespiratoryPatient extends Patient {

    public RespiratoryPatient(String name) {
        super(name);
    }

    @Override
    public int getInitialHp() {
        return 60;
    }

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