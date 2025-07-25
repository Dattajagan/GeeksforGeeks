
class Solution {
    public String average(int arr[]) {
        // code here
        int sum = 0;
        int n = arr.length;
        
        for(int i = 0; i< arr.length; i++){
            sum = arr[i]+ sum;
        
        }
        double avg = (double) sum/n;
        return String.format("%.2f", avg);
        
    }
}