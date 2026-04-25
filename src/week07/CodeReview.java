package week07;

/**
 * ============================================================
 *  Week07 - 코드 리뷰: Week06 PR 피드백
 *  "Tidy First?" & Clean Code 원칙 기반
 * ============================================================
 *
 *  이 파일은 week06 과제에서 제출된 PR들을 리뷰하고,
 *  클린 코드 관점에서 개선할 수 있는 부분을 정리한 자료입니다.
 *
 *  각 항목은 [작성된 코드] → [개선된 코드] 형태로 구성되어 있습니다.
 *  본인의 코드를 찾아서 어떤 점이 개선되었는지 확인해보세요.
 *
 * ============================================================
 */
public class CodeReview {

    // =========================================================
    // 1. 네이밍 컨벤션 (Naming Convention)
    //    - Java 메서드명은 camelCase를 사용합니다.
    //    - 메서드명은 동사로 시작해야 의도가 명확합니다.
    // =========================================================

    /*
     * [PR #13 - 이윤건]
     *
     * ❌ 작성된 코드:
     *   public void ResetScore(int score) { ... }
     *   public void AddScore(int score) { ... }
     *   private void SelectRank() { ... }
     *
     * ✅ 개선된 코드:
     *   public void resetScore(int score) { ... }
     *   public void addScore(int score) { ... }
     *   private void updateGrade() { ... }
     *
     * 💡 이유:
     *   Java에서 메서드명이 대문자로 시작하면 클래스명처럼 보입니다.
     *   팀 프로젝트에서 코드를 읽는 사람이 혼란스러워질 수 있어요.
     *   또한 SelectRank보다 updateGrade가 "등급을 갱신한다"는
     *   의도를 더 명확하게 전달합니다.
     */


    // =========================================================
    // 2. 캡슐화 (Encapsulation)
    //    - 필드는 private으로 선언하고, getter/setter로 접근합니다.
    //    - "외부에서 직접 접근할 수 없어야 합니다" = private
    // =========================================================

    /*
     * [PR #16 - 김효민]
     *
     * ❌ 작성된 코드:
     *   public class Student {
     *       public String name = "이름없음";
     *       public int score = 0;
     *   }
     *
     * ✅ 개선된 코드:
     *   public class Student {
     *       private String name;
     *       private int score;
     *
     *       public String getName() { return name; }
     *       public int getScore() { return score; }
     *   }
     *
     * 💡 이유:
     *   필드가 public이면 외부에서 student.score = -999 처럼
     *   유효하지 않은 값을 직접 넣을 수 있습니다.
     *   private + setter(검증 로직 포함)로 보호해야 합니다.
     *   이것이 객체지향의 핵심 원칙 "캡슐화"입니다.
     */


    // =========================================================
    // 3. 메서드의 책임 분리 (Single Responsibility)
    //    - 하나의 메서드는 하나의 일만 해야 합니다.
    //    - 출력과 로직을 분리하면 재사용성이 높아집니다.
    // =========================================================

    /*
     * [PR #16 - 김효민]
     *
     * ❌ 작성된 코드:
     *   public String returnScore(int score) {
     *       String message = "";
     *       if (90 <= score) {
     *           message = "학생의 점수는 A 등급 입니다.";
     *       } else if (80 <= score) {
     *           message = "학생의 점수는 B 등급 입니다.";
     *       }
     *       ...
     *       System.out.print(message + "\n");  // 출력까지 같이 함
     *       return message;
     *   }
     *
     * ✅ 개선된 코드:
     *   // 등급만 반환 (로직만 담당)
     *   public String getGrade() {
     *       if (score >= 90) return "A";
     *       if (score >= 80) return "B";
     *       if (score >= 70) return "C";
     *       return "F";
     *   }
     *
     *   // 출력은 호출하는 쪽에서
     *   System.out.println("등급: " + student.getGrade());
     *
     * 💡 이유:
     *   returnScore는 이름만 봐서는 무엇을 반환하는지 알 수 없고,
     *   값을 반환하면서 동시에 출력까지 합니다.
     *   메서드가 두 가지 일을 하면 테스트하기 어렵고,
     *   다른 곳에서 재사용할 수 없습니다.
     *   "계산"과 "출력"을 분리하세요.
     */


    // =========================================================
    // 4. 버그: this vs 파라미터 혼동
    //    - this.score와 파라미터 score를 구분해야 합니다.
    // =========================================================

    /*
     * [PR #13 - 이윤건]
     *
     * ❌ 작성된 코드:
     *   public void AddScore(int score) {
     *       this.score += score;
     *
     *       if (score > 100) {     // ⚠️ 파라미터를 체크하고 있음!
     *           score = 100;       // ⚠️ 파라미터를 바꿈 (this.score 아님!)
     *       }
     *
     *       SelectRank();
     *   }
     *
     * ✅ 개선된 코드:
     *   public void addBonus(int bonus) {
     *       int newScore = this.score + bonus;
     *
     *       if (newScore > 100) {
     *           newScore = 100;
     *       }
     *       if (newScore < 0) {
     *           newScore = 0;
     *       }
     *
     *       this.score = newScore;
     *       updateGrade();
     *   }
     *
     * 💡 이유:
     *   원래 코드에서는 this.score에 이미 더한 뒤,
     *   파라미터 score만 100으로 바꾸고 있어서 this.score는 그대로입니다.
     *   즉, 100점 초과 방지가 작동하지 않는 버그입니다.
     *   변수명을 다르게 지어서 혼동을 방지하세요.
     */


    // =========================================================
    // 5. 매직 넘버 제거 (Magic Number → 상수)
    //    - 코드에 숫자가 직접 들어가면 의미를 알기 어렵습니다.
    //    - 상수로 선언하면 의도가 명확해집니다.
    // =========================================================

    /*
     * [PR #8 - 김성우, PR #11 - 성적관리, PR #14 - 김시현, PR #15 - 박도현]
     *
     * ❌ 작성된 코드 (다수 PR에서 공통):
     *   if (score >= 0 && score <= 100) { ... }
     *   if (score >= 90) return "A";
     *   if (score >= 60) return true;
     *
     * ✅ 개선된 코드:
     *   private static final int MIN_SCORE = 0;
     *   private static final int MAX_SCORE = 100;
     *   private static final int PASSING_SCORE = 60;
     *
     *   if (score >= MIN_SCORE && score <= MAX_SCORE) { ... }
     *
     * 💡 이유:
     *   "100"이 최대 점수인지, 만점 보너스인지 코드만 봐서는 알 수 없습니다.
     *   상수명으로 의미를 부여하면 코드가 문서가 됩니다.
     *   나중에 기준이 바뀌어도 한 곳만 수정하면 됩니다.
     *   (PR #7 이석훈 학생은 이 부분을 잘 적용했습니다 👍)
     */


    // =========================================================
    // 6. 메서드 추출 (Extract Method)
    //    - main에 모든 로직을 넣지 말고, 의미 단위로 분리합니다.
    //    - "Tidy First?" 에서 말하는 핵심: 구조 변경 먼저, 기능 변경은 나중에.
    // =========================================================

    /*
     * [PR #13 - 이윤건, PR #15 - 박도현]
     *
     * ❌ 작성된 코드 (main 안에 모든 로직):
     *   case 3:
     *       System.out.print("이름 입력: ");
     *       name = sc.next();
     *       System.out.println("새 점수 입력: ");
     *       int num = sc.nextInt();
     *       if (num > 100 || num < 0) {
     *           System.out.println("유효하지 않은 점수입니다.");
     *           break;
     *       }
     *       for (int i = 0; i < count; i++) {
     *           if (students[i].getName().equals(name)) {
     *               students[i].ResetScore(num);
     *           }
     *       }
     *       System.out.println("점수 수정 완료: " + name + " (" + num + "점)");
     *       break;
     *
     * ✅ 개선된 코드:
     *   case 3:
     *       updateScore(sc, students, count);
     *       break;
     *
     *   // 별도 메서드로 추출
     *   private static void updateScore(Scanner sc, Student[] students, int count) {
     *       System.out.print("이름 입력: ");
     *       String name = sc.nextLine().trim();
     *
     *       Student found = findByName(students, count, name);
     *       if (found == null) {
     *           System.out.println("해당 학생을 찾을 수 없습니다.");
     *           return;
     *       }
     *
     *       System.out.print("새 점수 입력: ");
     *       int newScore = Integer.parseInt(sc.nextLine());
     *
     *       if (found.setScore(newScore)) {
     *           System.out.println("점수 수정 완료: " + found.getName() + " (" + newScore + "점)");
     *       } else {
     *           System.out.println("유효하지 않은 점수입니다");
     *       }
     *   }
     *
     *   private static Student findByName(Student[] students, int count, String name) {
     *       for (int i = 0; i < count; i++) {
     *           if (students[i].getName().equals(name)) return students[i];
     *       }
     *       return null;
     *   }
     *
     * 💡 이유:
     *   main 메서드가 200줄이 넘으면 읽기 어렵습니다.
     *   각 case를 메서드로 빼면 main은 "목차"가 되고,
     *   각 메서드는 "챕터"가 됩니다.
     *   (PR #7 이석훈 학생은 메서드 분리를 잘 했습니다 👍)
     */


    // =========================================================
    // 7. 점수 검증 위치 (도메인 로직은 도메인 객체 안에)
    //    - 점수 유효성 검사는 Student 클래스 안에서 해야 합니다.
    //    - Main에서 검증하면 다른 곳에서 Student를 쓸 때 검증이 빠집니다.
    // =========================================================

    /*
     * [PR #13 - 이윤건]
     *
     * ❌ 작성된 코드 (Main에서 검증):
     *   // Week06Main.java
     *   if (Integer.parseInt(score) > 100 || Integer.parseInt(score) < 0) {
     *       System.out.println("0~100점 사이로 입력해주세요.");
     *       break;
     *   }
     *   students[count++] = new Student(name, Integer.parseInt(score));
     *
     *   // Student.java - 검증 없이 바로 저장
     *   public Student(String name, int score) {
     *       this.name = name;
     *       this.score = score;
     *   }
     *
     * ✅ 개선된 코드 (Student가 스스로 검증):
     *   // Student.java
     *   public Student(String name, int score) {
     *       this.name = name;
     *       if (score >= 0 && score <= 100) {
     *           this.score = score;
     *       } else {
     *           this.score = 0;  // 또는 예외를 던지기
     *       }
     *   }
     *
     * 💡 이유:
     *   Student 객체는 "자기 데이터의 무결성"을 스스로 보장해야 합니다.
     *   Main에서만 검증하면, 나중에 다른 클래스가 Student를 생성할 때
     *   잘못된 점수가 들어갈 수 있습니다.
     *   이것을 "Tell, Don't Ask" 원칙이라고 합니다.
     */


    // =========================================================
    // 8. 불필요한 배열 복사 제거
    //    - 매번 배열을 복사하면 메모리 낭비 + 버그 가능성
    // =========================================================

    /*
     * [PR #8 - 김성우]
     *
     * ❌ 작성된 코드:
     *   // 메뉴 선택할 때마다 배열 복사
     *   case 2:
     *       ReportService.printAllStudents(getCurrentStudents(students, studentCount));
     *       break;
     *   case 4:
     *       ReportService.applyBonus(getCurrentStudents(students, studentCount), bonus);
     *       break;
     *
     *   private static Student[] getCurrentStudents(Student[] all, int count) {
     *       Student[] current = new Student[count];
     *       System.arraycopy(all, 0, current, 0, count);
     *       return current;
     *   }
     *
     * ✅ 개선된 코드:
     *   // count를 함께 전달
     *   case 2:
     *       ReportService.printAll(students, count);
     *       break;
     *   case 4:
     *       ReportService.applyBonus(students, count, bonus);
     *       break;
     *
     * 💡 이유:
     *   getCurrentStudents는 호출할 때마다 새 배열을 만들고 복사합니다.
     *   특히 case 4에서 복사된 배열에 보너스를 부여하면,
     *   원본 배열은 변경되지 않아서 보너스가 반영 안 되는 버그가 발생합니다!
     *   count를 함께 전달하면 복사 없이 해결됩니다.
     */


    // =========================================================
    // 9. 미완성 기능에 대한 처리
    //    - 구현하지 않은 기능은 명확하게 표시해야 합니다.
    // =========================================================

    /*
     * [PR #16 - 김효민]
     *
     * ❌ 작성된 코드:
     *   case 2:
     *       System.out.println("프로그램을 종료합니다.");  // 종료 메시지인데 종료 안 됨
     *       break;
     *   case 3:
     *       System.out.println("프로그램을 종료합니다.");
     *       break;
     *
     * ✅ 개선된 코드:
     *   case 2:
     *       // TODO: 전체 학생 목록 조회 구현
     *       System.out.println("아직 구현되지 않은 기능입니다.");
     *       break;
     *
     * 💡 이유:
     *   "프로그램을 종료합니다"를 출력하지만 실제로 종료되지 않으면
     *   사용자가 혼란스럽습니다. 미완성 기능은 TODO 주석과 함께
     *   정직한 메시지를 출력하는 것이 좋습니다.
     */


    // =========================================================
    // 10. 생성자 체이닝 (Constructor Chaining)
    //     - 중복 코드를 줄이는 this() 활용
    // =========================================================

    /*
     * [PR #13 - 이윤건, PR #16 - 김효민]
     *
     * ❌ 작성된 코드 (생성자가 하나뿐):
     *   public Student(String name, int score) {
     *       this.name = name;
     *       this.score = score;
     *   }
     *   // → 이름만 입력하거나, 아무것도 입력 안 하는 경우를
     *   //   Main에서 직접 처리해야 함
     *
     * ✅ 개선된 코드 (생성자 체이닝):
     *   public Student() {
     *       this("이름없음", 0);        // 3번 → 1번 호출
     *   }
     *
     *   public Student(String name) {
     *       this(name, 0);             // 2번 → 1번 호출
     *   }
     *
     *   public Student(String name, int score) {  // 1번: 핵심 생성자
     *       this.name = name;
     *       this.score = score;
     *       totalCount++;
     *   }
     *
     * 💡 이유:
     *   생성자가 여러 개일 때 this()로 연결하면
     *   초기화 로직이 한 곳에만 존재합니다.
     *   수정할 때 한 곳만 바꾸면 되므로 실수가 줄어듭니다.
     *   (PR #7, #8, #11, #14, #15 학생들은 이 부분을 잘 적용했습니다 👍)
     */


    // =========================================================
    // 11. enum 활용에 대한 피드백
    //     - 좋은 시도! 하지만 활용이 아쉬운 부분
    // =========================================================

    /*
     * [PR #13 - 이윤건]
     *
     * 작성된 코드 (좋은 시도):
     *   enum RankType {
     *       A,   // >= 90
     *       B,   // >= 80
     *       C,   // >= 70
     *       F    // 70 >
     *   }
     *
     * ✅ 더 발전시킨 코드:
     *   enum Grade {
     *       A(90), B(80), C(70), F(0);
     *
     *       private final int minScore;
     *
     *       Grade(int minScore) {
     *           this.minScore = minScore;
     *       }
     *
     *       public static Grade fromScore(int score) {
     *           for (Grade g : values()) {
     *               if (score >= g.minScore) return g;
     *           }
     *           return F;
     *       }
     *   }
     *
     * 💡 이유:
     *   enum에 점수 기준값을 함께 넣으면, if-else 분기 없이
     *   Grade.fromScore(85) → Grade.B 로 깔끔하게 변환됩니다.
     *   등급 기준이 바뀌어도 enum만 수정하면 됩니다.
     *   enum을 사용한 것 자체는 좋은 판단이었습니다!
     */


    // =========================================================
    // 12. ReportService 미구현
    // =========================================================

    /*
     * [PR #13 - 이윤건, PR #16 - 김효민]
     *
     * ❌ 작성된 코드:
     *   public class ReportService {
     *       // TODO: 리포트 관련 메서드를 만드세요
     *   }
     *
     * 💡 피드백:
     *   ReportService가 비어있고, 평균 계산/출력 로직이
     *   Main에 직접 작성되어 있습니다.
     *   과제 요구사항에서 리포트 기능은 "다른 패키지"에 위치하고,
     *   "객체 생성 없이(static) 사용 가능"해야 합니다.
     *   Week06Main이 비대해지는 것을 막으려면
     *   역할에 맞는 클래스에 로직을 배치하세요.
     */


    // =========================================================
    //  잘한 점 정리
    // =========================================================

    /*
     * [PR #7 - 이석훈] ⭐ 전체적으로 가장 완성도 높음
     *   - 상수 선언 (MIN_SCORE, MAX_SCORE 등)
     *   - 메서드 분리 (registerStudent, updateScore, applyBonusMenu 등)
     *   - 생성자 체이닝
     *   - private 생성자로 유틸 클래스(ReportService) 인스턴스화 방지
     *   - try-with-resources로 Scanner 자원 관리
     *   - 보너스 점수 상한(clamp) 처리
     *
     * [PR #8 - 김성우]
     *   - 생성자 체이닝 잘 활용
     *   - calculateGrade를 private으로 내부 처리
     *   - 주석으로 의도 설명을 잘 함
     *
     * [PR #11 - 20263942]
     *   - pause() 메서드로 UX 고려 (좋은 아이디어!)
     *   - setScore에서 boolean 반환으로 성공/실패 구분
     *
     * [PR #14 - 김시현]
     *   - ArrayList 활용 (배열 크기 제한 없는 구조)
     *   - scanner.close() 호출로 자원 정리
     *   - String으로 메뉴 입력 받아 NumberFormatException 방지
     *
     * [PR #15 - 박도현]
     *   - 전체적으로 안정적이고 깔끔한 코드
     *   - count == 0 체크로 빈 배열 처리
     *   - setScore boolean 반환 활용
     */
}
