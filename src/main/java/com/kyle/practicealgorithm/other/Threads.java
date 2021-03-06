package com.kyle.practicealgorithm.other;

public class Threads {

    public static void main(String[] args) throws InterruptedException {
        final Thread separateThread = new Thread(new ThreadPrinter());
        separateThread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("from the main thread :"
                    + Thread.currentThread().getName());
            Thread.sleep(1000);
        }

    }

    private static class ThreadPrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("from the new thread :"
                        + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
