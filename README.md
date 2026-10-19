# 응급 치료 시뮬레이션 게임

> 플레이어가 응급실의 의사가 되어 5명의 환자를 진단하고 치료하는 시뮬레이션 게임
> 
> 환자마다 랜덤으로 설정된 초기 체력(HP)과 증상을 가지고 있으며, 플레이어는 제한된 횟수 내에 정확한 진단을 내리고 적절한 치료법을 선택해 환자의 HP를 100으로 회복시켜야 합니다
>
> 게임 진행 중 어느 화면에서든 메뉴의 0을 입력하여 게임을 종료할 수 있습니다

### 프로젝트 구조
```
com/
 ┣ 📂 run/
 ┃ ┗ 📜 Application.java (게임 실행)
 ┣ 📂 manager/
 ┃ ┗ 📜 GameManager.java (전체적인 게임 흐름, 진단 및 치료 로직, 사용자 입력 예외 처리 제어)
 ┣ 📂 patient/
 ┃ ┣ 📜 Patient.java (환자 추상 클래스, 랜덤 체력 부여 로직 포함)
 ┃ ┣ 📜 CardiacPatient.java (심장 질환 환자)
 ┃ ┣ 📜 RespiratoryPatient.java (호흡기 질환 환자)
 ┃ ┣ 📜 TraumaPatient.java (외상 환자)
 ┃ ┗ 📜 CreatePatient.java (환자 객체 생성 팩토리)
 ┗ 📂 treatment/
   ┣ 📜 Treatment.java (치료법 추상 클래스)
   ┣ 📜 MedicineTreatment.java (약물 치료)
   ┣ 📜 InjectionTreatment.java (주사 치료)
   ┗ 📜 EmergencyTreatment.java (응급 수술)
```

### 객체 지향 설계
- **추상화** : ```Patient```, ```Treatment```와 같이 공통된 속성과 행위를 추출하여 추상 클래스로 정의했습니다
- **캡슐화** : 환자의 체력인 ```hp```나 ```name```을 ```protected``` 접근 제어자로 선언하고, ```heal()```과 ```takeDamage()``` 메서드를 통해서만 체력이 변동되도록 작성했습니다
- **상속** : 심장, 호흡기, 외상 환자 클래스는 ```Patient```를 상속받아 고유의 질병명과 증상을 구현했으며, 부모 클래스의 ```getRandomHp()``` 메서드를 사용해 각기 다른 초기 체력을 설정했습니다. 다양한 치료법 역시 ```Treatment```를 상속받아 세부 수치를 구현했습니다.
- **다형성** : ```GameManager```에서는 구체적인 환자나 치료법 클래스에 의존하지 않고, 상위 타입인 ```Patient```와 ```Treatment```를 기반으로 동작하며, 오버라이딩된 메서드를 호출합니다

### 게임 시연 화면
<img width="506" height="482" alt="image" src="https://github.com/user-attachments/assets/f183b02b-081b-4410-98e1-2bbc6ce6f5e3" /><br />
**게임이 시작되면 랜덤 환자가 등장하고 플레이어는 2가지 증상을 보고 질병을 선택해 진단합니다. 오진 시 HP가 10 줄어듭니다**
<br />
<img width="487" height="482" alt="image" src="https://github.com/user-attachments/assets/a67d100e-1f80-4bee-9283-986c61eee720" /><br />
**질병 진단은 기회가 2번이며, 2번 모두 실패 시 환자 치료에 실패하고 다음 환자가 등장합니다**
<br />
<img width="503" height="661" alt="image" src="https://github.com/user-attachments/assets/9a00dc7e-0795-4b83-a592-82113c13ec4b" /><br />
**진단 성공 시 치료가 진행되며, 환자의 HP 상황을 보고 3가지 치료법 중 하나를 선택합니다**
<br />
<img width="437" height="455" alt="image" src="https://github.com/user-attachments/assets/b5096884-ffcb-477b-897f-2914fa09f894" /><br />
**치료는 기회가 5번이며, 5번 모두 실패하거나 환자의 HP가 0이 되면 치료에 실패하고 다음 환자가 등장합니다**
<br />
<img width="416" height="406" alt="image" src="https://github.com/user-attachments/assets/37c994e9-450f-4e74-bc12-ecd190ad6949" /><br />
**치료에 실패하면 환자의 HP가 15 줄어듭니다**
<br />
<img width="461" height="477" alt="image" src="https://github.com/user-attachments/assets/2b839daa-12b4-44ec-991e-112b60afed83" /><br />
**환자의 HP가 100이 되면 치료에 성공하며 다음 환자가 등장합니다**
<br />
<img width="436" height="288" alt="image" src="https://github.com/user-attachments/assets/9c3249dd-0e6f-4d2d-86ac-a664a3094b6d" /><br />
**5명의 환자를 모두 거친 후 또는 메뉴에서 0번을 통해 게임이 종료되면 완치시킨 환자 수에 따라 플레이어의 최종 등급을 확인할 수 있습니다**

### 트러블 슈팅
- 사용자 입력 예외로 인한 게임 강제 종료 문제
  - 문제: 메뉴 선택 시 사용자가 문자를 입력하면 ```InputMismatchException```이 발생하며 게임이 다운되는 문제가 있었습니다.
  - 해결: ```GameManager```에 입력을 전담하는 ```inputChoice()``` 메서드를 분리하고, 내부에서 무한 루프와 ```try-catch```문을 사용했습니다. 예외 발생 시 ```sc.nextLine()```으로 입력 버퍼를 비워내고 사용자에게 다시 정상 입력을 요구하도록 견고하게 개선했습니다.

- 단조로운 난이도 문제
  - 문제: 기존에는 환자의 질병별로 초기 HP가 고정되어 있어 반복 플레이 시 게임이 단조로웠습니다.
  - 해결: 부모 클래스인 ```Patient```에 난수를 활용하여 체력을 반환하는 ```getRandomHp(int min, int max)``` 공통 메서드를 작성했습니다. 자식 환자 클래스들이 각자 다른 체력 범위를 파라미터로 넘겨 호출하게 하여, 매번 다른 난이도와 상황이 연출되도록 확장성을 고려해 개선했습니다.
