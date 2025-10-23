package kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>(); // 리스트 선언
        Scanner scanner = new Scanner(System.in);

        // 시작문구 출력하기
        System.out.println("Hello, Kiosk!");

        // add 함수를 통해 new MenuItem 객체를 리스트에 추가
        menuItems.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("CheeseBurger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Kiosk 객체 생성, menuItems 리스트 전달
        Kiosk kiosk = new Kiosk(menuItems);  // menuItems 리스트를 Kiosk 생성자에 전달

        // Kiosk 시작하기
        kiosk.start();
    }
}
