package com.patient;

// 심장 질환 환자
public class CardiacPatient extends Patient {

    public CardiacPatient(String name) {
        super(name);
    }

    @Override
    public int getInitialHp() {
        return getRandomHp(10, 60);
    }

    @Override
    public String getPatientType() {
        return "심장 질환 환자";
    }


    // 심장 질환 환자 증상 목록
    private final String[] symptoms = {
            "갑자기 식은땀이 나고 얼굴이 창백해짐",
            "명치 부근이 체한 것처럼 답답함",
            "왼쪽 팔과 턱 주변에 묵직한 불편감",
            "조금만 움직여도 숨이 차고 피로함",
            "맥박이 불규칙하고 어지러움",
            "갑자기 메스꺼움과 구토 증상이 나타남",
            "호흡이 빨라지고 숨이 가쁨",
            "가슴이 답답하고 불안감을 느낌"
    };

    @Override
    public String[] getSymptoms() {
        return symptoms;
    }




}
