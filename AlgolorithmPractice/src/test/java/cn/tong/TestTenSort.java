package cn.tong;

import org.junit.Test;

import java.util.Arrays;

public class TestTenSort {
    TenSorts sort = new TenSorts();
    @Test
    public void testHillSort(){
        int[] arr = {7,2,14,6,4,6,32,8,2,-1,456,8,1,2,8,1,3,5,1,3,846,5,21,45,2,65,3,4,31,456,23,5648,3};
        long startTime = System.nanoTime();
        sort.hillSort(arr);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testInsertSort(){
        int[] arr = {7,2,14,6,4,6,32,8,2,-1,456,8,1,2,8,1,3,5,1,3,846,5,21,45,2,65,3,4,31,456,23,5648,3};
        long startTime = System.nanoTime();
        sort.insertSort(arr);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testBubbleSort1(){
        int[] arr = {7,2,14,6,4,6,32,8,2,-1,456,8,1,2,8,1,3,5,1,3,846,5,21,45,2,65,3,4,31,456,23,5648,3};
        long startTime = System.nanoTime();
        sort.bubbleSort1(arr);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testBubbleSort2(){
        int[] arr = {7,2,14,6,4,6,32,8,2,-1,456,8,1,2,8,1,3,5,1,3,846,5,21,45,2,65,3,4,31,456,23,5648,3};
        long startTime = System.nanoTime();
        sort.bubbleSort2(arr);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testSelectSort(){
        int[] arr = {7,2,14,6,4,6,32,8,2,-1,456,8,1,2,8,1,3,5,1,3,846,5,21,45,2,65,3,4,31,456,23,5648,3};
        long startTime = System.nanoTime();
        sort.selectSort(arr);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testQuickSort(){
        int[] arr = {7,2,14,6,4,6,32,8,2,-1,456,8,1,2,8,1,3,5,1,3,846,5,21,45,2,65,3,4,31,456,23,5648,3};
        long startTime = System.nanoTime();
        sort.quickSort(arr,0,arr.length-1);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testMergerSort(){
        int[] arr = {7,2,14,6,4,6,32,8,2,-1,456,8,1,2,8,1,3,5,1,3,846,5,21,45,2,65,3,4,31,456,23,5648,3};
        long startTime = System.nanoTime();
        int[] temp = new int[arr.length];
        sort.mergerSort(arr,temp,0,arr.length-1);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testHeapSort(){
        int[] arr = {7,2,14,6,4,6,32,8,2,-1,456,8,1,2,8,1,3,5,1,3,846,5,21,45,2,65,3,4,31,456,23,5648,3};
        long startTime = System.nanoTime();
        sort.heapSort(arr);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000);
        System.out.println(Arrays.toString(arr));
    }


}
