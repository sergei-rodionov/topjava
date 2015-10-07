package ru.javawebinar.topjava.service;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by SergeiRodionov.ru on 07.10.2015.
 */
public class MyTestWatcherRule extends TestWatcher {
    private static long timeStart, timeEnd;
    private Calendar cal;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.S z");

    protected void starting(Description description) {
        timeStart = System.currentTimeMillis();
        cal = Calendar.getInstance();
        System.out
                .println("===========================================================================");
        System.out.println("Test: " + description.getMethodName());
        System.out.println("Start Time: " + dateFormat.format(cal.getTime()));
        System.out
                .println("===========================================================================");
    }

    protected void finished(Description description) {
        timeEnd = System.currentTimeMillis();
        double seconds = (timeEnd - timeStart) / 1000.0;
        System.out
                .println("\n===========================================================================");
        System.out
                .println("Test completed - ran in: " + new DecimalFormat("0.000").format(seconds) + " sec");
        System.out
                .println("===========================================================================\n");

    }
}
