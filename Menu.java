package miniproject01;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

    static ArrayList<Shop> coffeeList = new ArrayList<>();

    static ArrayList<Shop> nonCoffeeList = new ArrayList<>();

    static ArrayList<Order> orderList = new ArrayList<>();

    String name;
    String description;


    public Menu() {};

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

    void nonCoffee() {
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

    }

    void dessert() {

    }
    void coffeeList () {
        for (int i=0 ; i < coffeeList.size(); i++) {
            Shop coffee = coffeeList.get(i);
            System.out.print(i+1 + ". 메뉴명: " + String.format("%-17s",coffee.getName()));
            System.out.print("| 가격: $ " + coffee.getPrice());
            System.out.println(" | 설명: " + coffee.getDescription());
        }
    }
    void burgerChoice (int num) { //선택한 버거 보여주기
        Shop menu = coffeeList.get(num - 1);
        System.out.println(menu.getAll());
    }
    void saveChoice (int num) {
        Shop menu = coffeeList.get(num - 1);
        Order order = new Order(menu.getName(), menu.getPrice(), menu.getDescription());
        orderList.add(0, order);
        System.out.println(menu.getAll() );
        System.out.println(menu.getName() + "가 장바구니에 추가되었습니다.");
        System.out.println();
    }


    void getOrderList () {
        System.out.println("[ORDER LIST]");
        for (Order num: orderList)
            System.out.println(num.getAll());
        System.out.println();
        System.out.println("[TOTAL]");
        double totalPrice = Order.totalPrice();
        System.out.println("W " + totalPrice);
    }
}
