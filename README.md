# Java 2026 실습 프로젝트
실제 쇼핑몰 주문 데이터(개인정보 제거)를 활용한 Java 실습 프로젝트입니다.  
배열, 리스트, 조건문, 정렬 등 핵심 문법을 단계별로 학습합니다.

## 디렉터리 구조
```
java-2026
├── README.md
├── resources/
│   └── orders.csv              # 실습 데이터 (74건, 개인정보 제거)
├── src/
│   ├── model/
│   │   └── Order.java          # 주문 데이터 클래스
│   ├── data/
│   │   └── OrderDataProvider.java  # 데이터 로딩 (수정 불필요)
│   ├── practice01/             # 주문 데이터 확인하기
│   ├── practice02/             # 전체 주문 한눈에 보기
│   ├── practice03/             # 조건에 맞는 주문 찾기
│   ├── practice04/             # 주문이 계속 들어온다 (ArrayList)
│   ├── practice05/             # 매출 보고서 만들기
│   └── practice06/             # 출고 우선순위 정하기 (정렬)
└── docs/
```

## 실습 진행 순서

| 단계 | 폴더 | 주제 | 핵심 개념 |
|------|------|------|-----------|
| 1 | practice01 | 주문 데이터 확인하기 | 객체 생성, getter, println |
| 2 | practice02 | 전체 주문 한눈에 보기 | 배열, for문, for-each |
| 3 | practice03 | 조건에 맞는 주문 찾기 | 배열 + if 조건 필터링 |
| 4 | practice04 | 주문이 계속 들어온다 | ArrayList, add/remove |
| 5 | practice05 | 매출 보고서 만들기 | 집계, 그룹핑 |
| 6 | practice06 | 출고 우선순위 정하기 | Comparable, Comparator, 정렬 |
| 7 | practice07 | 브랜드별 집계를 깔끔하게 | HashMap, Key-Value, getOrDefault |
| 8 | practice08 | 한 줄로 끝내기 | Stream API, filter, map, collect |

## 빠른 시작
1. IntelliJ에서 `File > Open`으로 이 폴더를 엽니다.
2. JDK 17 이상을 설정합니다.
3. 각 practice 폴더의 `README.md`를 읽고 요구사항을 확인합니다.
4. `Main.java`의 TODO 부분을 작성하고 실행합니다.

## 데이터 설명
`resources/orders.csv`에는 카카오 선물하기 채널의 주문 74건이 들어 있습니다.

| 필드 | 설명 | 예시 |
|------|------|------|
| 주문번호 | 고유 주문 ID | 2596171645 |
| 상품명 | 주문 상품 이름 | 바디홀릭 스테이누디 디스커버리 세트 |
| 옵션 | 선택 옵션 | 향: 그래시 튤립 |
| 수량 | 주문 수량 | 1 |
| 브랜드 | 상품 브랜드 | 바디홀릭, 머지 |
| 상품금액 | 가격 (원) | 20000 |
| 주문일 | 주문 일시 | 2024-08-27 16:53:41 |
| 주문상태 | 배송 상태 | 301 배송 준비 중 |
| 배송지역 | 시/도 단위 | 경기 안산시 |

## 주의사항
- `data/OrderDataProvider.java`는 수정하지 마세요.
- IntelliJ에서 실행 시 Working Directory가 프로젝트 루트로 설정되어야 합니다.
- 각 practice의 `README.md`에 상세 요구사항과 힌트가 있습니다.
