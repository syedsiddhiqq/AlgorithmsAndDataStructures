package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 05-05-2022, Thursday, 10:38
 */
public class BerlandRegional {
    private static Scanner s = new Scanner(System.in);

    private static class Colg {
        List<Student> students = new ArrayList<>();
        Long sum = 0L;
    }

    private static class Student {
        Long id;
        Long strength;
        Long univ;

        public Student(Long id) {
            this.id = id;
        }
    }

    private static void solve() {
        int n = s.nextInt();

        Map<Long, Colg> universities = new HashMap<>();
        Map<Integer, Student> stu = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Student student = new Student(Long.valueOf(i));
            Long temp = s.nextLong();
            student.univ = temp;
            if (universities.containsKey(temp)) {
                Colg colg = universities.get(temp);
                colg.students.add(student);
            } else {
                Colg colg = new Colg();
                colg.students.add(student);
                universities.put(temp, colg);
            }

            stu.put(i, student);
        }

        for (int i = 0; i < n; i++) {
            Long temp = s.nextLong();
            stu.get(i).strength = temp;
            universities.get(stu.get(i).univ).sum += temp;
        }

        for (Colg col : universities.values()) {
            col.students.stream().sorted(Collections.reverseOrder());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {

            int sum = 0;
            for (Colg university : universities.values()) {
                for (int itr = 0; itr < university.students.size(); itr += (i - 1)) {

                }
            }
        }

    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
