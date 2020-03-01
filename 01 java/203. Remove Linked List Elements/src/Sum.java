public class Sum {
    public static int sum(int[] arr)
    {
        return sum2(arr, 0);
    }
    private static int sum(int[] arr, int start)
    {
        if(start+1 == arr.length)
        {
            return arr[start];
        }
        else
        {
            return arr[start] + sum(arr, start+1);
        }
    }

    private static int sum2(int[] arr, int start)
    {
        if(start == arr.length)
        {
            return 0;
        }
        else
        {
            return arr[start] + sum(arr, start+1);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5};
        System.out.println(sum(arr));
    }
}
