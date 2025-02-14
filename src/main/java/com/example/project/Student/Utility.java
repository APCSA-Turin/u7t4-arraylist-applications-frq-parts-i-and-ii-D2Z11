package com.example.project.Student;
import java.util.ArrayList;
import java.util.Arrays;

public class Utility {
    private static ArrayList<Student> sortedMap = new ArrayList<>();
    
    private static void add(Student student) {
        if (sortedMap.size() == 0) {
            sortedMap.add(student);
            return;
        }
        // would be better to use binary search here...
        for (int i = 0; i < sortedMap.size(); i++) {
            String firstName = student.getFirstName();
            String lastName = student.getLastName();
            if (sortedMap.get(i).getLastName().compareTo(lastName) > 0) {
                sortedMap.add(i, student);
                return;
            } else if (sortedMap.get(i).getLastName().compareTo(lastName) == 0) {
                if (sortedMap.get(i).getFirstName().compareTo(firstName) > 0) {
                    sortedMap.add(i, student);
                    return;
                } else if (sortedMap.get(i).getFirstName().compareTo(firstName) == 0) {
                    if (sortedMap.get(i).getGpa() < student.getGpa()) {
                        sortedMap.add(i, student);
                        return;
                    }
                }
            }
        }
        sortedMap.add(student);
    }

    public static ArrayList<Student> sortStudents(ArrayList<Student> list){
        for (Student s : list) {
            add(s);
        }
        list = sortedMap;
        return sortedMap;
    }

}
