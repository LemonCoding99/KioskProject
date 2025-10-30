package kioskchallenge;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // 프로그램 순서 및 흐름제어 담당

    // 1. 속성
    List<Menu> categoryList;  // 카테고리 리스트 가져오기
    Scanner scanner = new Scanner(System.in); // 스캐너 선언
    Cart cart = new Cart(); // Cart 객체 추가하기

    // 2. 생성자
    public Kiosk(List<Menu> cartegoryList) {
        this.categoryList = cartegoryList;  // Main에서 전달된 menuItems를 받기
    }

    // 3. 기능
    /* start(): 메뉴출력, 사용자 입력값에 따른 매뉴 출력 및 종료 */
    public void start() {
        boolean startExit = true; // 메인루프 구분: 0이 입력되면 반복문 종료

        while (startExit) {
            printMenu(); // MAIN MENU 출력하기
            int selectedNumber = handleMenu(scanner);  // handleMenu 메서드 사용해 메뉴입력 + 예외처리

            // 문자 입력(return값 -1)일 경우 건너뛰기
            if (selectedNumber == -1) { // 쓰지 않을 경우 경고문구가 2가지 모두 출력됨!
                continue;  // 처음 루프로 돌아감
            }

            // 0: 프로그램 종료하기
            if (selectedNumber == 0) {
                System.out.println("프로그램을 종료합니다.");
                startExit = false;
            // 1~3: 카테고리 메뉴 선택하기
            } else if (0 < selectedNumber && selectedNumber <= categoryList.size()) {
                Menu selectedCategory = categoryList.get(selectedNumber -1);  // 선택한 카테고리 객체를 리스트에서 가져오기
                handleMenuItem(scanner, selectedCategory); // handleMenuItem 메서드 사용해 세부메뉴 값 가져오기
            // 4: Orders 장바구니 확인 후 주문하기
            } else if (selectedNumber == 4) {
                if (cart.isCartEmpty()) {  // 장바구니 비어 있는지 확인하기
                    System.out.println("장바구니가 비어 있습니다. 메뉴를 선택해주세요.");
                } else {  // 장바구니 비어있지 않다면 주문 메서드 실행
                    cart.handleCartOrder();
                }
            // 5: Cancel 주문 취소하기
            } else if (selectedNumber == 5) {
                if (cart.isCartEmpty()) {  // 카트가 비어있는 경우 경고문구 출력
                    System.out.println("취소할 주문이 없습니다.");
                } else {
                    cart.clearCart();
                    System.out.println("장바구니가 초기화되었습니다.");
                }
            // 번호가 잘못 입력된 경우 경고문구 출력하기
            }else {
                System.out.println("번호가 잘못 입력되었습니다. 다시 입력해주세요.");
            }
        }
    }

    /* 메뉴 출력하는 메서드 */
    public void printMenu() {
        System.out.println("[ MAIN MENU ]");
        for(int i = 0; i < categoryList.size(); i++) {
            System.out.println((i+1) + ". " + categoryList.get(i).getCategory());  // i번째 카테고리 가져오기
        }
        System.out.println(0 + ". 종료    | 종료하기");  // 0입력시 종료

        // 장바구니가 비어있지 않은 경우 ORDER MENU 출력해주기
        if (!cart.isCartEmpty()) {
            System.out.println("[ ORDER MENU ]");
            System.out.println("4. Orders  | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel  | 진행 중인 주문을 취소합니다.");
        }
    }

    /* 메뉴 입력 및 예외처리 메서드 */
    // 메뉴 출력을 2번을 반복해서 써줘야 해서 메서드로 제작함
    private int handleMenu(Scanner scanner) {
        try {
            return scanner.nextInt(); // 정수만 허용
        } catch (Exception e) {  // 예외처리: 문자열 입력시 경고문구 출력
            System.out.println("메뉴 번호만 입력하세요.");
            scanner.nextLine(); // 개행문자 제거
            return -1;  // 입력오류 발생한 경우
        }
    }

    /* MenuItems 메뉴 입력받은 숫자 판별 메서드 */
    private void handleMenuItem(Scanner scanner, Menu selectedCategory) {
        boolean menuExit = true;
        selectedCategory.printMenuItems(); // 선택된 MenuItems 메뉴판 출력
        while (menuExit) {
            int selectedNumber = handleMenu(scanner);  // 세부메뉴 입력처리
            // 문자 입력(return값 -1)일 경우 건너뛰기
            if (selectedNumber == -1) {
                continue;
            }
            // 0: 카테고리별 상세 메뉴 종료하고 카테고리 메뉴로 돌아가기
            if (selectedNumber == 0) {
                System.out.println("뒤로가기");
                menuExit = false;
            // 메뉴숫자: 입력된 카테고리별 상세 메뉴 가져와서 출력하기
            } else if ((0 < selectedNumber) && selectedNumber <= selectedCategory.menuItems.size()) {
                MenuItem selectedItem = selectedCategory.getMenuItem(selectedNumber - 1);  // 선택한 메뉴 객체 출력하기
                System.out.println("선택한 메뉴: " + selectedItem.getName() + "    | W " + selectedItem.getPrice() + " | " + selectedItem.getInfo());
                cart.askCart(selectedItem); // 카트에 추가할 지 물어보기
                menuExit = false; // 장바구니 추가 후 카테고리 메뉴로 복귀
            // 번호가 잘못 입력된 경우 경고문구 출력하기
            } else {
                System.out.println("번호가 잘못 입력되었습니다. 다시 입력해주세요.");  // 번호가 잘못 입력된 경우
            }
        }
    }
}
