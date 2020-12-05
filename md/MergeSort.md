@[toc]
# 写在最前
本文用来记录自己的工作、学习遇到的问题, 好记性不如烂笔头, 起的更多的是笔记的作用, 由于本人表达能力、技术水平有限, 本文仅起参考作用, 一切以您实际code为准, 给您带来的不便敬请谅解; 如果发现哪里理解不对或者有问题的地方, 欢迎批评指正. 也欢迎添加我的微信一起讨论交流.微: ClearZeroX
# 概念
归并排序是指将两个(或两个以上)有序集合合并(merge)成一个有序集合的排序算法. 两个合并的过程称为2-路归并.
## 归并思路
设两个有序的子集合(相当于输入结合)分别为arrI, arrJ, 和一个临时集合temp(相当于输出集合), 设置三个指针i、j和t, 初始值都指向三个集合的初始位置, 比较arrI[i]和arrJ[j], 取较小(或较大)的数字复制temp[j]中, 然后将被复制记录的指针i或j加1, 以及指向复制位置的指针t加1; 重复这个过程直到arrI或arrJ有一个为空时(这个全部复制完毕), 此时将另一个集合依次复制到temp中即可.
# 实现方式(两种)
一种是自上向下的递归实现(也可以使用非递归方式, 本文不讨论), 采用的是分治的思想, 比较好理解;另一种自底向上的二路归并, 循环实现比递归实现效率高, 但是不利于理解  
## 1、自上向下的递归实现, 采用的分治的思想
是采用分治思想的一个典型应用.主要分为三个步骤:
1. 分解: 将当前区间一分为二, 即求分裂点mid=(low+high)/2, 这里的low是指索引不是元素(当前序列是无序的还没开始排序)
2. 求解: 递归的对两个子区间arr[low..mid]、arr[mid+1..high]进行归并排序; 递归结束条件, 子序列长度为1(长度为1肯定是有序的);
3. 合并: 将已排序的两个子区间arr[low..mid]、arr[mid+1..high]归并为一个有序的区间arr[low..high], 归并过程见上面的 归并思路
### 代码实现
~~~
public static void mergeSort(int[] arr, int low, int high){
    // 递归结束条件 子序列有序 相等说明子序列只有一个元素肯定有序
    if(low < high){
        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low , mid, high);
    }
}
public static void merge(int[] arr, int low, int mid, int high){
    //开辟临时数组
    int[] temp = new int[high-low+1];
    //设置指针
    int i = low, j = mid+1, t = 0;
    while(i <= mid && j <= high){
        if(arr[i] <= arr[j]){
            temp[t++] = arr[i++];
        }else{
            temp[t++] = arr[j++];
        }
    }
    //左侧有剩余的话就放过去
    while (i <= mid){
        temp[t++] = arr[i++];
    }
    //右侧有剩余的话放过去
    while (j <= high){
        temp[t++] = arr[j++];
    }
    //把临时集合的元素复制到原数组
    for (int k = 0; k < temp.length; k++) {
        arr[k+low] = temp[k];
    }
}
~~~
### 时间复杂度
O(nlogn) : 归并排序把集合一层一层进行拆分半组, 如果集合长度是n, 那么折半的长度就是logn, 也就是层级数, 每一层进行归并操作的运算量是n, 每一层的运算量乘以层级数(无论最好最坏情况都这样).
### 空间复杂度
O(n) : 每一层的归并操作都要创建额外集合, 所占空间是n, 乘以层级数logn等于nlogn, 但其实不是, 由于每次归并所创建的集合都随着方法的结束而释放, 所以这部分空间不累加计算, 单次递归开辟的最大空间是n, 所以归并的空间复杂度是o(n).
## 2、自底向上方法, 也就是常说的二路归并 
基本思路: 第 1 趟排序将长度为 n 的待排序记录看作 n 个长度为 1 的有序子序列, 然后将这些子序列两两合并. 完成第 1 趟排序之后，将得到 lgn 个长度为 2 的有序子序列(如果 n 为奇数，则最后还有一个长度为 1 的子序列). 第 2 趟排序是在第 1 趟的排序的基础上，将这 lgn 个长度为 2 的子序列两两合并. 如此反复, 直到最后得到一个长度为n的有序文件为止. 从这个排序过程来看, 二路归并排序是从将长度为 1 的子序列排序变化到长度为 n 的有序序列, 因而是自底向上的.
~~~
//TODO 有时间再说吧
~~~
# 总结
1. 归并排序是一种稳定排序算法
2. 可用顺序存储结构, 也易于在**链表**上实现
# 参考
http://www.cppblog.com/kesalin/archive/2011/03/13/merge_sort.html  
https://mp.weixin.qq.com/s/885uGVhlffWAxjgIEW-TiA  
https://www.imooc.com/article/15477



 