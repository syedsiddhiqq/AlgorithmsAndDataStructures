package LeetCode.implementation;

public class Unique3DigitEvenNumber {
    public static int totalNumbers(int[] digits) {
        int count = 0;
        int[] freqMap = new int[10];
        for(int i=0;i<digits.length;i++){
            freqMap[digits[i]]++;
        }
        for(int i=100;i<=998;i+=2){
            int temp = i;
            int[] tempFreq = copy(freqMap);
            boolean valid = true;
            while(temp > 0){
                int lastElement = temp % 10;
                if(tempFreq[lastElement] <= 0){
                    valid = false;
                    break;
                }
                tempFreq[lastElement]--;
                temp = temp / 10;
            }
            if(valid) count++;
        }
        return count;
    }

    private static int[] copy(int[] digits){
        int[] newArr = new int[10];
        for(int i=0;i<10;i++){
            newArr[i] = digits[i];
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(totalNumbers(arr));
    }
}
