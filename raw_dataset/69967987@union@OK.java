public static boolean union(int a, int b, int[] arr, int[] size) {
    a = find(arr, a);
    b = find(arr, b);
    if (a == b)
        return false;
    if (size[a] > size[b]) {
        size[a] += size[b];
        arr[b] = arr[a];
    } else {
        size[b] += size[a];
        arr[a] = arr[b];
    }
    return true;
}