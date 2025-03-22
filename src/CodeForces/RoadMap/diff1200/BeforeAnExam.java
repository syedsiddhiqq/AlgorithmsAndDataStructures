package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 19-03-2022, Saturday, 23:06
 */
public class BeforeAnExam {
    private static Scanner s = new Scanner(System.in);

    private static class Day{
        Integer minHoursRequired;
        Integer maxHoursRequired;
        Integer totalHoursStudied = 0;

        public Day(Integer minHoursRequired, Integer maxHoursRequired) {
            this.minHoursRequired = minHoursRequired;
            this.maxHoursRequired = maxHoursRequired;
        }
    }

    public static void main(String[] args) {
        Integer nDays = s.nextInt();
        Integer totalHours = s.nextInt();

        Day[] days = new Day[nDays];
        for(int i=0;i<nDays;i++){
            Integer minHours = s.nextInt();
            Integer maxHours = s.nextInt();
            days[i] = new Day(minHours,maxHours);
        }



        for(int i=0;i<nDays;i++){
            Day day = days[i];
            if(totalHours >= day.minHoursRequired){
                totalHours -= day.minHoursRequired;
                day.totalHoursStudied += day.minHoursRequired;
            }else{
                System.out.println("NO");
                return;
            }
        }

        for(int i=0;i<nDays;i++){
            Day day = days[i];
            int remainingHours = day.maxHoursRequired - day.minHoursRequired;
            if(totalHours >= remainingHours){
                totalHours -= remainingHours;
                day.totalHoursStudied += remainingHours;
            }else {
                day.totalHoursStudied += totalHours;
                totalHours = 0;
                break;
            }
        }

        if(totalHours > 0){
            System.out.println("NO");
        }else{
            System.out.println("YES");
            for(int i=0;i<nDays;i++){
                System.out.print(days[i].totalHoursStudied + " ");
            }
        }
    }
}
