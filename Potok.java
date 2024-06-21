package potoks;

/*Дан диапазон чисел: от 1 до 2_000_000 включительно.
Задача: найти, сколько чисел из этого диапазона делятся нацело на 21 и при этом содержат цифру 3.
Решить данную задачу в один поток.
Решить данную задачу в два потока, разделив между потоками заданный диапазон чисел.
Сравнить результаты двух решений - они должны совпадать.
* */

public class Potok {
    public static void main(String[] args) {
        int count = 0;

        for (int i = 1; i <= 2_000_000; i++) {
            if (i % 21 == 0 && thereIs3(i)) {
                count++;
            }
        }
        System.out.println("В диапазоне от 1 до 2_000_000 (включительно) делятся нацело на 21 и при этом содержат цифру 3 " + count + " чисел.");

    }

    private static boolean thereIs3(int number) {
        String string = String.valueOf(number);
        return string.contains("3");
    }

}
