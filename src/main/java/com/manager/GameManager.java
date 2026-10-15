package com.manager;

import com.patient.Patient;
import com.patient.CardiacPatient;
import com.patient.RespiratoryPatient;
import com.patient.TraumaPatient;

import java.util.Random;
import java.util.Scanner;

public class GameManager {

     private Scanner sc = new Scanner(System.in);
     private Random random = new Random();
     private EventManager eventManager = new EventManager();

     private Patient[] patients = {
             new CardiacPatient("김철수"),
             new TraumaPatient("이영희"),
             new RespiratoryPatient("박민수"),
             new CardiacPatient("최지훈"),
             new TraumaPatient("정수빈")
     };

     // 치료에 성공한 환자 수 저장
     private int successCount = 0;

}