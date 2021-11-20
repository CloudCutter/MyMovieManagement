package cn.tong;

import java.util.ArrayList;
import java.util.List;

class DynamicProgra {
    long a;
    static DynamicProgra dp = new DynamicProgra();
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;
        System.out.println(Integer.valueOf(a)==b);
        System.out.println(a==c);
    }



    public int package01(int[] weight,int[] value,int backage){
        int dp[] = new int[backage+1];
        dp[0] = 0;
        for(int i = 0 ; i < weight.length; ++i){
            for(int j = backage; j >= weight[i]; --j){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[backage];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        }
        sum = sum / 2;
        int[] dp = new int[sum+1];
        for(int i = 0; i < nums.length; ++i){
            for(int j = dp.length-1; j >= nums[i]; --j){
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        if(dp[sum] == sum){
            return true;
        }
        return false;
    }


}