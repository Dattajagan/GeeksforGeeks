//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(stalls, k, mid)) {
                result = mid;
                low = mid + 1; // Try to maximize the minimum distance
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private static boolean canPlace(int[] stalls, int k, int minDist) {
        int cowsPlaced = 1;
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= minDist) {
                cowsPlaced++;
                lastPos = stalls[i];
            }

            if (cowsPlaced == k) {
                return true;
            }
        }

        return false;
    }
}
