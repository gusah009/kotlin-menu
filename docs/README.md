## 기능 구현 사항

- [x] 메뉴 추천을 받을 코치의 이름을 입력 받는 기능
- [x] 코치가 못 먹는 메뉴를 입력 받는 기능
- [x] 서비스 시작 문구를 출력해주는 기능
- [x] 요일별 카테고리 추천하는 기능
- [x] 각 코치에게 한 주에 중복되지 않는 메뉴를 추천해주는 기능
- [x] 서비스 종료 문구와 결과를 출력해주는 기능

## 제약 사항

1. 메뉴 추천을 받을 코치의 이름을 입력 받는 기능
    - min name count 2, max name count 4
    - min person count 2, max person count 5
2. 코치가 못 먹는 메뉴를 입력 받는 기능
    - print "토미(이)가 못 먹는 메뉴를 입력해 주세요."
    - seperator : ,
    - min 0, max 2
3. 서비스 시작 문구를 출력해주는 기능
    - print "점심 메뉴 추천을 시작합니다."
4. 서비스 종료 문구를 출력해주는 기능
    - print """
      메뉴 추천 결과입니다.
      [ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]
      [ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]
      [ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]
      [ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]
      [ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]
      추천을 완료했습니다.
      """
5. 에러 출력
    - error prefix: "[ERROR]"