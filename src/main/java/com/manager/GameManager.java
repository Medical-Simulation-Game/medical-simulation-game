package com.manager;

import com.patient.*;
import com.treatment.EmergencyTreatment;
import com.treatment.InjectionTreatment;
import com.treatment.MedicineTreatment;
import com.treatment.Treatment;

import java.util.Random;
import java.util.Scanner;

public class GameManager {

     private Scanner sc = new Scanner(System.in);
     private Random random = new Random();
     // private EventManager eventManager = new EventManager();
    private CreatePatient createPatient = new CreatePatient();

     // 치료에 성공한 환자 수 저장
     private int successCount = 0;

     // 총 환자 수 5명
     private final int TOTAL_PATIENTS = 5;

     // 턴 수 5회
     private final int MAX_COUNT = 5;
     // 진단 횟수
     private final int MAX_DIAGNOSIS_COUNT = 2;

     public void startGame() {
         System.out.println("응급24시 게임을 시작합니다!");
         System.out.println("총 5명의 환자를 치료하세요!");
         System.out.println("각 환자마다 5회 안에 HP 100가 되어야 치료에 성공합니다");

         for(int i = 1; i <= TOTAL_PATIENTS; i++) {
             System.out.println("======= " + i + "번째 환자 =======");

             Patient patient = createPatient.createRandomPatient(i);

             // 질병 진단
             boolean isDiagnosed = diagnosePatient(patient);

             // 진단 성공 및 생존 시 치료
             boolean isSuccess = false;
             if (isDiagnosed && patient.isAlive()) {
                 isSuccess = treatPatient(patient);
             }

             if(isSuccess) {
                 successCount++;
                 System.out.println(i + "번째 환자 치료 최종 성공!");
             } else {
                 System.out.println(i + "번째 환자 치료 최종 실패..");
             }

             System.out.println("치료 성공률: " + successCount + "/" + TOTAL_PATIENTS);
         }
         showFinalRank();
     }

     private boolean diagnosePatient(Patient patient) {
         System.out.println("\n[" + patient.getName() + " 진단 단계]");
         System.out.println("환자 초기 HP: " + patient.getHp());

         // 환자 증상 불러오기
         String[] symptoms = patient.getRandomSymptoms();

         for (String symptom : symptoms) {
             System.out.println("- " + symptom);
         }


         int tryCount = 0;
         while(tryCount < MAX_DIAGNOSIS_COUNT && patient.isAlive()) {
             tryCount++;

             System.out.println("\n--- 질병 추리 " + tryCount + "/" + MAX_DIAGNOSIS_COUNT + " ---");
             System.out.println("1. 심장 질환  2. 외상 환자  3. 호흡기 질환");
             System.out.print("선택: ");

             int choice = sc.nextInt();
             String diagnosis = "";
             switch (choice) {
                 case 1:
                     diagnosis = "심장 질환 환자";
                     break;
                 case 2:
                     diagnosis = "외상 환자";
                     break;
                 case 3:
                     diagnosis = "호흡기 환자";
                     break;
                 default:
                     System.out.println("잘못된 번호입니다");
                     continue;
             }

             if (diagnosis.equals(patient.getPatientType())) {
                 System.out.println("\n진단 성공!");
                 return true;
             } else {
                 patient.takeDamage(10); // 진단 실패시 HP 데미지
                 System.out.println("\n오진입니다! 환자의 상태가 악화됩니다 (HP -10)");
                 System.out.println("현재 HP: " + patient.getHp());
             }
         }
         if (!patient.isAlive()) {
             System.out.println("진단 실패로 인해 환자가 사망했습니다.");
         } else {
             System.out.println("진단 기회를 모두 소모하여 치료로 넘어갈 수 없습니다.");
         }
         return false;
     }

     private boolean treatPatient(Patient patient) {
         System.out.println(patient.getName() + "치료 시작!");
         System.out.println("초기 HP: " + patient.getHp());

         // 치료 횟수 카운트
         int treatCount = 0;
         while(treatCount < MAX_COUNT && patient.getHp() < 100 && patient.isAlive()) {
             treatCount++;

             System.out.println("\n--- 치료 턴 " + treatCount
                     + "/" + MAX_COUNT + " ---");
             System.out.println("현재 HP: " + patient.getHp());

             Treatment treatment = selectTreatment();

             treatment.treat(patient);

             if (!patient.isAlive()) {
                 System.out.println("환자의 HP가 0이 되었습니다.");
                 break;
             }

             if (patient.getHp() == 100) {
                 System.out.println("HP 100 달성!");
                 break;
             }
         }
         return patient.isAlive() && patient.getHp() == 100;
     }

     public Treatment selectTreatment() {
         System.out.println("\n[치료 방법 선택]");
         System.out.println("1. 약물 치료 (회복 30 / 성공률 80%)");
         System.out.println("2. 응급 주사 (회복 50 / 성공률 60%)");
         System.out.println("3. 응급 처치 (회복 70 / 성공률 40%)");
         System.out.print("선택:");

         int choice = sc.nextInt();

         switch (choice) {
             case 1:
                 return new MedicineTreatment();
             case 2:
                 return new InjectionTreatment();
             default:
                 return new EmergencyTreatment();
         }
     }

    private void showFinalRank() {
        System.out.println("\n\n================================");
        System.out.println("             진료 결과");
        System.out.println("================================");

        System.out.println("완벽 치료 환자: "
                + successCount + "/" + TOTAL_PATIENTS);

        if (successCount == 5) {
            System.out.println("최종 등급: 🏆전설의 명의🏆");
        } else if (successCount == 4) {
            System.out.println("최종 등급: 🥈최고의 전문의🥈");
        } else if (successCount == 3) {
            System.out.println("최종 등급: 🥉유능한 의사🥉");
        } else if (successCount == 1 || successCount == 2) {
            System.out.println("최종 등급: 🩺수련 의사🩺");
        } else {
            System.out.println("최종 등급: 🔰인턴 의사🔰");
        }

        System.out.println("\n게임이 종료되었습니다.");
    }
}