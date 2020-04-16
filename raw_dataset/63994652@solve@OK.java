static long solve(int a, int b, long sum) {
    int n = arr.length;
    int[] tans = new int[n + 1];
    long tsum = 0;
    tans[arr[0]] = a;
    tans[arr[1]] = b;
    tsum += c[tans[arr[0]]][arr[0]];
    tsum += c[tans[arr[1]]][arr[1]];
    for (int i = 2; i < n; i++) {
        tans[arr[i]] = 6 - tans[arr[i - 1]] - tans[arr[i - 2]];
        tsum += c[tans[arr[i]]][arr[i]];
    }
    if (tsum < sum) {
        ans = tans;
        return tsum;
    }
    return sum;
}