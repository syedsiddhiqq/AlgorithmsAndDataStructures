package LeetCode.contests.weeklyContest419;

public class NumOfWinningSequence {
    private int MOD = 1000000000 + 7;

    public int countWinningSequences(String s) {
        char[] alice = s.toCharArray();
        return dfs(alice, 'a', 0, 0);
    }

    private int dfs(char[] alice,char last, int start, int score){
        char[] bob = {'F', 'W', 'E'};
        char[] win = {'W', 'E', 'F'};
        int count = 0;
        if(start == alice.length){
            if(score > 0) return 1;
            return 0;
        }else{
            for(int i=0;i<3;i++){
                int tempScore = score;
                if(bob[i] != last){
                    if(alice[start] == 'F'){
                        if(bob[i] == 'W')
                            tempScore++;
                        else if(bob[i] == 'E'){
                            tempScore--;
                        }
                    }else if(alice[start] == 'W'){
                        if(bob[i] == 'E'){
                            tempScore++;
                        }else if(bob[i] == 'F'){
                            tempScore--;
                        }
                    }else if(alice[start] == 'E'){
                        if(bob[i] == 'F'){
                            tempScore++;
                        }else if(bob[i] == 'W'){
                            tempScore--;
                        }
                    }
                    count += (dfs(alice, bob[i], start + 1, tempScore) % MOD);
                }
            }
        }
        return count % MOD;
    }

    public static void main(String[] args) {
        NumOfWinningSequence n = new NumOfWinningSequence();
        System.out.println(n.countWinningSequences("FFF"));
    }
}
