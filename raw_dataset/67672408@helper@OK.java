public static boolean helper(int[] a, int[] b, int x, int m) {
    int[] check = new int[a.length];
    for (int i = 0; i < a.length; i++) check[i] = (x + a[i]) % m;
    Arrays.parallelSort(check);
    for (int i = 0; i < a.length; i++) if (check[i] != b[i])
        return false;
    return true;
}