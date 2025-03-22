package LeetCode.contests;

public class BinaryRep {
    public static boolean checkAllSetBits(int n) {
        char[] binaryRepArr = Integer.toBinaryString(n).toCharArray();
        for (char ch : binaryRepArr) {
            if (ch != '1') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for(int i=514;i<=Integer.MAX_VALUE;i++){
            if(checkAllSetBits(i)){
                System.out.println(i);
                break;
            }
        }
    }
}
