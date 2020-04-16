public static void union(int[] arr, int[] size, int a, int b) {
    int root_a = root(arr, a);
    int root_b = root(arr, b);
    if (size[root_a] >= size[root_b]) {
        arr[root_b] = root_a;
        size[root_a] += size[root_b];
    } else {
        arr[root_a] = root_b;
        size[root_b] += size[root_a];
    }
}