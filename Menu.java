package miniproject01;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

    static ArrayList<Shop> coffeeList = new ArrayList<>();

    static ArrayList<Shop> nonCoffeeList = new ArrayList<>();

    static ArrayList<Shop> brunchList = new ArrayList<>();
    static ArrayList<Shop> dessertList = new ArrayList<>();

    static ArrayList<Shop> menuList = new ArrayList<>();

    static ArrayList<Order> orderList = new ArrayList<>();
    static ArrayList<Manager> managerList = new ArrayList<>();

    String name;
    String description;


    public Menu() {
    }

    ;

    void menuAll() {
        coffee();
        noncoffee();
        brunch();
        dessert();
    }

    void coffee() {
        Shop coffee1 = new Shop("Americano", 4.0, "최상급 원두의 신선한 풍미가 가득한 아메리카노");
        Shop coffee2 = new Shop("CafeLatte", 5.0, "고소한 풍미와 극강의 부드러움을 선사하는 카페라떼");
        Shop coffee3 = new Shop("CreamLatte", 6.0, "달콤한 크림과 어우러진 카페라떼");
        Shop coffee4 = new Shop("IceCreamLatte", 6.5, "바닐라아이스크림과 어우러진 아이스크림라떼");

        coffeeList.add(0, coffee1);
        coffeeList.add(1, coffee2);
        coffeeList.add(2, coffee3);
        coffeeList.add(3, coffee4);
    }

    void noncoffee() {
        Shop noncoffee1 = new Shop("StrawberryLatte", 6.0, "딸기가 내 입안으로 한가득 딸기라떼");
        Shop noncoffee2 = new Shop("BananaLatte", 6.0, "바나나가 내 입안으로 한가득 바나나라떼");
        Shop noncoffee3 = new Shop("MilkTeaLatte", 5.5, "홍차의 은은한 향과 부드러운 우유가 어우러진 음료");
        Shop noncoffee4 = new Shop("EarlGreyTea", 4.0, "홍차의 진한 향과 본연의 부드러움을 담은 음료");

        nonCoffeeList.add(0, noncoffee1);
        nonCoffeeList.add(1, noncoffee2);
        nonCoffeeList.add(2, noncoffee3);
        nonCoffeeList.add(3, noncoffee4);
    }

    void brunch() {
        Shop brunch1 = new Shop("BaguetteSandwich", 12.0, "게란과 양파와 어우러져 고소한 샌드위치");
        Shop brunch2 = new Shop("TruffleCreamPasta", 17.0, "트러플오일과 크림이 만나 꾸덕한 크림파스타");
        Shop brunch3 = new Shop("SundryBasilPasta", 15.0, "절인 토마토와 바질로 만든 오일파스타");
        Shop brunch4 = new Shop("BulgogiSalad", 10.0, "한끼 식사 대용으로 불고기와 함께 어우러진 샐러드");

        brunchList.add(0, brunch1);
        brunchList.add(1, brunch2);
        brunchList.add(2, brunch3);
        brunchList.add(3, brunch4);
    }

    void dessert() {
        Shop dessert1 = new Shop("HoneyCocoaCake", 5.5, "달콤한 꿀베이스에 코코아가 어우러진 달콤, 꾸덕 케이크");
        Shop dessert2 = new Shop("HoneyCinamonCake", 5.5, "달콤한 꿀베이스에 시나몬이 어우러진 달콤, 향긋, 꾸덕 케이크");
        Shop dessert3 = new Shop("CreamcheesWhinanci", 2.8, "새콤달콤 짤쪼롬의 조화");
        Shop dessert4 = new Shop("SaltBread", 3.3, "풍미, 고소, 겉바속촉");

        dessertList.add(0, dessert1);
        dessertList.add(1, dessert2);
        dessertList.add(2, dessert3);
        dessertList.add(3, dessert4);
    }

    void setMenuList(int menuNum) {
        switch (menuNum) {
            case 1:
                menuList = coffeeList;
                break;
            case 2:
                menuList = nonCoffeeList;
                break;
            case 3:
                menuList = brunchList;
                break;
            case 4:
                menuList = dessertList;
        }
    }


    void getMenuList(int num) { // 메뉴리스트를 보여주는 메서드
        System.out.println();
        switch (num) {
            case 1:
                System.out.println("[COFFEE MENU");
                break;
            case 2:
                System.out.println("[NON-COFFEE MENU]");
                break;
            case 3:
                System.out.println("[BRUNCH MENU]");
                break;
            case 4:
                System.out.println("[DESSERT MENU]");
                break;
        }
        for (int i = 0; i < menuList.size(); i++) {
            Shop menu = menuList.get(i);
            System.out.print((i + 1) + ". 메뉴명: " + String.format("%-18s", menu.getName()) + "|");
            System.out.print(" 가격: W " + menu.getPrice());
            System.out.println(" | 설명: " + menu.getDescription());
        }
        System.out.println();
    }

    void getChoice(int num) { //선택한 음식 보여주기
        Shop menu = menuList.get(num - 1);
        System.out.println(menu.getAll());
    }


    void setOrderList(int num) { // 선택한 메뉴를 orderlist에 저장
        Shop menu = menuList.get(num - 1);
        int count = 1;
        boolean doubleCheck = true; // 저장된 리스트인지 확인하기 위한 불린값

        for (Order order : orderList) { // 똑같은 이름의 리스트가 있으면 count + 1
            if (order.getName().equals(menu.getName())) {
                order.setCount();
                doubleCheck = false;
                break;
            }
        }

        if (doubleCheck) {  //똑같은 이름의 리스트가 없는 경우 실행
            Order newOrder = new Order(menu.getName(), menu.getPrice(), 1, menu.getDescription());
            orderList.add(0, newOrder);
        }

        System.out.println(menu.getAll());
        System.out.println(menu.getName() + "가 장바구니에 추가되었습니다.");
        System.out.println();
    }

    void setOrderPlusList(int num) { // Double메뉴를 선택할 경우 실행할 메서드
        Shop menu = menuList.get(num - 1);
        int count = 1;
        boolean doubleCheck = true;
        String newName = menu.getName() + "(Double)";
        double newPrice = menu.getPrice() + 3;
        for (Order order : orderList) {
            if (order.getName().equals(newName)) {
                order.setCount();
                doubleCheck = false;
                break;
            }
        }

        if (doubleCheck) {
            Order newOrder = new Order(newName, newPrice, count, menu.getDescription());
            orderList.add(0, newOrder);
        }
        Order orderMenu = orderList.get(0);
        System.out.println(orderMenu.getAll());
        System.out.println(newName + "가 장바구니에 추가되었습니다.");
        System.out.println();
    }

    void getOrderList() { // 주문목록 보여주는 메서드
        System.out.println("[ORDER LIST]");
        for (Order num : orderList)
            System.out.println(num.getAll());
        System.out.println();
        System.out.println("[TOTAL]");
        double totalPrice = Order.totalPrice();
        System.out.println(" W " + totalPrice);
    }

    void setTotalList() { // 주문완료한 메뉴를 manageList에 저장하는 메서드
        for (Order number : orderList) {
            Manager manager = new Manager(number.getName(), number.getPrice(), number.count, number.getDescription());
            managerList.add(0, manager);
        }
    }

    void getTotalList() { // manageList 를 보여주는 메서드
        for (Manager num : managerList)
            System.out.println(num.getAll());
        System.out.println();
        System.out.println("[Total]");
        System.out.println(Manager.totalPrice());
    }
}

