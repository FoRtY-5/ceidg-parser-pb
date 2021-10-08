//package com.example.ceidgparser.service.implementation;
//
//import com.example.ceidgparser.service.CeidgManager;
//import com.example.ceidgparser.service.CeidgRunner;
//
//import java.io.IOException;
//import java.time.*;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//public class CeidgRunnerImpl implements CeidgRunner {
//
//    private CeidgManager manager = new CeidgManagerImpl();
//
//
//    public void run() {
//        final ZonedDateTime now = ZonedDateTime.now(ZoneId.of("GMT+2"));
//        ZonedDateTime nextRun = now.withHour(10).withMinute(28);
//
//        // if midnight is in the past add one day
//        if (now.compareTo(nextRun) > 0) {
//            nextRun = nextRun.plusDays(1);
//        }
//
//        final Duration initialDelay = Duration.between(now, nextRun);
//
//        // schedule a task to run at midnight and then every day
//        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//        scheduler.scheduleAtFixedRate(() -> {
//                    try {
//                        manager.appInit();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                },
//                initialDelay.toMillis(),
//                Duration.ofDays(1).toMillis(),
//                TimeUnit.MILLISECONDS);
//
//        System.out.println("Time until creating CSV: " + initialDelay);
//    }
//
//    public void runPing() {
//        final ZonedDateTime now = ZonedDateTime.now(ZoneId.of("GMT+2"));
//        ZonedDateTime nextRun = now.withHour(2).withMinute(10);
//
//        // if midnight is in the past add one day
//        if (now.compareTo(nextRun) > 0) {
//            nextRun = nextRun.plusDays(1);
//        }
//
//        final Duration initialDelay = Duration.between(now, nextRun);
//
//        // schedule a task to run at midnight and then every day
//        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//        scheduler.scheduleAtFixedRate(() -> {
//                    System.out.println(LocalDateTime.now());
//                },
//                initialDelay.toMillis(),
//                Duration.ofMinutes(5).toMillis(),
//                TimeUnit.MILLISECONDS);
//
//        System.out.println("Time until pinging: " + initialDelay);
//    }
//
////    public void runAtNoon() {
////        final ZonedDateTime now = ZonedDateTime.now(ZoneId.of("GMT+2"));
////        ZonedDateTime nextRun = now.withHour(13).withMinute(0).withSecond(0);
////
////        // if midnight is in the past add one day
////        if (now.compareTo(nextRun) > 0) {
////            nextRun = nextRun.plusDays(1);
////        }
////
////        final Duration initialDelay = Duration.between(now, nextRun);
////
////        // schedule a task to run at midnight and then every day
////        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
////        scheduler.scheduleAtFixedRate(() -> manager.createCSVResultForNoon(),
////                initialDelay.toMillis(),
////                Duration.ofDays(1).toMillis(),
////                TimeUnit.MILLISECONDS);
////
////        System.out.println("Time until creating CSV: " + initialDelay);
////    }
//
//}
