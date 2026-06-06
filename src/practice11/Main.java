package practice11;

/**
 * Practice 11 — 예외 처리 개념 데모
 *
 * 이 파일은 '풀어야 할 실습'이 아니라, 실행하면서 예외 처리 개념을
 * 눈으로 확인하는 학습용 데모입니다. 수업 자료(예외 처리)의 순서를 그대로 따라갑니다.
 *
 *   1. 예외 종류 체험        (실행 예외 RuntimeException 들)
 *   2. try-catch-finally     (실행 흐름: 예외 있을 때 / 없을 때)
 *   3. 다중 예외 처리         (여러 catch · 순서 · OR 묶기 |)
 *   4. try-with-resources    (자원 자동 닫기)
 *   5. 예외의 전가 (throws)  (직접 처리 vs 전가)
 *   6. 사용자 정의 예외       (throw 로 직접 발생)
 *   7. 예외 메서드            (getMessage · printStackTrace)
 *   8. 안티패턴 체험          (예외를 '삼키면'? — 실무에서 하지 말 것)
 *
 * 그냥 실행(Run) 해 보세요. 예외가 나도 프로그램이 끝까지 살아남는 것을 확인할 수 있습니다.
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("########## 예외 처리 개념 데모 ##########");
    System.out.println("예외를 일부러 발생시키고, 잡아서 처리하는 과정을 따라가 봅니다.\n");

    demo1_exceptionKinds();
    demo2_tryCatchFinally();
    demo3_multiCatch();
    demo4_tryWithResources();
    demo5_throwsPropagation();
    demo6_customException();
    demo7_exceptionMethods();
    demo8_antiPattern();

    System.out.println("########## 끝. 예외가 났지만 프로그램은 죽지 않았습니다 ##########");
  }

  // ===================================================================
  // 1. 예외 종류 체험하기  —  실행 예외(RuntimeException)를 일부러 발생시켜 본다
  //    (컴파일은 되지만 실행 중에 터지는 예외들)
  // ===================================================================
  private static void demo1_exceptionKinds() {
    System.out.println("===== 1. 예외 종류 체험하기 =====");

    try {
      int result = 10 / 0;                 // 정수를 0으로 나눔
      System.out.println(result);
    } catch (ArithmeticException e) {
      System.out.println("[ArithmeticException] 10 / 0 실행");
      System.out.println("  → 잡힘! 메시지: " + e.getMessage());
    }

    try {
      String s = null;
      s.length();                          // null 객체의 메서드 호출
    } catch (NullPointerException e) {
      System.out.println("[NullPointerException] null.length() 호출");
      System.out.println("  → 잡힘! null 을 사용하려다 터짐");
    }

    try {
      int[] arr = {1, 2, 3};
      System.out.println(arr[5]);          // 배열 범위 초과
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("[ArrayIndexOutOfBoundsException] 크기 3 배열의 [5] 접근");
      System.out.println("  → 잡힘! 메시지: " + e.getMessage());
    }

    try {
      int n = Integer.parseInt("10!");     // 숫자가 아닌 문자열 변환
      System.out.println(n);
    } catch (NumberFormatException e) {
      System.out.println("[NumberFormatException] \"10!\" 숫자 변환");
      System.out.println("  → 잡힘! 메시지: " + e.getMessage());
    }

    System.out.println();
  }

  // ===================================================================
  // 2. try - catch - finally  —  예외가 '있을 때'와 '없을 때' 흐름 비교
  //    어느 경우든 finally 는 항상 실행된다
  // ===================================================================
  private static void demo2_tryCatchFinally() {
    System.out.println("===== 2. try-catch-finally 실행 흐름 =====");

    System.out.println("[A] 예외가 '있을' 때");
    try {
      System.out.println("  ① try 블록 진입");
      int x = 10 / 0;                      // 여기서 예외 발생 → 즉시 try 를 빠져나감
      System.out.println("  (이 줄은 실행되지 않습니다)");
    } catch (ArithmeticException e) {
      System.out.println("  ② 예외 발생! catch 로 점프");
      System.out.println("  ③ catch 처리: 0으로 나눌 수 없음");
    } finally {
      System.out.println("  ④ finally 는 '항상' 실행됨 ✔");
    }
    System.out.println("  ⑤ 프로그램은 죽지 않고 계속 진행\n");

    System.out.println("[B] 예외가 '없을' 때");
    try {
      System.out.println("  ① try 블록 진입");
      int x = 10 / 2;                      // 정상 실행
      System.out.println("  ② 정상 실행: 10 / 2 = " + x);
    } catch (ArithmeticException e) {
      System.out.println("  (예외가 없으므로 catch 는 건너뜀)");
    } finally {
      System.out.println("  ③ finally 는 이때도 실행됨 ✔");
    }

    System.out.println();
  }

  // ===================================================================
  // 3. 다중 예외 처리  —  여러 catch / 순서 주의 / OR( | ) 로 묶기
  // ===================================================================
  private static void demo3_multiCatch() {
    System.out.println("===== 3. 다중 예외 처리 (여러 개의 catch) =====");

    try {
      int a = Integer.parseInt("20A");     // NumberFormatException 이 먼저 발생
      System.out.println(3 / 0);           // (여기까지 오지 못함)
    } catch (NumberFormatException e) {
      System.out.println("  catch ①(NumberFormatException) 실행 → 숫자 변환 불가");
    } catch (ArithmeticException e) {
      System.out.println("  catch ②(ArithmeticException) 실행 → 0으로 나눔");
    }
    System.out.println("  ※ 일치하는 catch '하나만' 실행됩니다 (위 → 아래 순서로 검사)");
    System.out.println("  ※ 순서 주의: 부모(Exception)를 위에 두면 컴파일 오류!\n");

    System.out.println("[ OR( | ) 로 묶기 ] 같은 처리는 catch 하나로 — JDK 1.7+");
    try {
      System.out.println(3 / 0);
    } catch (ArithmeticException | NumberFormatException e) {
      System.out.println("  하나의 catch 가 두 예외를 모두 처리 → " + e.getMessage());
    }

    System.out.println();
  }

  // ===================================================================
  // 4. try - with - resources  —  AutoCloseable 자원을 자동으로 close()
  // ===================================================================
  private static void demo4_tryWithResources() {
    System.out.println("===== 4. try-with-resources (자원 자동 닫기) =====");

    try (DemoResource r = new DemoResource("주문파일")) {   // try( ) 안에서 자원 생성
      r.use();
    }
    // close() 를 직접 호출하지 않았는데도, try 가 끝나면 자동으로 닫힌다
    System.out.println("  ※ close() 를 부르지 않았는데 자동으로 닫혔습니다 (AutoCloseable)\n");
  }

  // ===================================================================
  // 5. 예외의 전가 (throws)  —  같은 일을 (A) 직접 처리 / (B) 전가
  //    Thread.sleep() 은 throws InterruptedException 이라 둘 중 하나는 꼭 해야 한다
  // ===================================================================
  private static void demo5_throwsPropagation() {
    System.out.println("===== 5. 예외의 전가 (throws) =====");

    System.out.println("[A] 하위 메서드가 '직접 처리'");
    handleHere();
    System.out.println();

    System.out.println("[B] 호출한 곳으로 '전가' (throws)");
    try {
      passUp();                            // passUp 은 처리 안 하고 전가 → 여기서 받음
    } catch (InterruptedException e) {
      System.out.println("  → 전가받아 main 쪽에서 처리");
    }
    System.out.println("  ※ 전가하면 '호출한 메서드'가 예외를 책임집니다\n");
  }

  // 방법 1: 메서드 안에서 try-catch 로 직접 처리
  private static void handleHere() {
    try {
      System.out.println("  잠깐 멈춤(0.1초)...");
      Thread.sleep(100);
      System.out.println("  깨어남 → 예외는 이 메서드가 직접 책임");
    } catch (InterruptedException e) {
      System.out.println("  여기서 직접 처리");
    }
  }

  // 방법 2: 처리하지 않고 throws 로 호출한 곳에 떠넘김
  private static void passUp() throws InterruptedException {
    System.out.println("  잠깐 멈춤(0.1초)...");
    Thread.sleep(100);
    System.out.println("  깨어남 → 처리 안 함, 호출한 곳이 책임");
  }

  // ===================================================================
  // 6. 사용자 정의 예외  —  내 규칙(점수 0~100)에 맞는 예외를 throw 로 발생
  // ===================================================================
  private static void demo6_customException() {
    System.out.println("===== 6. 사용자 정의 예외 만들기 (throw) =====");
    System.out.println("규칙: 점수는 0~100 만 정상. 벗어나면 내가 만든 예외를 발생시킨다.\n");

    checkScore(85);                        // 정상
    checkScore(150);                       // OverException
    checkScore(-10);                       // MinusException

    System.out.println();
  }

  // 점수를 검사하고, 규칙에 어긋나면 throw 로 예외를 발생시켜 직접 처리
  private static void checkScore(int score) {
    try {
      if (score < 0) {
        throw new MinusException("점수가 음수입니다: " + score);
      } else if (score > 100) {
        throw new OverException("점수가 100을 초과: " + score);
      } else {
        System.out.println("  점수 " + score + " → 정상");
      }
    } catch (MinusException | OverException e) {     // 두 사용자 예외를 한 번에 처리
      System.out.println("  점수 " + score + " → 예외! " + e.getMessage());
    }
  }

  // ===================================================================
  // 7. 예외 클래스의 대표 메서드  —  getMessage() · printStackTrace()
  // ===================================================================
  private static void demo7_exceptionMethods() {
    System.out.println("===== 7. 예외 클래스의 대표 메서드 =====");

    // getMessage(): 예외 생성 시 넘긴 메시지를 반환 (없으면 null)
    try {
      throw new Exception("직접 넣은 오류 메시지");
    } catch (Exception e) {
      System.out.println("  getMessage() → " + e.getMessage());
    }
    try {
      throw new Exception();                          // 메시지 없이 생성
    } catch (Exception e) {
      System.out.println("  getMessage() (메시지 없을 때) → " + e.getMessage());  // null
    }

    // printStackTrace(): 예외 발생 경로를 추적 출력 (디버깅용)
    System.out.println("  printStackTrace() → 예외가 어디서 났는지 경로를 출력 (에러 스트림):");
    try {
      int x = 10 / 0;
    } catch (ArithmeticException e) {
      e.printStackTrace();
    }

    System.out.println();
  }

  // ===================================================================
  // 8. 안티패턴 체험  —  예외를 '삼키면' 무슨 일이 생기나
  //    (교과서 예제가 아니라, 실무 코드에서 진짜 자주 나오는 잘못된 패턴)
  // ===================================================================
  private static void demo8_antiPattern() {
    System.out.println("===== 8. 안티패턴 체험: 예외를 '삼키면' =====");

    System.out.println("[❌ 빈 catch] " + resetPasswordBad());
    System.out.println("    → 서버는 실패했는데 사용자는 '성공'한 줄 압니다 (예외를 삼킴)");

    System.out.println("[✅ 제대로]   " + resetPasswordGood());
    System.out.println("    → 실패를 정확히 알려줍니다");

    System.out.println("  ※ 실제 사례에서도 이런 빈 catch 가 자주 보입니다 (README '실전 안티패턴' 참고)");
    System.out.println();
  }

  // ❌ 예외를 빈 catch 로 삼킴 → 실패해도 '성공' 메시지를 돌려준다
  private static String resetPasswordBad() {
    try {
      sendTempPassword();                  // 여기서 실패(예외)
      return "임시 비밀번호를 전송했습니다.";
    } catch (Exception e) {
      // 아무것도 하지 않음 ← 예외 삼키기 (안티패턴!)
    }
    return "임시 비밀번호를 전송했습니다.";    // 실패했는데도 '성공' 메시지!
  }

  // ✅ 예외를 잡아서 '실패'를 정확히 알린다
  private static String resetPasswordGood() {
    try {
      sendTempPassword();
      return "임시 비밀번호를 전송했습니다.";
    } catch (Exception e) {
      return "전송 실패: " + e.getMessage();
    }
  }

  // 데모용: 항상 실패하는 작업 (메일 서버가 죽었다고 가정)
  private static void sendTempPassword() {
    throw new RuntimeException("메일 서버 연결 끊김");
  }
}

// =====================================================================
// 사용자 정의 예외 (Exception 을 상속 = 일반 예외 / Checked)
//   - 수업 자료의 작성법 그대로: 생성자 2개 (기본 / 메시지를 받아 super 호출)
//   - RuntimeException 을 상속하면 '실행 예외(처리 강제 X)' 가 된다
// =====================================================================
class MinusException extends Exception {
  MinusException() {
  }

  MinusException(String message) {
    super(message);          // 부모(Throwable)에 메시지 전달 → getMessage() 로 꺼낸다
  }
}

class OverException extends Exception {
  OverException() {
  }

  OverException(String message) {
    super(message);
  }
}

// =====================================================================
// try-with-resources 데모용 자원
//   AutoCloseable 을 구현하면 try( ) 가 끝날 때 close() 가 자동 호출된다
// =====================================================================
class DemoResource implements AutoCloseable {

  private final String name;

  DemoResource(String name) {
    this.name = name;
    System.out.println("  [열림] " + name + " 자원을 열었습니다");
  }

  void use() {
    System.out.println("  [사용] " + name + " 자원을 사용 중...");
  }

  @Override
  public void close() {       // try 가 끝나면 자동으로 호출됨
    System.out.println("  [닫힘] " + name + " 자원이 자동으로 닫혔습니다 ✔");
  }
}
