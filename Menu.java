package miniproject01;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

    static ArrayList<Shop> menuList = new ArrayList<>();

    static ArrayList<Order> orderList = new ArrayList<>();

    String name;
    String description;


    public Menu() {};

    void bugger() {
        Shop menu1 = new Shop("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        Shop menu2 = new Shop("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        Shop menu3 = new Shop("Shroom Burger", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거");
        Shop menu4 = new Shop("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");

        menuList.add(0, menu1);
        menuList.add(1, menu2);
        menuList.add(2, menu3);
        menuList.add(3, menu4);


    }
    void burgerList () {
        for (Shop bugger : menuList) {
            System.out.println("메뉴명: " + bugger.getName());
            System.out.println("가격: $" + bugger.getPrice());
            System.out.println("설명: " + bugger.getDescription());
            System.out.println();
        }
    }
    void burgerChoice (String num) { //선택한 버거 보여주기
        int number = Integer.parseInt(num);
        Shop menu = menuList.get(number - 1);
        System.out.println(menu.getAll() );


    }
    void saveChoice (String num) {
        int number = Integer.parseInt(num);
        Shop menu = menuList.get(number - 1);
        Order order = new Order(menu.getName(), menu.getPrice(), menu.getDescription());
        orderList.add(0, order);
        System.out.println(menu.getAll() );
        System.out.println(menu.getName() + "가 장바구니에 추가되었습니다.");
        System.out.println();
    }

    void getOrderList () {
        for (Order num: orderList)
            System.out.println(num.getAll() + "겟이다");
    }



}
