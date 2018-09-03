package SheJiMoShi.ShiYan;

/**
 * Created by Administrator on 2017/12/9.
 */
public class Client3 {
    public static void main(String[] args) {
        Adapter a = new Adapter();
        int [] array={56,43,23,12,12,3,5,4,23};
        a.Sort(array);
        System.out.print("排序后的数组为：");
        for(int x : array){
            System.out.print(x+" ");
        }
        System.out.println();
        int key = 4;
        int m =a.Search(array,4);
        if(m!=-1){
            System.out.println(key+"在排序后的数组中的位置为："+(m+1));
        }else{
            System.out.println("找不到");
        }
    }
}
class BinarySearch{
    int half(int [] array,int key){
        int low=0;
        int high = array.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(key>array[mid]){
                low=mid;
            }else if(key<array[mid]){
                high=mid;
            }else{
                return mid;
            }
        }
        return -1;
    }

}
class QuickSort{
    int [] sort(int [] array){
        quick(array, 0, array.length - 1);
        return array;
    }
    void quick(int [] a,int start,int end){
        int i=start;
        int j=end;
        if(i>=j){
            return;
        }
        boolean flag=true;
        while(i<j){
            int tmp=0;
            if(a[i]>a[j]){
                tmp=a[i];
                a[i]=a[j];
                a[j]=tmp;
                flag=!flag;
            }
            if(flag){
                j--;
            }else{
                i++;
            }
        }
        i--;
        j++;
        quick(a,start,i);
        quick(a,j,end);
    }
}
class Adapter{
    private QuickSort sortObj;
    private BinarySearch searchObj;

    public Adapter()
    {
        sortObj = new QuickSort();
        searchObj = new BinarySearch();
    }
    public int Search(int[] array, int key)
    {
        return searchObj.half(array, key);
    }

    public int[] Sort(int [] array)
    {
        return sortObj.sort(array);
    }
}


