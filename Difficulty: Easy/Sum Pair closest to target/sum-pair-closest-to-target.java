// User function Template for Java



class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        List<Integer> result = new ArrayList<>();
        if (arr.length < 2) return result;

        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int closestDiff = Integer.MAX_VALUE;
        int maxAbsDiff = -1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int diff = Math.abs(sum - target);
            int absDiff = Math.abs(arr[right] - arr[left]);

            if (diff < closestDiff || (diff == closestDiff && absDiff > maxAbsDiff)) {
                result = Arrays.asList(arr[left], arr[right]);
                closestDiff = diff;
                maxAbsDiff = absDiff;
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
