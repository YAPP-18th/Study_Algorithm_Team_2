import java.util.*;

class Solution {
    public HashSet<Integer> hashSet = new HashSet<>();
    public int solution(String numbers) {
        int[] nums = new int[numbers.length()];
        
        for(int i=0; i<nums.length; i++){
            nums[i] = numbers.charAt(i) - '0';
        }
        
        for(int i=1; i<=nums.length; i++){
            permutation(nums, 0, nums.length, i);
        }
        
        return hashSet.size();
    }
    
    public void permutation(int[] arr, int depth, int n, int r){
        if(depth == r){
            StringBuilder checkPrime = new StringBuilder();
            for(int i=0; i<r; i++){
                checkPrime.append(arr[i]);
            }
            if(isPrimeNumber(Integer.parseInt(checkPrime.toString()))){
                hashSet.add(Integer.parseInt(checkPrime.toString()));
            }
            return;
        }
        
        for(int i=depth; i<n; i++){
            swap(arr, depth, i);
            permutation(arr, depth+1, n, r);
            swap(arr, depth, i);
        }
    }
    
    public void swap(int[] arr, int depth, int i){
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    
    public boolean isPrimeNumber(int n){
        if(n < 2) return false;
        
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        
        return true;
    }
}
