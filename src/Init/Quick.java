package Init;

/**
 * Created by Administrator on 2017/12/11.
 */
public class Quick {
    public static void main(String [] args){
        int [] a = {4,3,2,5,1,6,7};
        QuickSearch(a,0,a.length-1);
        for(int x:a){
            System.out.print(x+" ");
        }
        System.out.println();
        int key=4;
        int m=half(a,key);
        System.out.println(m);
    }
    static int half(int [] a,int key){
        int low=0;
        int high=a.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(key<a[mid]){
                high=mid;
            }else if(key>a[mid]){
                low=mid;
            }else{
                return mid;
            }
        }
        return -1;
    }
    static void QuickSearch(int []a,int start,int end){
        int i =start;
        int j =end;
        if(i>=j){
            return;
        }
        boolean flag = true;
        while(i<j){
            int temp=0;
            if(a[i]>a[j]){
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
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
        QuickSearch(a,start,i);
        QuickSearch(a,j,end);
    }
}
