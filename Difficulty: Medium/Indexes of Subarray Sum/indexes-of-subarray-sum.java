
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int n = arr.length;
        int start = 0, end = 0, sum = 0;
        ArrayList<Integer> res = new ArrayList<>();

        while (end < n) {
            sum += arr[end];

            while (sum > target && start < end) {
                sum -= arr[start];
                start++;
            }

            if (sum == target) {
                res.add(start + 1);
                res.add(end + 1);
                return res;
            }

            end++;
        }

        res.add(-1);
        return res;
    }
}
