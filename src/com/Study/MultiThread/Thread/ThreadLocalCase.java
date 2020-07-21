package com.Study.MultiThread.Thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreadLocalCase implements Runnable{
    private static final ThreadLocal<List<String>> WORDS = ThreadLocal.withInitial(ArrayList::new);

    /**
     * 可以有多个ThreadLocal
     * private static final ThreadLocal<String> WORD = ThreadLocal.withInitial(String::new);
     */

    private final String bookName; // It is also the thread's name
    private final List<String> words;


    public ThreadLocalCase (String bookName, List<String> words) {
        this.bookName = bookName;
        this.words = Collections.unmodifiableList(words);
    }

    public void run() {
        WORDS.get().addAll(words);
        System.out.println(getFromThreadLocal());
        System.out.printf("Result %s: '%s'.%n", bookName, String.join(", ", WORDS.get()));
    }

    public List<String> getFromThreadLocal(){
        return WORDS.get();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadLocalCase("BookA", Arrays.asList("wordA1", "wordA2", "wordA3")));
        Thread t2 = new Thread(new ThreadLocalCase("BookB", Arrays.asList("wordB1", "wordB2")));
        t1.start();
        t2.start();
    }
}
