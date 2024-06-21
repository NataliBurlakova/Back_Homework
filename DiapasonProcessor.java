package potoks;

public class DiapasonProcessor implements Runnable {
    private final int start;
    private final int end;
    private final ResultCounter resultCounter;

    public DiapasonProcessor(int start, int end, ResultCounter resultCounter) {
        this.start = start;
        this.end = end;
        this.resultCounter = resultCounter;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (i % 21 == 0 && thereIs3(i)) {
                resultCounter.increment();
            }
        }
    }

    private static boolean thereIs3(int number) {
        String string = String.valueOf(number);
        return string.contains("3");
    }

}
