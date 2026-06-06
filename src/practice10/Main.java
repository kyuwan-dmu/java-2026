package practice10;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    // 퀴즈 대회 참가자 데이터 (이름과 점수는 같은 순서로 짝을 이룹니다)
    String[] names = {"김민준", "이서연", "박도윤", "최지우", "정하준", "강유나", "윤서준"};
    int[] scores = {85, 92, 78, 60, 95, 88, 73};

    System.out.println("===== 퀴즈 대회 점수판 =====");

    // TODO 1: 두 배열을 순회하며 Participant 객체를 만들어 아래 리스트(participants)에 담으시오.
    ArrayList<Participant> participants = new ArrayList<>();

    for (int i=0; i < names.length; i++) {
      participants.add(new Participant(names[i], scores[i]));
    }

    // TODO 2: 전체 참가자 수와 평균 점수를 출력하시오. (평균은 소수 첫째 자리까지)
    int count = 0;
    int sum = 0;
    for (Participant partici : participants) {
      sum += partici.getScore();
      count++;
    }

    System.out.println("[전체 참가자] " + count + "명\n" + "[평균 점수] " + sum / scores.length + "점");

    // TODO 3: 최고 점수 참가자(1등)를 찾아 출력하시오.
    String name="";
    int score = 0;

    for (Participant part: participants) {
      if (score < part.getScore()) {
        score = part.getScore();
        name = part.getName();
      }
    }
    System.out.println("[1등] " + name + " (" + score + "점)");

    // TODO 4: 80점 이상 합격자만 '새 ArrayList'에 담아 출력하시오.


    // TODO 5: "최지우"가 기권했습니다.
    //         participants 에서 찾아 제거하고, 남은 인원과 명단을 출력하시오.


    // TODO 6 (생각해보기 — 코드는 안 짜도 됩니다):
    //         만약 scores 가 문자열이고 그 안에 "불참" 이 섞여 있다면?
    //         Integer.parseInt("불참") 은 어떻게 될까요?  → 다음 시간: 예외 처리
  }
}
