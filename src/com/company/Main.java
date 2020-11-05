package com.company;

import education.Faculty;
import education.Student;
import education.Subject;
import education.expulsion.ExpulsionConfig;
import education.expulsion.ExpulsionExecutor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ExpulsionConfig.Builder builder = new ExpulsionConfig.Builder();
        if(args.length >= 1) { builder = builder.setRobotics(Boolean.parseBoolean(args[0])); }
        if(args.length >= 2) { builder = builder.setICE(Boolean.parseBoolean(args[1])); }
        if(args.length >= 3) { builder = builder.setSE(Boolean.parseBoolean(args[2])); }
        if(args.length >= 4) { builder = builder.setRandom(Boolean.parseBoolean(args[3])); }
        if(args.length >= 5) { builder = builder.setFullMoon(Boolean.parseBoolean(args[4])); }
        ExpulsionConfig config = builder.build();


        /*
     ExpulsionConfig config = new ExpulsionConfig.Builder()
             .setRobotics(false)
             .setICE(true)
             .setSE(true)
             .setRandom(false)
             .setFullMoon(false)
             .build();
         */


        System.out.println(config);

        List<Student> students = new ArrayList<>();

        students.add(new Student("Alexey",
                Faculty.SE,
                new Subject(true, true)));
        students.add(new Student("Andrey",
                Faculty.SE,
                new Subject(false, true)));
        students.add(new Student("Olga",
                Faculty.SE,
                new Subject(true, false)));
        students.add(new Student("Oleg",
                Faculty.SE,
                new Subject(false, false)));

        students.add(new Student("Maria",
                Faculty.ROBOTICS,
                new Subject(true, true)));
        students.add(new Student("Anastasia",
                Faculty.ROBOTICS,
                new Subject(false, true)));
        students.add(new Student("Mikhail",
                Faculty.ROBOTICS,
                new Subject(true, false)));
        students.add(new Student("Ilya",
                Faculty.ROBOTICS,
                new Subject(false, false)));

        students.add(new Student("Vladimir",
                Faculty.ICE,
                new Subject(true, true)));
        students.add(new Student("Vladislav",
                Faculty.ICE,
                new Subject(false, true)));
        students.add(new Student("Dmitriy",
                Faculty.ICE,
                new Subject(true, false)));
        students.add(new Student("Katherine",
                Faculty.ICE,
                new Subject(false, false)));

        ExpulsionExecutor executor = new ExpulsionExecutor(config);
        executor.execute(students);

        for (Student s :students) {
            System.out.println(s);
        }
    }
}
