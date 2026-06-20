package practice10;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    String[] names = {"김민준", "이서연", "박도윤", "최지우", "정하준", "강유나", "윤서준"};
    int[] scores = {85, 92, 78, 60, 95, 88, 73};

    System.out.println("===== 퀴즈 대회 점수판 =====");

    ArrayList<Participant> participants = new ArrayList<>();

    for (int i = 0; i < names.length; i++) {
      participants.add(new Participant(names[i], scores[i]));
    }

    int total = 0;
    for (Participant p : participants) {
      total += p.getScore();
    }
    double avg = (double) total / participants.size();
    System.out.println("[전체 참가자] " + participants.size() + "명");
    System.out.println("[평균 점수] " + String.format("%.1f", avg) + "점");

    System.out.println();

    Participant top = participants.get(0);
    for (Participant p : participants) {
      if (p.getScore() > top.getScore()) {
        top = p;
      }
    }
    System.out.println("[1등] " + top.getName() + " (" + top.getScore() + "점)");

    System.out.println();

    ArrayList<Participant> passed = new ArrayList<>();
    for (Participant p : participants) {
      if (p.getScore() >= 80) {
        passed.add(p);
      }
    }
    System.out.println("[합격자 명단 (80점 이상)] " + passed.size() + "명");
    for (Participant p : passed) {
      System.out.println("- " + p.getName() + " (" + p.getScore() + "점)");
    }

    System.out.println();

    int removeIndex = -1;
    for (int i = 0; i < participants.size(); i++) {
      if (participants.get(i).getName().equals("최지우")) {
        removeIndex = i;
        break;
      }
    }
    participants.remove(removeIndex);
    System.out.println("[기권 처리] 최지우 제외");
    System.out.println("[남은 참가자] " + participants.size() + "명");
    for (Participant p : participants) {
      System.out.println("- " + p.getName() + " (" + p.getScore() + "점)");
    }
  }
}
