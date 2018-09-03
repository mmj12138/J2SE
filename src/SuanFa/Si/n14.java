package SuanFa.Si;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/12/9.
 *某种高效率5台机器 分配给三个工厂a,b,c
 * 求如何分配盈利最大
 * s    0  1  2   3  4  5
 * a    0  3  7   9 12 13
 * b    0   5 10 11 11 11
 * c    0  4  6  11 12 12
 *
 * 基本思想：随着机器数和工厂数的增加一遍又一遍的更新最大盈利数的存储数组
 * 最后一遍的对应机器数和工厂数的盈利数就是最终的最大盈利数
 * 二维数组保存最大盈利数组更新过程中依次对应的工厂使用的机器数
 * 最后最大盈利数对应的每个工厂使用的机器数就是工厂减一，机器数相应减少对应
 * 在二维数组中的每一个数值
 *
 * 详细描述：动态数组思想。这里用到了三个一维数组和一个二维数组
 * 三个一维数组分别用来保存当前工厂盈利数、当前相应最大盈利数、以及最大数组更新时所用到的中间数组
 * 二维数组用来存储相应工厂数和机器数最大盈利时该工厂所使用的机器数
 * 通过判断每一次的所有情况来更新最大数组
 * 在定义一个数组倒序推每个工厂使用的机器数
 * 正序依次输出这个数组，以及最大数组中的最后一个值
 * 也就是如何分配以及最大盈利数了。
 *
 */
public class n14 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("机器数：");
        int m =sc.nextInt();
        System.out.print("工厂数：");
        int n = sc.nextInt();
        int [] item =new int[m+1];//这一个工厂的盈利数
        int [] max = new int[m+1];
        int [] temp = new int[m+1];//中间变量数组
        int [][]a = new int[n+1][m+1];//第n个工厂用几个机器才会获得最大利润值
        System.out.println("依次输入第一个工厂的相应盈利数：");
        int i,j,k;
        for(i=0;i<=m;i++){//第一个工厂
            item[i]=sc.nextInt();
            max[i]=item[i];
            a[1][i]=i;
        }

        for(k=2;k<=n;k++){//新增工厂
            System.out.println("依次输入下一个工厂的相应盈利数 ：");
            for(i=0;i<=m;i++){
                item[i]=sc.nextInt();
            }
            for(j=0;j<=m;j++){//依次增加的总机器数
                for(i=0;i<=j;i++){//遍历比较出最大值
                    if(max[j-i]+item[i]>temp[j]){//每一种情况都和前一种情况进行比较，留下所有情况中最大的那种
                        temp[j]=max[j-i]+item[i];//利用中间数组更新最大数组
                        a[k][j]=i;
                    }
                }
            }
            for(j=0;j<=m;j++){//将更新后的中间数组存到最大数组中以便下一次使用
                max[j]=temp[j];
            }
        }
        int [] result = new int[n+1];//存储每个工厂的分配数量
        int sum=m;
        for(i=n;i>0;i--){//倒序寻找存储
            result[i]=a[i][sum];
            sum=sum-result[i];//机器数减少
        }

        System.out.print("三个工厂分配：");
        for(i=1;i<=n;i++){
            System.out.print(result[i]+"台\t");
        }
        System.out.println();
        System.out.println("总盈利数为："+max[m]);
    }
}
