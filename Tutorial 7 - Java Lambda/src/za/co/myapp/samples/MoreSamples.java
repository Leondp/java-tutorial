package za.co.myapp.samples;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MoreSamples {


    public void runThreads() {

        //Before Java 8:
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();

        //Java 8 way:
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();

    }

    public void addActionListeners() {
        // Before Java 8:
        JButton show = new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }});

        // Java 8 way:
        show.addActionListener(e -> System.out.println("Light, Camera, Action !! Lambda expressions Rocks"));
    }

    public void lists() {
        List<String> peopleList = Arrays.asList("John", "Koos", "Thabo", "Tanya", "Katie");

        //Prior Java 8 :
        for (String person : peopleList) {
            System.out.println(person);
        }

        //In Java 8:
        peopleList.forEach(person -> System.out.println(person));
        // or better - Method reference
        peopleList.forEach(System.out::println);


        //List Streams
        List<String> filteredList = peopleList.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("K");
            }
        }).collect(Collectors.toList());

        filteredList = peopleList.stream().filter(s -> s.startsWith("K")).collect(Collectors.toList());

        //Uppercase all names
        List<String> uppercaseList = peopleList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());

        uppercaseList = peopleList.stream().map(String::toUpperCase).collect(Collectors.toList());

    }


}
