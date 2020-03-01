public class Solution {
    public int nextGreaterElement(int n) {

        //主要见我的笔记。
        char[] arr = String.valueOf(n).toCharArray();
        int bFirst = arr.length-1;
        while(bFirst >= 1 && arr[bFirst] <= arr[bFirst-1])//找B部分：非递增部分，例如44321.
        {
            bFirst--;
        }

        if(bFirst == 0) return -1;

        int aLast = bFirst - 1;

        //现在找B部分中比aLast所对应的值a稍微大一点的值b：因为B部分是降序的，最小值就是最后一个，然后往前找。
        for(int i = arr.length-1; i >= bFirst; i--)
        {
            if(arr[i] > arr[aLast])
            {
                swap(arr, aLast, i);
                reverse(arr, bFirst, arr.length-1);
                break;
            }
        }


        try
        {
            return Integer.valueOf(String.valueOf(arr));
        }
        catch(NumberFormatException e)
        {
            return -1;//题目的意思是如果超出int范围的话也是返回-1.例如题目：10位数：1999999999，本来应该返回9199999999，但是超出范围了。
        }

    }

    private static void swap(char[] arr, int index1, int index2)
    {
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void reverse(char[] arr, int startIndex, int endIndex)
    {
        while(startIndex < endIndex)
        {
            swap(arr, startIndex++, endIndex--);
        }
    }
}