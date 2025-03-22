package CodeForces.contests.EducationalCodeforces170;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AttributeChecks {

    public static int maxChecksPassed(int n, int m, int[] records) {
        int strength = 0;
        int intelligence = 0;
        int attributePoints = 0;  // This will hold the number of unspent points
        int checksPassed = 0;

        for (int i = 0; i < n; i++) {
            if (records[i] == 0) {
                // Acquire a point
                attributePoints++;
            } else if (records[i] > 0) {
                // Intelligence check
                int requiredIntelligence = records[i];
                if (intelligence + attributePoints >= requiredIntelligence) {
                    // If we can pass the check, spend points if necessary
                    int pointsToSpend = Math.max(0, requiredIntelligence - intelligence);
                    intelligence += pointsToSpend;
                    attributePoints -= pointsToSpend;
                    checksPassed++;
                }
            } else {
                // Strength check
                int requiredStrength = -records[i];
                if (strength + attributePoints >= requiredStrength) {
                    // If we can pass the check, spend points if necessary
                    int pointsToSpend = Math.max(0, requiredStrength - strength);
                    strength += pointsToSpend;
                    attributePoints -= pointsToSpend;
                    checksPassed++;
                }
            }
        }

        return checksPassed;
    }

    private static int dfsUtil(int i, int[] arr, int intelligence, int strength, int pass, int n, Map<String, Integer> map) {
        String key = i + "," + intelligence + "," + strength;
        if(map.containsKey(key)) return map.get(key);
        if (i == n) {
            return pass;
        } else {
            if (arr[i] == 0) {
                int intel = dfsUtil(i + 1, arr, intelligence + 1, strength, pass, n, map);
                int str = dfsUtil(i + 1, arr, intelligence, strength + 1, pass, n, map);
                map.put(key, Math.max(intel, str));
                return Math.max(intel, str);
            } else {
                int tempPass = pass;
                if (arr[i] > 0) {
                    if (intelligence >= Math.abs(arr[i])) {
                        tempPass++;
                    }
                } else {
                    if (strength >= Math.abs(arr[i])) {
                        tempPass++;
                    }
                }
                int result = dfsUtil(i + 1, arr, intelligence, strength, tempPass, n, map);
                map.put(key, result);
                return result;
            }
        }
    }

    private static void solve(int n, int m, int[] arr) {
        System.out.println(dfsUtil(0, arr, 0, 0, 0, n, new HashMap<>()));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

//        solve(n, m, arr);
        System.out.println(maxChecksPassed(n,m,arr));
    }
}
