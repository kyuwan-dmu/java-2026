# Practice 07 — 브랜드별 집계를 깔끔하게 (Map)

## 상황
팀장님이 Practice 05에서 만든 보고서를 보고 말합니다.

> "브랜드가 2개라 그때는 됐는데, 앞으로 브랜드 10개 20개 추가되면
> 매번 변수 따로 만들 거야? 자동으로 묶이게 바꿔봐."

## 목표
- `HashMap`을 선언하고 사용할 수 있다
- Key-Value 구조를 이해한다
- Map을 순회하며 데이터를 출력할 수 있다
- `getOrDefault()`를 사용하여 안전하게 값을 누적할 수 있다

## 요구사항
1. `Map<String, Integer>`를 사용하여 **브랜드별 주문 건수**를 집계하시오
2. `Map<String, Integer>`를 사용하여 **브랜드별 매출 합계**를 집계하시오
3. `Map<String, Integer>`를 사용하여 **지역별 주문 건수**를 집계하시오
4. 각 Map의 내용을 보기 좋게 출력하시오
5. (추가) **상품명별 주문 건수** 상위 3개를 출력하시오

## 출력 예시
```
===== 브랜드별 주문 건수 =====
바디홀릭: 65건
머지: 9건

===== 브랜드별 매출 =====
바디홀릭: 1,106,400원
머지: 117,600원

===== 지역별 주문 건수 =====
경기: 12건
서울: 8건
부산: 7건
경북: 6건
인천: 5건
...

===== 인기 상품 TOP 3 =====
1. 스테이누디 디스커버리 세트 (20ml*6종): 37건
2. 스테이누디 라인 바디미스트 6종: 16건
3. 다우트리스 바디미스트 3종: 3건
```

## 힌트
- Map 선언: `Map<String, Integer> brandCount = new HashMap<>();`
- 값 누적: `brandCount.put(brand, brandCount.getOrDefault(brand, 0) + 1);`
- Map 순회:
  ```java
  for (Map.Entry<String, Integer> entry : brandCount.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue() + "건");
  }
  ```
- `import java.util.HashMap;`과 `import java.util.Map;`이 필요합니다
- (추가) 상위 3개를 구하려면 Map의 값을 기준으로 정렬이 필요합니다
  - List로 변환 후 정렬하는 방법을 떠올려보세요
