package Common;

public class LowerBound {

    /**
     * Method finds the lower bound of the target
     * Returns first element that is greater than or equal to target
     * First arr[i] >= target
     *
     * @param arr
     * @param target
     * @return
     */
    private static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    /**
     * Method finds the lower bound of the target
     * Returns first element that is greater than target
     * First arr[i] > target
     * @param arr
     * @param target
     * @return
     */
    private static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 8, 9, 11, 13};
        System.out.println("The lowerbound value is :: " + lowerBound(arr, 8));
        System.out.println("The upperbound value is  :: " + upperBound(arr, 8));
    }
}
