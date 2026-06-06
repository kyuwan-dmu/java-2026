package practice10;

/**
 * 퀴즈 대회 참가자 한 명을 표현하는 클래스.
 *
 * 점수를 바꿀 수 있도록 setter 가 있습니다.
 * 바로 이 'setter' 때문에, 객체를 어디에서 new 하느냐에 따라
 * 결과가 완전히 달라집니다. (README 의 '가장 자주 하는 실수' 참고)
 */
public class Participant {

  private String name;
  private int score;

  // 기본 생성자
  public Participant() {
  }

  // 이름과 점수를 한 번에 받는 생성자
  public Participant(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setScore(int score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return name + " (" + score + "점)";
  }
}
