package kioskchallenge;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // 프로그램 순서 및 흐름제어 담당

    // 1. 속성
    List<Menu> categoryList;

    // 2. 생성자
    public Kiosk(List<Menu> cartegoryList) {
        this.categoryList = cartegoryList;  // Main에서 전달된 menuItems를 받기
    }

    // 3. 기능
    // start(): 메뉴출력, 사용자 입력값에 따른 매뉴 출력 및 종료
    public void start() {
        Scanner scanner = new Scanner(System.in); // 스캐너 선언
        boolean startExit = true; // 메인루프 구분: 0이 입력되면 반복문 종료

        while (startExit) {
            printMenu(); // MAIN MENU 출력하기
            int selectedNumber = handleCategoryMenu(scanner);  // handleCategoryMenu 메서드 사용해 입력받은 값 가져오기

            // 문자 입력(return값 -1)일 경우 건너뛰기
            if (selectedNumber == -1) {
                continue;  // 쓰지 않을 경우 경고문구가 2가지 모두 출력됨!
            }

            // 카테고리 메뉴 0인 경우 프로그램 종료하기
            if (selectedNumber == 0) {
                System.out.println("프로그램을 종료합니다.");
                startExit = false;
            // 입력받은 카테고리 메뉴 출력하기
            } else if (0 < selectedNumber && selectedNumber <= categoryList.size()) {
                Menu selectedCategory = categoryList.get(selectedNumber -1);
                handleMenuItem(scanner, selectedCategory); // handleMenuItem 메서드 사용해 세부메뉴 값 가져오기
            // 번호가 잘못 입력된 경우 경고문구 출력하기
            } else {
                System.out.println("번호가 잘못 입력되었습니다. 다시 입력해주세요.");
            }
        }
    }

    // Category 메뉴 출력하는 메서드
    public void printMenu() {
        System.out.println("[ MAIN MENU ]");
        for(int i = 0; i < categoryList.size(); i++) {
            System.out.println((i+1) + ". " + categoryList.get(i).getCategory());  // i번째 카테고리 가져오기
        }
        System.out.println(0 + ". 종료    | 종료하기");  // 0입력시 종료
    }

    // Category 메뉴 입력 및 예외처리 메서드
    private int handleCategoryMenu(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {  // 예외처리: 문자열 입력시 경고문구 출력
            System.out.println("메뉴 번호만 입력하세요.");
            scanner.nextLine(); // 개행문자 제거
            return -1;  // 입력오류 발생한 경우
        }
    }

    // MenuItems 메뉴 입력받은 숫자 판별 메서드
    private void handleMenuItem(Scanner scanner, Menu selectedCategory) {
        boolean menuExit = true;
        selectedCategory.printMenuItems(); // 선택된 MenuItems 메뉴판 출력
        while (menuExit) {
            int selectedNumber = handleCategoryMenu(scanner);  // 세부메뉴 입력처리
            // 문자 입력(return값 -1)일 경우 건너뛰기
            if (selectedNumber == -1) {
                continue;
            }
            // 0이 입력된 경우 카테고리별 상세 메뉴 종료하고 카테고리 메뉴로 돌아가기
            if (selectedNumber == 0) {
                System.out.println("뒤로가기");
                menuExit = false;
            // 입력된 카테고리별 상세 메뉴 가져와서 출력하기
            } else if ((0 < selectedNumber) && selectedNumber <= selectedCategory.menuItems.size()) {
                MenuItem selectedItem = selectedCategory.getMenuItem(selectedNumber - 1);  // 선택한 메뉴 객체 출력하기
                System.out.println("선택한 메뉴: " + selectedItem.getName() + "    | W " + selectedItem.getPrice() + " | " + selectedItem.getInfo());
            // 번호가 잘못 입력된 경우 경고문구 출력하기
            } else {
                System.out.println("번호가 잘못 입력되었습니다. 다시 입력해주세요.");  // 번호가 잘못 입력된 경우
            }
        }
    }
}
