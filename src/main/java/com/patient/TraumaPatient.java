package com.patient;

// 외상 환자
public class TraumaPatient extends Patient {

    public TraumaPatient(String name) {
        super(name);
    }

    @Override
    public int getInitialHp() {
        return getRandomHp(20, 80);
    }
    // 질병마다 위험도가 다르니 초기 HP 범위를 다르게 설정하고, 환자마다 랜덤 HP 부여

    @Override
    public String getPatientType() {
        return "외상 환자";
    }

    // 외상 환자 증상 목록
    private final String[] symptoms = {
            "피부가 차갑고 축축하며 얼굴이 창백함",
            "맥박이 빨라지고 심한 갈증을 느낌",
            "겉으로 보이는 출혈은 없지만 복부가 팽팽함",
            "어지러움을 호소하며 점점 졸려 함",
            "손끝이 차가워지고 혈압이 떨어짐",
            "왼쪽 어깨에 통증이 있지만 직접적인 상처는 없음",
            "호흡이 빨라지고 식은땀이 남",
            "복부에 묵직한 통증이 있고 움직이면 심해짐"
    };

    @Override
    public String[] getSymptoms() {
        return symptoms;
    }


}

