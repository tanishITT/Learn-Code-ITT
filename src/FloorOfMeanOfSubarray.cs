using System;

class MeanQueryProcessor
{
    static long[] BuildPrefixSum(long[] arr)
    {
        long[] prefix = new long[arr.Length + 1];
        for (int i = 0; i < arr.Length; i++)
            prefix[i + 1] = prefix[i] + arr[i];
        return prefix;
    }

    static long GetFloorMean(long[] prefix, int left, int right)
    {
        long sum = prefix[right] - prefix[left - 1];
        return sum / (right - left + 1);
    }

    static void Main()
    {
        var nq = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
        var arr = Array.ConvertAll(Console.ReadLine().Split(), long.Parse);

        var prefix = BuildPrefixSum(arr);

        for (int i = 0; i < nq[1]; i++)
        {
            var lr = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            Console.WriteLine(GetFloorMean(prefix, lr[0], lr[1]));
        }
    }
}
