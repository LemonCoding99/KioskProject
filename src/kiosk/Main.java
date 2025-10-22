package kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<MenuItem>(); // 리스트 선언
        Scanner scanner = new Scanner(System.in);

        // 시작문구 출력하기
        System.out.println("Hello, Kiosk!");

        // 새로운 burger 객체 생성
        MenuItem shackBurger = new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem smokeShack = new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거" );
        MenuItem cheeseBurger = new MenuItem("CheeseBurger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem hamBurger = new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거");

        // menuItems 리스트에 burger 이름, 가격, 설명 추가하기
        menuItems.add(shackBurger);
        menuItems.add(smokeShack);
        menuItems.add(cheeseBurger);
        menuItems.add(hamBurger);

        // 메뉴 출력하기
        for(int i = 0; i < menuItems.size(); i++) {
            MenuItem burgerItem = menuItems.get(i);
            System.out.println((i+1) + ". " + burgerItem.burgerName + " | W " + burgerItem.burgerPrice + " | " + burgerItem.burgerInfo);
        }
        System.out.println(0 + ". 종료 | 프로그램 종료");  // 종료는 종료문구 따로 출력


        // 사용자 입력받고 출력값 지정하기
        while (true) {
            // 숫자 입력받기
            int number =scanner.nextInt();

            // 입력값에 따른 출력값 지정하기
            switch (number) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                case 1:
                    System.out.println("ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                    break;
                case 2:
                    System.out.println("SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                    break;
                case 3:
                    System.out.println("Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                    break;
                case 4:
                    System.out.println("Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                    break;
            }

        }
    }
}
