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

    // 카테고리 메뉴 출력하는 함수
    public void printMenu() {
        System.out.println("[ MAIN MENU ]");
        for(int i = 0; i < categoryList.size(); i++) {
            System.out.println((i+1) + ". " + categoryList.get(i).getCategory());  // i번째 카테고리 가져오기
        }
        System.out.println(0 + ". 종료    | 종료하기");  // 0입력시 종료
    }

    // start: 메뉴출력, 사용자 입력값에 따른 매뉴 출력 및 종료
    public void start() {
        Scanner scanner = new Scanner(System.in); // 스캐너 선언

        // 카테고리 메뉴 반복문
        boolean startExit = true; // 메인루프 구분: 0이 입력되면 반복문 종료
        while (startExit) {
            printMenu(); // MAIN MENU 출력하기

            try {
                int selectedNumber = scanner.nextInt();
                scanner.nextLine();  // 개행문자 제거하기 -> 무한반복 오류 발생할 수 있음

                // 입력받은 숫자 확인하기
                if (selectedNumber == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    startExit = false;

                } else if ((0 < selectedNumber) && selectedNumber <= categoryList.size()) {
                    // 선택한 카테고리 메뉴 리스트 가져오기
                    Menu selectedCategory = categoryList.get(selectedNumber - 1);
                    selectedCategory.printMenuItems(); // 선택된 상세 메뉴판 출력하는 함수

                    // 상세메뉴 반복문
                    boolean menuExit = true;  // 서브루프 구분: 0이 입력되면 돌아가기
                    while (menuExit) {
                        try {
                            selectedNumber = scanner.nextInt(); // 메뉴 입력받기
                            scanner.nextLine(); // 개행문자 제거하기

                            if (selectedNumber == 0) {
                                System.out.println("뒤로가기"); // 0일 경우 하위 메뉴 종료하고 카테고리로 돌아가기
                                menuExit = false;

                            } else if ((0 < selectedNumber) && selectedNumber <= selectedCategory.menuItems.size()) {
                                MenuItem selectedItem = selectedCategory.getMenuItem(selectedNumber - 1);  // 선택한 메뉴 객체 출력하기
                                System.out.println("선택한 메뉴: " + selectedItem.getName() + "    | W " + selectedItem.getPrice() + " | " + selectedItem.getInfo());
                            } else {
                                System.out.println("번호가 잘못 입력되었습니다. 다시 입력해주세요.");  // 번호가 잘못 입력된 경우
                            }
                        } catch (Exception e) {
                            System.out.println("메뉴 번호만 입력하세요.");  // 숫자외의 것이 입력된 경우
                            scanner.nextLine();
                        }
                    }
                } else {
                    System.out.println("번호가 잘못 입력되었습니다. 다시 입력해주세요.");  // 번호가 잘못 입력된 경우
                }
            } catch (Exception e) {
                System.out.println("메뉴 번호만 입력하세요.");  // 숫자외의 것이 입력된 경우
            }
        }
    }
}
