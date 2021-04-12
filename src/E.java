/**
 * Created by Frank_Hon on 2020/12/14 12:31 下午.
 * E-mail: frank_hon@foxmail.com
 * <p>
 * 不使用临时变量，交换两个变量的值
 */
public class E {
    public static void main(String[] args) {
        int x = -4, y = 0;

//        x = x + y;
//        y = x - y;
//        x = x - y;
//        System.out.println(x+", "+y);

//        x = x - y;
//        y = x + y;
//        x = y - x;
//        System.out.println(x+", "+y);

        // ^异或运算符，如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println(x+", "+y);
    }
}
