# Practice 11 — 예외 처리 (개념 데모 + 실전 안티패턴)

> ⚠️ 이건 '풀어야 할 문제'가 아니라 **실행하면서 이해하는 학습용 데모**입니다.
> `Main.java`를 그냥 Run 해서, 예외가 발생하고 처리되는 과정을 눈으로 따라가세요.

## 실행 방법
`practice11/Main.java`를 실행(Run)하면 8개 섹션이 순서대로 출력됩니다.
예외가 여러 번 발생하지만, **프로그램은 끝까지 죽지 않습니다.** 그게 예외 처리의 목적이에요.

## 무엇을 보게 되나 (수업 자료와 1:1 매핑)
| 데모 | 개념 | 수업 자료 |
|------|------|-----------|
| 1 | 예외 종류 체험 (Arithmetic·NullPointer·ArrayIndex·NumberFormat) | 슬라이드 4·7 |
| 2 | try-catch-finally 실행 흐름 (예외 있을 때 / 없을 때) | 슬라이드 8·9 |
| 3 | 다중 예외 처리 (여러 catch · 순서 · OR 묶기) | 슬라이드 10·11 |
| 4 | try-with-resources (자원 자동 닫기) | 슬라이드 12 |
| 5 | 예외의 전가 throws (직접 처리 vs 전가) | 슬라이드 14·15·16 |
| 6 | 사용자 정의 예외 throw | 슬라이드 18~20·22 |
| 7 | getMessage() · printStackTrace() | 슬라이드 21 |
| 8 | **실전 안티패턴 (예외를 삼키면?)** | 실무 보강 |

## 예외 클래스 상속 구조
```
Object
 └─ Throwable  (모든 예외·에러의 조상)
     ├─ Error                 복구 불가 (OutOfMemoryError, StackOverflowError …)
     └─ Exception
         ├─ RuntimeException   ← 실행 예외 (처리 강제 X)
         │     NullPointerException, ArithmeticException, NumberFormatException …
         └─ (그 외)            ← 일반 예외 Checked (처리 강제 O)
               IOException, ClassNotFoundException, InterruptedException …
```

## Checked vs Runtime 한눈에
| 구분 | 일반 예외 (Checked) | 실행 예외 (RuntimeException) |
|------|--------------------|-----------------------------|
| 상속 | Exception 바로 상속 | RuntimeException 상속 |
| 처리 강제 | **필수** (안 하면 컴파일 오류) | 선택 (안 해도 컴파일 OK) |
| 의미 | 복구 가능한 상황 | 보통 코드 버그 → 수정이 정답 |
| 예시 | IOException, ClassNotFoundException | NullPointer, Arithmetic, … |

## 핵심 키워드
- **try-catch-finally** : 예외 처리 기본 (finally는 항상 실행)
- **throws** : 예외를 *호출한 곳으로* 전가 (메서드 선언부)
- **throw** : 예외를 *직접 발생*시킴 (문장)
- **사용자 정의 예외** : `Exception`(Checked) 또는 `RuntimeException`(Unchecked) 상속
- **catch 순서** : 구체적인 예외 → 부모(Exception) 순서로
- **getMessage()** / **printStackTrace()** : 메시지 확인 / 발생 경로 추적

---

## 🔥 실전 안티패턴 — "이렇게 하지 마세요" (실제 사례)
교과서 예제는 깔끔하지만, 진짜 코드에는 잘못된 예외 처리가 정말 많습니다.
아래는 **실제 사례**에서 발견한 패턴을 익명화한 것입니다.

> 참고: 실제 어떤 프로젝트에서는 `catch` 블록이 약 **977곳**, 그중 광범위한 `catch (Exception)`이 **134개 파일**에 있었습니다.

### 안티패턴 ① 예외를 '삼키기' (빈 catch)
```java
// ❌ 실제로 있던 코드
try {
    sendTempPassword(user);                 // 실패할 수 있는 작업
    resultMsg = "임시 비밀번호를 전송했습니다.";
} catch (Exception e) {
    // 비어 있음 — 아무것도 안 함
}
```
**문제**: 전송이 실패해도 catch가 아무 일도 안 하니, 사용자는 "전송했습니다"라는 **성공 메시지**를 받습니다. 진짜 오류는 조용히 사라져서 아무도 모릅니다. (데모 8번이 바로 이 상황입니다)
```java
// ✅ 최소한 로그를 남기고, 실패를 사용자에게 알린다
try {
    sendTempPassword(user);
    resultMsg = "임시 비밀번호를 전송했습니다.";
} catch (MailException e) {
    log.error("임시 비밀번호 전송 실패: userId={}", user.getId(), e);
    resultMsg = "전송에 실패했습니다. 잠시 후 다시 시도해 주세요.";
}
```

### 안티패턴 ② 오류를 null로 숨기기
```java
// ❌ 실제로 있던 코드
try {
    return cancelOrder(orderNo);   // 성공하면 주문번호 반환
} catch (Exception e) {
    return null;                   // "실패 -> 로그 출력" 이라 적혀 있지만, 로그가 없다!
}
```
**문제**: 호출한 쪽은 `null`을 받아도 **왜** 실패했는지 알 수 없습니다. 게다가 주석은 "로그 출력"이라는데 정작 로그가 없죠(주석과 코드 불일치). 이 null은 한참 뒤 엉뚱한 곳에서 `NullPointerException`으로 터집니다.
```java
// ✅ 실패를 로그로 남기고, 의미 있는 예외로 알린다
try {
    return cancelOrder(orderNo);
} catch (ApiException e) {
    log.error("주문 취소 실패: orderNo={}", orderNo, e);
    throw new OrderCancelException(orderNo, e);
}
```

### 안티패턴 ③ 너무 광범위한 `catch (Exception)`
```java
// ❌ 기대하지 않은 예외(버그)까지 전부 삼킨다
try {
    int price = Integer.parseInt(priceStr);
    // ... 다른 로직 ...
} catch (Exception e) {     // NumberFormatException뿐 아니라 NPE 같은 버그까지 다 잡힘
    price = 0;
}
```
**문제**: `catch (Exception)`은 우리가 예상한 예외(숫자 변환 실패)뿐 아니라 **진짜 버그**(NullPointerException 등)까지 잡아 숨깁니다. 잡아야 할 것만 **구체적으로** 잡으세요.
```java
// ✅ 예상하는 예외만 구체적으로
try {
    int price = Integer.parseInt(priceStr);
} catch (NumberFormatException e) {   // 숫자 변환 실패만 처리
    price = 0;
}
```

### 안티패턴 ④ (상황에 따라 OK) close() 삼키기 → try-with-resources로 제거
```java
// △ 자원 닫기라 봐주긴 하지만, 보기 안 좋고 반복된다
} finally {
    try { workbook.close(); } catch (Exception ignore) {}
}
```
이런 'close 삼키기'는 데모 4번의 **try-with-resources**로 통째로 없앨 수 있습니다.
```java
// ✅ 자동 close — finally도, 빈 catch도 필요 없다
try (Workbook workbook = createWorkbook()) {
    // ... 사용 ...
}   // try가 끝나면 close() 자동 호출
```

---

## 스스로 해보기 (선택)
1. 데모 3번에서 catch 순서를 `Exception`을 위로 바꿔 보세요 → **컴파일 오류**가 나는 걸 확인.
2. 데모 2번 `finally` 안에 `System.out.println`을 추가하고, try 안에 `return`을 넣어 보세요 → 그래도 finally가 실행될까요?
3. 데모 8번 `resetPasswordBad()`처럼 예외를 삼키는 코드가 왜 위험한지 한 문장으로 설명해 보세요.
