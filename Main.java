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
                "5. Order           | 장바구니를 확인 후 주문합니다.\n" +
                "6. Cancel          | 진행중인 주문을 취소합니다.";

        System.out.println("ROUN CAFE 에 오신걸 환영합니다.");
        Scanner sc = new Scanner(System.in);
        int orderNum;
        int count = 0;
        int setNum = 0;
        Menu menu = new Menu();
        menu.menuAll();
        while (true) {
            System.out.println(introduceMenu); // 첫번째 메뉴판 보여주기
            System.out.print("1번에서 6번까지의 숫자를 입력해주세요 >> ");
            orderNum = sc.nextInt();
            menu.setMenuList(orderNum);
            switch (orderNum) {
                case 0:
                    menu.getTotal();
                    System.out.println("1. 돌아가기");
                    int managerNum = sc.nextInt();
                    if (managerNum == 1) {
                        continue;
                    }
                case 1,2,3,4:
                    menu.getMenuList();
                    break;
                case 5:
                    menu.getOrderList();
                    System.out.println();
                    System.out.println("1. 주문    2. 메뉴판 ");
                    System.out.print("1번 또는 2번을 입력해주세요 >>");
                    int orderCheck = sc.nextInt();
                    if (orderCheck == 1) {
                        System.out.println("주문이 완료되었습니다!");
                        System.out.println();
                        count += 1;
                        System.out.printf("대기번호 [ %d ] 번 입니다.%n", count);
                        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
                        try {
                            Thread.sleep(3000);
                            menu.setTotal();
                            continue;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else if (orderCheck == 2) {
                        continue;
                    }
                    break;
                case 6:
                    System.out.println("진행하던 주문을 취소하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");
                    int cancelNum = sc.nextInt();
                    if (cancelNum == 1) {
                        Order.listClear();
                        continue;
                    }
                    else if (cancelNum == 2) {
                        continue;
                    }
                    break;
            }

            if (orderNum >=1 && orderNum <= 4) {
                int choiceNum = sc.nextInt();
                menu.burgerChoice(choiceNum);

                if (orderNum == 3) {
                    System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
                    System.out.println("Double은 아메리카노가 포함된 옵션이며 3.0추가시 이용가능합니다.");
                    System.out.println("1. Single    2. Double(+3.0)");
                    setNum = sc.nextInt();
                }

                System.out.println("위 메뉴를 장바구니에 추가하겠습니까? 1. 확인 2. 취소");

                int checkNum = sc.nextInt();

                if (checkNum == 1) {
                    if (setNum == 2) {
                        menu.setOrderPlusList(choiceNum);
                        continue;
                    }
                    menu.setOrderList(choiceNum);
                    continue;
                }
                else if (checkNum == 2) {
                    continue;
                }
            }

        }
    }
}
