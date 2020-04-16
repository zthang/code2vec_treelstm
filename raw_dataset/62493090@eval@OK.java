public long eval(int start, ArrayList<Integer>[] arr, int prev, int[] a, int[] b, int[] c, int count) {
    long cost = 0;
    if (count % 3 == 0)
        cost = a[start];
    else if (count % 3 == 1)
        cost = b[start];
    else
        cost = c[start];
    for (int i = 0; i < arr[start].size(); i++) if (arr[start].get(i) != prev)
        return cost + eval(arr[start].get(i), arr, start, a, b, c, count + 1);
    return cost;
}