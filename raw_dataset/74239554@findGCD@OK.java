public static long findGCD(long[] arr, int n) {
    long result = arr[0];
    for (int i = 1; i < n; i++) result = gcd(arr[i], result);
    return result;
}