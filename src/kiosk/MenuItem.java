package kiosk;

import java.util.List;

class MenuItem {
    // 햄버거의 이름, 가격 설명

    // 1. 속성
    private String name;
    private int price;
    private String info;

    // 2. 생성자
    MenuItem(String name, int price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    // 3. 기능
    // 게터
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getInfo() {
        return info;
    }
}