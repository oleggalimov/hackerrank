package org.oleggalimov;

import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

//Complete the code
public class JavaSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        Comparator<Student> studentComparator = Collections.reverseOrder((Student x, Student y) -> {
            if (x.getCgpa() == y.getCgpa()) {
                if (x.getFname().equals(y.getFname())) {
                    if (x.getId() == y.getId()) {
                        return 0;
                    } else {
                        return Integer.compare(x.getId(), y.getId());
                    }
                } else {
                    return y.getFname().compareTo(x.getFname());//String compare?
                }
            } else {
                return Double.compare(x.getCgpa(), y.getCgpa());
            }
        });
        studentList.sort(studentComparator);
        //Collections.sort(studentList, Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getFname).thenComparing(Student::getId)); // only on Java 8
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}




