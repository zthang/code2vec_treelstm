// Fast Sort is Radix Sort
public static int[] fastSort(int[] f) {
    int n = f.length;
    int[] to = new int[n];
    {
        int[] b = new int[65537];
        for (int i = 0; i < n; i++) b[1 + (f[i] & 0xffff)]++;
        for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
        for (int i = 0; i < n; i++) to[b[f[i] & 0xffff]++] = f[i];
        int[] d = f;
        f = to;
        to = d;
    }
    {
        int[] b = new int[65537];
        for (int i = 0; i < n; i++) b[1 + (f[i] >>> 16)]++;
        for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
        for (int i = 0; i < n; i++) to[b[f[i] >>> 16]++] = f[i];
        int[] d = f;
        f = to;
        to = d;
    }
    return f;
}