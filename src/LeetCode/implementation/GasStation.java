package LeetCode.implementation;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 05-03-2023, Sunday, 19:01
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[][] gasStations = new int[gas.length][3];
        int totalGas = 0, totalCost = 0;


        for(int i=0;i<gas.length;i++){
            totalGas += gas[i];
            totalCost += cost[i];

            gasStations[i] = new int[]{gas[i], cost[i], i};
        }

        if(totalCost > totalGas) return -1;

        Arrays.sort(gasStations , (a, b) -> {
            if(a[1] < b[1]){
                return -1;
            }else if(a[1] > b[1]){
                return 1;
            }else {
                return a[0] - b[0];
            }
        });


        for(int i=0;i<gasStations.length;i++){
            int[] gasStation = gasStations[i];
            int index = gasStation[2];
            int currentGas = gasStation[0] - gasStation[1];
            int j = index + 1;
            while(j < gasStations.length && j != index && currentGas > 0){
                currentGas = (currentGas + gas[j]) - cost[j];
                j++;
                if(j == gasStations.length) j = 0;
            }
            if(currentGas >= 0) return index;
        }

        return -1;
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        gasStation.canCompleteCircuit(gas, cost);
    }
}
