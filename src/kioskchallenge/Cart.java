package kioskchallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {

    // 속성
    List<MenuItem> cart = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    // 생성자

    // 기능

    /* 장바구니 주문 관리 메서드 */
    public void handleCartOrder() {
        if (isCartEmpty()) {
            System.out.println("장바구니가 비어 있습니다. 주문할 수 없습니다.");
            return;
        }

        printCart(); // 장바구니 출력하는 메서드 가져오기
        System.out.println("1. 주문   2. 메뉴판");

        // 주문 / 메뉴판 판별하기
        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                // 1. 주문  2. 메뉴판 선택하기
                if (choice == 1) {
                    System.out.println("주문이 완료되었습니다. 금액은 W " + getTotalPrice() + "입니다.");
                    clearCart();  // 주문이 완료된 경우 카트 비우기
                    break;
                } else if (choice == 2) {
                    System.out.println("메뉴판으로 돌아갑니다.");  // 메뉴판으로 돌아가기
                    break;
                } else {
                    System.out.println("번호가 잘못 입력되었습니다. 다시 입력해주세요.");  // 메뉴번호가 아닌 숫자 입력된 경우 경고문구 출력
                }
            } catch (Exception e) {
                System.out.println("메뉴 번호만 입력하세요.");  // 문자열 입력된 경우 예외처리
            }
        }
    }

    /* 장바구니 추가 여부 묻는 메서드 */
    public void askCart(MenuItem item) {
        boolean cartExit = true;
        while (cartExit) {
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인     2. 취소");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) { // 1: 확인
                    addMenuItem(item);  // 장바구니에 추가하는 메서드
                    cartExit = false;
                } else if (choice == 2) {  // 2: 취소
                    System.out.println("취소되었습니다."); // 메뉴 장바구니에 추가하지 않음
                    cartExit = false;
                } else {  // 번호가 잘못 입력된 경우
                    System.out.println("번호가 잘못 입력되었습니다. 다시 입력해주세요.");
                }
            } catch (Exception e) {  // 문자가 입력된 경우 예외처리
                System.out.println("숫자만 입력하세요.");
                scanner.nextLine(); // 입력 버퍼 초기화
            }
        }
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
    }

    /* 장바구니에 메뉴추가하는 메서드 */
    public void addMenuItem(MenuItem item) {
        cart.add(item);
        System.out.println(item.getName() + "이(가) 장바구니에 추가되었습니다.");
    }

    /* 장바구니 비어있는지 확인하는 메서드 */
    public boolean isCartEmpty() {
        return cart.isEmpty();
    }

    /* 장바구니 출력하는 메서드 */
    public void printCart() {
        System.out.println("[ Orders ]");
        for (MenuItem item : cart) {
            System.out.println(item.getName() + " | W" + item.getPrice() + " | " + item.getInfo());
        }
        System.out.println("[ Total ]");
        System.out.println("W " + getTotalPrice());  // 총 금액 가져오기
    }

    /* 총 금액 계산 메서드 */
    public int getTotalPrice() {
        int total = 0;
        for (MenuItem item : cart) {
            total += item.getPrice();
        }
        return total;
    }

    /* 장바구니 비우기 메서드 */
    public void clearCart() {
        cart.clear();
    }
}
