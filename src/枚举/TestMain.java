package 枚举;

/**
 * des:
 * created by miapoeng on 2020/4/19 18:14
 */
public class TestMain {

    public static void main(String[] args) {
        System.out.println(OrderEnum.of(2).getDesc());
        OrderEnum.of(2).print();
    }

}
