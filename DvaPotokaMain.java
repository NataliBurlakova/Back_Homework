package potoks;

public class DvaPotokaMain {
    public static void main(String[] args)  {

        int startDiapason = 1;
        int endDiapason = 2_000_000;

        int mitteDiapason = (startDiapason + endDiapason) / 2;

        // Создание объектов для хранения результатов потоков
        ResultCounter firstHalfResult = new ResultCounter();
        ResultCounter secondHalfResult = new ResultCounter();

        // Создание потоков
        Thread firstHalfThread = new Thread(new DiapasonProcessor(startDiapason, mitteDiapason, firstHalfResult));
        Thread secondHalfThread = new Thread(new DiapasonProcessor(mitteDiapason + 1, endDiapason, secondHalfResult));

        firstHalfThread.start();
        secondHalfThread.start();


        try {
            firstHalfThread.join();
            secondHalfThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int totalCount = firstHalfResult.getCount() + secondHalfResult.getCount();

        // Вывод результата
        System.out.println("В диапазоне от 1 до 2_000_000 (включительно) делятся нацело на 21 и при этом содержат цифру 3 " + totalCount + " чисел." + totalCount);
    }


}
