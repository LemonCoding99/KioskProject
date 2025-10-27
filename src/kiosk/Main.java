package kiosk;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Menu> categoryList = new ArrayList<>();  // categoryList 리스트 선언

        // Menu 카테고리 추가하기
        Menu burgers = new Menu("Burger");
        Menu drinks = new Menu("Drinks");
        Menu desserts = new Menu("Desserts");

        // 메뉴 List에 카테고리 메뉴 추가하기
        categoryList.add(burgers);
        categoryList.add(drinks);
        categoryList.add(desserts);


        // add 함수를 통해 new MenuItem 객체를 리스트에 추가
        burgers.addMenuItems("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        burgers.addMenuItems("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        burgers.addMenuItems("CheeseBurger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        burgers.addMenuItems("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거");

        drinks.addMenuItems("Fountain Soda", 2900, "코카콜라, 코카콜라 제로, 스프라잍, 환타");
        drinks.addMenuItems("Iced Tea", 4200, "직접 유기농 홍자를 우려낸 아이스티");
        drinks.addMenuItems("Lemonade", 5000, "매장에서 직접 만드는 상큼한 레몬에이드");
        drinks.addMenuItems("Classic Shakes", 6500, "바닐라, 초코, 블랙&화이트, 스트로베리, 피넛버터");
        drinks.addMenuItems("Bottled Water", 1000, "지리산 암반대수층으로 만든 생수");

        desserts.addMenuItems("Shack Attack",5900, "초코맛의 쉐이크쉑에 대표 콘크리트");
        desserts.addMenuItems("Better 2Gether", 5900, "바닐라, 초콜릿 커스타드와 쿠키를 넣은 특별한 콘크리트");
        desserts.addMenuItems("Soft Corn",1500, "소프트 콘 아이스크림");


        // Kiosk 객체 생성, 리스트 전달
        Kiosk kiosk = new Kiosk(categoryList);  // 리스트를 Kiosk 생성자에 전달

        // 시작문구 출력하기
        System.out.println("Hello, Kiosk!");

        // Kiosk 시작하기
        kiosk.start();
    }
}
