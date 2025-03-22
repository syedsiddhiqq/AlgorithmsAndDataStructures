package LeetCode.contests.WeeklyContest424;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountMentionsPerUserGPT {
    public static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        // Sort the events by timestamp and type (OFFLINE first)
        events.sort((a,b)-> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 != t2) {
                return Integer.compare(t1, t2);
            } else {
                // OFFLINE comes before MESSAGE
                boolean aOffline = a.get(0).equals("OFFLINE");
                boolean bOffline = b.get(0).equals("OFFLINE");
                if (aOffline && !bOffline) {
                    return -1;
                } else if (!aOffline && bOffline) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int[] mentions = new int[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers]; // All initialized to 0 (online)

        for (List<String> event : events) {
            String type = event.get(0);
            int timestamp = Integer.parseInt(event.get(1));
            if (type.equals("OFFLINE")) {
                int userId = Integer.parseInt(event.get(2));
                offlineUntil[userId] = timestamp + 60;
            } else {
                // Process MESSAGE event
                String[] tokens = event.get(2).split("\\s+");
                for (String token : tokens) {
                    if (token.equals("ALL")) {
                        for (int i = 0; i < numberOfUsers; i++) {
                            mentions[i]++;
                        }
                    } else if (token.equals("HERE")) {
                        for (int i = 0; i < numberOfUsers; i++) {
                            if (timestamp >= offlineUntil[i]) {
                                mentions[i]++;
                            }
                        }
                    } else if (token.startsWith("id")) {
                        int userId = Integer.parseInt(token.substring(2));
                        mentions[userId]++;
                    }
                }
            }
        }

        return mentions;
    }

    public static void main(String[] args) {
        List<List<String>> events = Arrays.asList(
                Arrays.asList("MESSAGE", "1", "id0 id1"),
                Arrays.asList("MESSAGE", "5", "id2"),
                Arrays.asList("MESSAGE", "6", "ALL"),
                Arrays.asList("OFFLINE", "5", "2")
        );
        int[] mentions = countMentions(3, events);
        System.out.println(mentions.toString());
    }
}
