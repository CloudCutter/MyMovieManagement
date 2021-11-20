package cn.tong;

import java.io.File;
import java.util.*;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(sc.hasNextInt()){
            list.add(sc.nextInt());
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i < arr.length; ++i){
            arr[i] = list.get(i);
        }
        App a = new App();
        System.out.println(a.maxDeliTimes(arr,6));

    }


    public Integer[] stat_hist(Integer[] datas,int num){
        int min = datas[0];
        int max = datas[1];
        for(int i = 0; i < datas.length; ++i){
            if(datas[i] > max){
                max = datas[i];
            }
            if(datas[i] < min){
                min = datas[i];
            }
        }
        int len = (max - min)/num;
        double interval = (double)(max - min)/num;
        Integer[] result = new Integer[len];
        for(int i = 0; i < len; ++i){
            result[i] = 0;
        }
        for(int i = 0; i < len;++i){
            double interval1 = min + i*interval;
            double interval2 = min + (i+1)*interval;
            for(int j = 0; j < datas.length; ++j){
                if(j == datas.length-1){
                    if(interval1<=datas[j] && datas[j]<=interval2){
                        result[i]++;
                    }
                }else {
                    if (interval1 <= datas[j] && datas[j] < interval2) {
                        result[i]++;
                    }
                }
            }
        }
        return result;
    }
    public int findBestMan(String[] Rel_Matrix){
        int[][] arr = new int[Rel_Matrix.length][Rel_Matrix.length];
        for(int i = 0; i < arr.length; ++i){
            String[] temp = Rel_Matrix[i].split(",");
            for(int j = 0; j < arr[i].length;++j){
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        int people = 0;
        int maxSum = 0;
        for(int i = 0; i < arr.length; ++i){
            int sum = 0;
            for(int j = 0; j < arr[i].length; ++j){
                sum += arr[j][i];
            }
            if(sum > maxSum){
                people = i;
                maxSum = sum;
            }
        }
        return people;
    }
    public Float[] getKAverage(Float[] raw_data, int k){
        Float[] result = new Float[raw_data.length-k+1];
        int start = 0;
        int j = 0;
        while(start < result.length){
            float sum = 0;
            for(int i = start; i <= start+k-1;++i){
                sum += raw_data[i];
            }
            result[j] = sum/k;
            start++;
            j++;
        }
        return result;
    }
    public String[] scoresort(String[] names, String[] scores){
        int[] sumScore = new int[scores.length];
        for(int i = 0; i < scores.length; ++i){
            String[] s = scores[i].split(",");
            int sum = 0;
            for(int j = 0; j <s.length; ++j){
                sum += Integer.parseInt(s[j]);
            }
            sumScore[i] = sum;
        }
        for(int i = 0; i < scores.length-1; ++i){
            int maxIndex = i;
            for(int j = i+1; j < scores.length ; ++j){
                if(sumScore[j] > sumScore[maxIndex]){
                    maxIndex = j;
                }
            }
            int temp1 = sumScore[i];
            sumScore[i] = sumScore[maxIndex];
            sumScore[maxIndex] = temp1;
            String temp2 = names[i];
            names[i] = names[maxIndex];
            names[maxIndex] = temp2;
        }
        return names;
    }
    int min = Integer.MAX_VALUE;
    public void meihua(){
        int[][] arr = {{3,2,2},{0,1,0},{1,1,1}};
        traverse(arr,0,0,0);
        if(min == Integer.MAX_VALUE){
            min = -1;
        }
        System.out.println(min);
    }
    public void traverse(int[][] arr,int m, int n,int count){
        if(m == arr.length-1 && n == arr[0].length-1){
            min = Math.min(min,count);
            return;
        }
        if(m >= arr.length || n >= arr[0].length){
            return;
        }
        for(int i = 1; i <= arr[m][n];++i) {
            if (m + i < arr.length && arr[m + i][n] != 0) {
                traverse(arr, m + i, n, count + 1);
            }
            if (n + i < arr[0].length && arr[m][n + i] != 0) {
                traverse(arr, m, n + i, count + 1);
            }
        }
   }
   public int maxDeliTimes(int[] arr,int weight){
        Arrays.sort(arr);
        int index1 = 0;
        int index2 = arr.length - 1;
        int count = 0;
        while(index1 < index2){
            if(arr[index1] + arr[index2] > weight){
                index2--;
                count++;
            }
            else if(arr[index1] + arr[index2] <= weight){
                index1++;
                index2--;
                count++;
            }
        }
        if(index1 == index2){
            count++;
        }
        return count;
   }
}
