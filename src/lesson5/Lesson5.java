package lesson5;

import java.util.Arrays;

public class Lesson5 {
    private static final int SIZE = 10000000;
    private static final int H = SIZE / 2;
    private static float[] arr = new float[SIZE];

    public static void main(String[] args) {
        Arrays.fill(arr, 1);
        method1();
        method2();
    }

    private static void method1() {

        long currentTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(System.currentTimeMillis() - currentTime);
    }

    private static void method2() {
        long currentTime = System.currentTimeMillis();

        float[] arrayPart1 = new float[H];
        float[] arrayPart2 = new float[H];

        System.arraycopy(arr, 0, arrayPart1, 0, H);
        System.arraycopy(arr, H, arrayPart2, 0, H);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrayPart1.length; i++) {
                    arrayPart1[i] = (float)(arrayPart1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrayPart2.length; i++) {
                    arrayPart2[i] = (float)(arrayPart2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        thread1.start();
        thread2.start();

        System.arraycopy(arrayPart1, 0, arr, 0, H);
        System.arraycopy(arrayPart2, 0, arr, H, H);

        System.out.println(System.currentTimeMillis() - currentTime);
    }
}
