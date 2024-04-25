package unit11.concurrency;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

public class ListAdder implements Runnable {
    private final List<Integer> list;
    private final int numValues;

    public ListAdder(List<Integer> list, int numValues) {
        this.list = list;
        this.numValues = numValues;
    }

    @Override
    public void run() {
        for(int i = 0; i < numValues; i++) {
            synchronized(list) {
                list.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> sharedList = new ArrayList<>();
        Thread[] threads = new Thread[100];
        for(int j = 0; j < threads.length; j++) {
            ListAdder adder = new ListAdder(sharedList, 50);
            Thread thread = new Thread(adder);
            thread.start();
            threads[j] = thread;
        }
        for(Thread thread : threads) {
            thread.join();
        }
        System.out.println(sharedList.size());
    }
    
}
