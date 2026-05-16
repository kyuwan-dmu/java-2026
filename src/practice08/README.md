# Practice 08 — 한 줄로 끝내기 (Stream API)

## 상황
선배 개발자가 코드 리뷰를 하며 말합니다.

> "이거 for문 10줄 쓴 거... Stream 쓰면 3줄이면 되는데?
> Practice 03~06에서 했던 거 Stream으로 다시 해봐."

## 목표
- Stream API의 기본 흐름을 이해한다 (생성 → 중간연산 → 최종연산)
- `filter()`, `map()`, `count()`, `sum()` 등 핵심 메서드를 사용할 수 있다
- `collect(Collectors.groupingBy())`로 그룹핑할 수 있다
- for문 코드와 Stream 코드를 비교하며 장단점을 이해한다

## 요구사항
1. Stream으로 **바디홀릭 주문만 필터링**하여 출력하시오 (= Practice 03)
2. Stream으로 **전체 매출 합계**를 구하시오 (= Practice 05)
3. Stream으로 **상품금액 내림차순 정렬 후 상위 5건**을 출력하시오 (= Practice 06)
4. Stream으로 **브랜드별 주문 건수**를 집계하시오 (= Practice 07)
5. (추가) Stream으로 **브랜드별 매출 합계**를 한 줄로 구하시오

## 출력 예시
```
===== 1. 바디홀릭 주문 필터링 =====
[바디홀릭] 스테이누디 디스커버리 세트 (20ml*6종) - 20,000원
[바디홀릭] 스테이누디 디스커버리 세트 (20ml*6종) - 20,000원
...

===== 2. 전체 매출 합계 =====
1,264,000원

===== 3. 금액 상위 5건 =====
1. [바디홀릭] 1+1 스테이누디 바디미스트 6종 (2개) - 22,900원
2. [바디홀릭] 1+1 스테이누디 바디미스트 6종 (2개) - 22,900원
3. [바디홀릭] 1+1 다우트리스 바디미스트 3종 (2개) - 22,500원
4. [바디홀릭] 스테이누디 디스커버리 세트 - 20,000원
5. [바디홀릭] 스테이누디 디스커버리 세트 - 20,000원

===== 4. 브랜드별 주문 건수 =====
바디홀릭: 65건
머지: 9건

===== 5. 브랜드별 매출 합계 =====
바디홀릭: 1,106,400원
머지: 117,600원
```

## 힌트

### 필터링 + 출력
```java
orders.stream()
      .filter(o -> o.getBrand().equals("바디홀릭"))
      .forEach(System.out::println);
```

### 합계
```java
int total = orders.stream()
                  .mapToInt(Order::getPrice)
                  .sum();
```

### 정렬 + 상위 N건
```java
orders.stream()
      .sorted(Comparator.comparingInt(Order::getPrice).reversed())
      .limit(5)
      .forEach(System.out::println);
```

### 그룹핑 (건수)
```java
Map<String, Long> brandCount = orders.stream()
    .collect(Collectors.groupingBy(Order::getBrand, Collectors.counting()));
```

### 그룹핑 (합계)
```java
Map<String, Integer> brandTotal = orders.stream()
    .collect(Collectors.groupingBy(Order::getBrand, Collectors.summingInt(Order::getPrice)));
```

- `import java.util.stream.Collectors;`를 잊지 마세요
