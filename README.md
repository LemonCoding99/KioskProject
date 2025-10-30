# Kiosk Projecgt

## 프로젝트 소개(OverView)
이 프로젝트는 java17을 사용하여 필수기능(Lv1-Lv5)과 도전기능(Lv1-Lv2)으로 기능을 확장하여 발전시킨 콘솔 기반 메뉴 키오스크 프로그램입니다.
현재 문서는 도전과제 Lv1까지를 기준으로 작성되었으며, 클래스를 활용하여 제작되었습니다.
필수기능에서는 기본적인 메뉴선택 및 출력기능을 수행할 수 있습니다. 
도전기능에서는 메뉴를 선택하여 장바구니에 추가 및 삭제 결제할 수 있습니다.


## 2. 개발기간(Period)
2025.10.21 ~ 25.10.29


## 3. 개발 환경(Environment)
- 개발 언어: Java
- JDK 버전: 17
- 개발 툴: IntelliJ IDEA


## 4. 구현한 기능 목록(Feature)
### 1) 필수과제
- 사용자 입력 기능: 콘솔에서 메뉴판의 번호를 보고 숫자를 입력받습니다.
- 메뉴판 출력 기능: 사용자가 선택한 번호의 메뉴 이름, 가격, 정보를 출력합니다.
- 종료 기능: 0을 입력하면 프로그램이 종료됩니다.
- 예외처리: 메뉴판에 있지 않는 숫자 입력하는 경우, 문자를 입력하는 경우 예외처리할 수 있습니다.

### 2) 필수과제
- 사용자 입력 기능: 콘솔에서 메뉴판의 번호를 보고 숫자를 입력받습니다.
- 메뉴판 출력 기능: 사용자가 선택한 번호의 메뉴 이름, 가격, 정보를 출력합니다.
- 종료 기능: 0을 입력하면 프로그램이 종료됩니다.
- 예외처리: 메뉴판에 있지 않는 숫자 입력하는 경우, 문자를 입력하는 경우 예외처리할 수 있습니다.
- 장바구니 추가 기능: 메뉴를 선택하면 장바구니에 추가할 지 묻고 추가하거나 취소할 수 있습니다.
- 장바구니 삭제 기능: 장바구니에 넣어두었던 메뉴들을 한 번에 삭제할 수 있습니다.
- 장바구니 메뉴 금액 계산 기능: 장바구니에 넣어둔 메뉴들의 총합 가격을 계산할 수 있습니다.

## 5. 프로젝트 구조(Project Structure)
<img width="310" height="302" alt="image" src="https://github.com/user-attachments/assets/bbdc233e-dd17-4410-b92c-663c9fb81998" />

## 6. 사용 방법(Usage)
1) IntelliJ IDEA를 실행합니다.
2) 이 프로젝트폴더('Kiosk')를 엽니다.
3) 왼쪽 프로젝트 창에서 'Main.java' 파일을 선택하고 우측 상단의 'Run' 버튼을 클릭합니다.
4) 하단 콘솔 창이 열리면 메뉴 번호를 입력하여 사용할 수 있습니다.


## 7. 구현 예시(Example)
kioskchallenge가 kiosk를 포함하는 더 상위버전이므로 kioskchallenge버전으로 구현예시를 작성하였습니다.
1) 카테고리 메인메뉴 입력받기
<img width="685" height="358" alt="image" src="https://github.com/user-attachments/assets/d987a5c3-1b81-473a-a8b5-eaa45448f8a5" />

2) 카테고리별 상세메뉴 입력받기(0입력시 카테고리 메인메뉴로 돌아감)
<img width="750" height="275" alt="image" src="https://github.com/user-attachments/assets/ae56f2ef-93c8-41d8-a07f-e6c5fabcc674" />
<img width="676" height="357" alt="image" src="https://github.com/user-attachments/assets/5a810574-d08f-467c-847a-6c4ccbae8789" />

3) 선택한 메뉴 장바구니에 추가하기
<img width="747" height="382" alt="image" src="https://github.com/user-attachments/assets/0dafdac8-e3c8-4c24-b701-4025e3b719f5" />

4) 선택한 메뉴 장바구니에 추가하지 않기
<img width="787" height="303" alt="image" src="https://github.com/user-attachments/assets/49991ea7-c47c-4832-90fb-04bd05954538" />

5) 장바구니 확인 후 주문하기
<img width="673" height="438" alt="image" src="https://github.com/user-attachments/assets/073d7317-992e-4a1f-9d16-a5b88cbc18c9" />

6) 진행중인 주문 취소하기
<img width="525" height="468" alt="image" src="https://github.com/user-attachments/assets/99aaa6e9-6b7a-423e-86d1-398b412bce84" />

7) 주문메뉴와 최종 가격 확인 후 주문하기
<img width="691" height="227" alt="image" src="https://github.com/user-attachments/assets/fa593f19-1d79-4f07-9d56-b1abd1589f47" />

8) 주문메뉴와 최종 가격 확인 후 메뉴 추가하기 위해 메뉴판으로 돌아가기
<img width="600" height="415" alt="image" src="https://github.com/user-attachments/assets/83b9be33-8fb8-4dc3-883b-7eef32a75c24" />

9) 0입력시 종료하기
<img width="392" height="275" alt="image" src="https://github.com/user-attachments/assets/7ab3cf54-66fe-4628-811d-bd0290ee522d" />

10) 메뉴 외의 숫자가 입력된 경우 예외처리 하기
<img width="573" height="333" alt="image" src="https://github.com/user-attachments/assets/c3b8d462-a87d-4059-958b-82f0c3348a0b" />

11) 문자가 입력된 경우 예외처리 하기
<img width="432" height="327" alt="image" src="https://github.com/user-attachments/assets/7995ff90-e784-46a5-bc26-b50ba7e64b48" />

## 8. 키오스크 구조 다이어그램
<img width="1774" height="1086" alt="키오스크 다이어그램(점선x)" src="https://github.com/user-attachments/assets/d8d6f242-52a7-44ee-a5e8-720544796a0a" />


