package DZ;
/*
Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
 */
public class DZ_1 {
    public static void main(String[] args) {
        String[] sArray = {"str_1", null, "str_3"};
        method_1(10, 0);
        method_2(sArray);
     //   method_3(8, 11, 4);
    }

    public static void method_1(int a, int b) {
        if (b == 0) throw new ArithmeticException("На ноль делить нельзя!");
        int result = a / b;
        System.out.printf("Результат деления" + " " + a + " " + "на" + " " + b + " " + "равен" + " " + result);
    }

    public static void method_2(String[] sArray) {
        for (String item : sArray) {
            if (item == null) throw new NullPointerException("Элемент отсутствует!");
            System.out.println(item);
        }


       /* public static int[] method_3 ( int a, int b, int c){
            int[] array = new int[a];
            array[b] = c;
            return array;
        } */
    }
}



