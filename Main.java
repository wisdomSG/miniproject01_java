package miniproject01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String introduceMenu = "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n" +
                "\n" +
                "[ CAFE MENU ]\n" +
                "1. Coffee          | 에스프레소가 들어간 커피메뉴\n" +
                "2. Non-Coffee      | 에스프레소가 들어가지 않는 메뉴\n" +
                "3. Brunch          | 간단하게 즐길 수 있는 점심 메뉴\n" +
                "4. Dessert         | 빵, 케이크 등 간단한 디저트 메뉴\n" +
                "\n" +
                "[ ORDER MENU ]\n" +
                "5. Order       | 장바구니를 확인 후 주문합니다.\n" +
                "6. Cancel      | 진행중인 주문을 취소합니다.";

        System.out.println("ROUN CAFE 에 오신걸 환영합니다.");
        Scanner sc = new Scanner(System.in);
        String orderNum = "";
        Menu menu = new Menu();
        menu.coffee();
        while(!orderNum.equals("0")) {
            System.out.println(introduceMenu); // 첫번째 메뉴판 보여주기
            orderNum = sc.nextLine();
            switch (orderNum) {
                case "1":
                    menu.burgerList();
                    break; //break안하는 바보는 어딨을까
                case "5":
                    menu.getOrderList();
                    System.out.println();
                    System.out.println("1. 주문    2. 메뉴판 ");
                    break;
            }
            String choiceNum = sc.nextLine();

            menu.burgerChoice(choiceNum);

            System.out.println("위 메뉴를 장바구니에 추가하겠습니까? 1. 확인 2. 취소");

            String checkNum = sc.nextLine();

            if (checkNum.equals("1")) {
                menu.saveChoice(choiceNum);
                continue;
            }
            else if (checkNum.equals("2")) {
                continue;
            }
        }
    }
}
