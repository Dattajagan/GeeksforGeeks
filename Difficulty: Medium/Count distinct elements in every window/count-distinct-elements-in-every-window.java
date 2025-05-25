
class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < k; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }

        result.add(freqMap.size());

        for (int i = k; i < arr.length; i++) {
            int outElement = arr[i - k];
            freqMap.put(outElement, freqMap.get(outElement) - 1);
            if (freqMap.get(outElement) == 0) {
                freqMap.remove(outElement);
            }

            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
            result.add(freqMap.size());
        }

        return result;
    }
}
