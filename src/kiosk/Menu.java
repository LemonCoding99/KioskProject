package kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    // 1. 속성
    private final String category;  // 메뉴 카테고리 속성
    List<MenuItem> menuItems = new ArrayList<>(); // MenuItem 클래스 List로 관리

    // 2. 생성자
    // 메뉴 카테고리 생성자
    public Menu(String category) {
        this.category = category;
    }

    // 3. 기능
    // 카테고리 게터
    public String getCategory() {
        return category;
    }

    // 메뉴 객체 반환하기
    public MenuItem getMenuItem(int idx) {
        return menuItems.get(idx);
    }

    // 카테고리 메뉴에 맞춰 메뉴 추가해주는 함수
    public void addMenuItems(String name, int price, String info) {
        menuItems.add(new MenuItem(name, price, info));
    }

    // MenuItem 메뉴판 출력하기
    public void printMenuItems() {
        System.out.println("[ " + this.category + " ]");  // 향상된 for문 사용
        int i = 0;
        for(MenuItem menuItem : menuItems) {
            i++;
            System.out.println(i + ". " + menuItem.getName() +
                    " | W " + menuItem.getPrice() +
                    " | " + menuItem.getInfo());
        }
        System.out.println("0. 뒤로가기");
    }
}
