package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * @author SyedAli
 * @createdAt 03-04-2022, Sunday, 17:38
 */
public class SpreadRumors {
    private static Scanner s = new Scanner(System.in);

    private static class Npc {
        int id;
        long coins;
        Npc friend;
        boolean knows = false;

        public Npc(int id, long coins) {
            this.id = id;
            this.coins = coins;
        }
    }

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt();

        Npc[] npcs = new Npc[n];

        for (int i = 0; i < n; i++) {
            npcs[i] = new Npc(i + 1, s.nextLong());
        }

        Map<Integer, Npc> friends = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = s.nextInt(), y = s.nextInt();
            npcs[x - 1].friend = npcs[y - 1];
            friends.put(x - 1, npcs[y - 1]);
        }

        List<Npc> sortedNpcs = friends.keySet().stream().map(key -> npcs[key]).collect(Collectors.toList());
        Collections.sort(sortedNpcs, (a, b) -> (int) (a.coins - b.coins));
        long ans = 0;
        for (Npc sortedNpc : sortedNpcs) {
            if (!sortedNpc.knows) {
                ans += sortedNpc.coins;
                sortedNpc.knows = true;
            }
            friends.get(sortedNpc.id - 1).knows = true;
        }

        for (int i = 0; i < n; i++) {
            if (!npcs[i].knows) ans += npcs[i].coins;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
    }
}
