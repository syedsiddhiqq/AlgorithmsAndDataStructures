package LeetCode.medium;

/**
 * @author SyedAli
 * @createdAt 08-03-2022, Tuesday, 07:42
 */
public class SmallestStringWithNumericValue {
    public String getSmallestString(int n, int k) {
        char[] str = new char[n];

        for(int i=0;i<n;i++)
            str[i] = 'a';

        int sum = n;
        for(int i=n-1;i>=0;i--){
            if(26 + (sum - 1) <= k){
               str[i] = 'z';
               sum += 25;
            }else{
                int temp = 25 - ((26 + (sum - 1)) - k);
                //System.out.println(temp);
                // char ch = 'a' +
                str[i] = (char)('a' + temp);
                break;
            }
        }
        return new String(str);
    }

    public static void main(String[] args) {
        System.out.println(new SmallestStringWithNumericValue().getSmallestString(5,73));
    }
}
