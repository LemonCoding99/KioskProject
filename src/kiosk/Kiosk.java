package kiosk;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);
    // 프로그램 순서 및 흐름제어 담당

    // 1. 속성
    List<MenuItem> menuItems;  // MenuItem 리스트를 Kiosk의 필드로 추가

    // 2. 생성자
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;  // Main에서 전달된 menuItems를 받기
    }

    // 3. 기능
    // 메뉴 출력하기
    // burgerMenu: Burger 메뉴 출력하기
    public void burgerMenu() {
        for(int i = 0; i < menuItems.size(); i++) {
            MenuItem selectedBurger = menuItems.get(i);
            System.out.println((i+1) + ". " + selectedBurger.burgerName + " |  " + selectedBurger.burgerPrice + " | " + selectedBurger.burgerInfo);
        }
        System.out.println(0 + ". 종료 | 프로그램 종료");  // 종료는 종료문구 따로 출력
    }

    // start: 메뉴출력, 사용자 입력값에 따른 매뉴 출력 및 종료
    public void start() {
        burgerMenu(); // Burger 메뉴 출력

        // 사용자 입력받고 출력값 지정하기
        while (true) {
            // 숫자 입력받기
            int number =scanner.nextInt();

            // 입력값에 따른 출력값 지정하기
            // 1. 입력값이 0일 경우 프로그램 종료하기
            if (number == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            // 2. 입력값이 0보다 큰 경우 번호에 맞는 burger 정보 출력하기
            if ((number > 0) && (number <= menuItems.size())) {
                MenuItem selectedBurger = menuItems.get(number - 1);// 리스트의 (number-1)번째 요소 가져오기
                System.out.println((selectedBurger.burgerName + " | W " + selectedBurger.burgerPrice + " | " + selectedBurger.burgerInfo));
            } else {  // 리스트에 있는 번호가 입력되지 않은 경우 재입력 요청하기
                System.out.println("번호가 잘못 입력되었습니다. 다시 입력해주세요."); // 버거 리스트의 범위값을 넘어갔을 경우 재입력 요청
            }
        }
    }









}
