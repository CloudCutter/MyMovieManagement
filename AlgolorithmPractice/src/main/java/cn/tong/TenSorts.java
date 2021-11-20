package cn.tong;

public class TenSorts {
    //希尔排序
    public void hillSort(int[] arr){
        int n = arr.length;
        int gap = n / 2;
        while(gap != 0){
            for(int i = 0; i < gap; ++i){
                insertSort(arr,i,gap);
            }
            gap /= 2;
        }
    }
    public void insertSort(int[] arr,int start,int gap){
        for(int i = start + gap; i < arr.length; i += gap){
            int value = arr[i]; //待插入元素
            int j = i - gap;
            while(j >= 0 && arr[j] > value){
                arr[j + gap] = arr[j];
                j -= gap;
            }
            arr[j+gap] = value;
        }
    }
    //插入排序
    public void insertSort(int[] arr){
        for(int i = 1; i < arr.length; ++i){
            int j = i - 1;
            int value = arr[i];
            while(j >= 0 && value < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }
    //冒泡未优化
    public void bubbleSort1(int arr[]){
        for(int i = 0; i < arr.length; ++i){
            for(int j = 0; j < arr.length - 1 -i; ++j){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    //冒泡优化
    public void bubbleSort2(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            boolean flag = true;
            for(int j = 0; j < arr.length - 1 -i; ++j){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if(flag){
                return;
            }

        }
    }
    //选择排序
    public void selectSort(int[] arr){
        for(int i = 0; i < arr.length - 1; ++i){
            int minIndex = i;
            for(int j = i+1; j < arr.length; ++j){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    //快速排序
    public void quickSort(int[] arr,int start,int end){
        if(start < end){
            int index = getIndex(arr,start,end);
            quickSort(arr,start,index);
            quickSort(arr,index+1,end);
        }
    }
    public int getIndex(int[] arr, int start, int end){
        int middle = arr[start];
        while(start < end){
            while(start < end && arr[end] >= middle){
                end--;
            }
            arr[start] = arr[end];
            while(start < end && arr[start] <= middle){
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = middle;
        return start;
    }
    //归并排序
    public void mergerSort(int[] arr,int[] temp,int start,int end){
        if(start < end){
            int middle = (start + end) / 2;
            //分
            mergerSort(arr,temp,start,middle);
            mergerSort(arr,temp,middle+1,end);
            //治
            merge(arr,temp,start,middle,end);
        }

    }
    private void merge(int[] arr, int[] temp, int start, int middle, int end) {
        int i = start;
        int j = middle+1;
        for(int k = start; k <= end; ++k){
            if(i > middle){
                temp[k] = arr[j++];
            }else if(j > end){
                temp[k] = arr[i++];
            }else if(arr[i] > arr[j]){
                temp[k] = arr[j++];
            }else if(arr[i] <= arr[j]) {
                temp[k] = arr[i++];
            }
        }
        for(int k = start; k <= end; ++k){
            arr[k] = temp[k];
        }
    }

    //堆排序
    public void heapSort(int[] arr){
        int length = arr.length;
        //先构建二叉堆，从最后一个非叶子节点中依次下沉
        for(int i = (length-2)/2; i >= 0; --i){
            downAdjust(arr,i,length);
        }
        //现在开始堆排序
        for(int j = length - 1; j >= 1; --j){
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //不要将被交换的那个节点给交换了
            downAdjust(arr,0,j);
        }
    }
    public void downAdjust(int[] arr, int parent, int length){
        int child = parent*2+1;
        //先取出父节点的值
        int temp = arr[parent];
        while(child < length){
            //先定位到孩子节点中更大的那个
            if(child + 1 < length && arr[child] < arr[child+1]){
                child++;
            }
            //如果父节点已经大于孩子节点就结束
            if(temp >= arr[child]){
                break;
            }
            //然后向下继续遍历
            arr[parent] = arr[child];
            parent = child;
            child = parent*2+1;
        }
        arr[parent] = temp;
    }

}


