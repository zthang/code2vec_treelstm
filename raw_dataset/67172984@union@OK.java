static void union(int[] Arr, int[] size, int A, int B) {
    int root_A = root(Arr, A);
    int root_B = root(Arr, B);
    if (root_A == root_B) {
        return;
    }
    if (size[root_A] < size[root_B]) {
        Arr[root_A] = Arr[root_B];
        size[root_B] += size[root_A];
        size[root_A] = 0;
    } else {
        Arr[root_B] = Arr[root_A];
        size[root_A] += size[root_B];
        size[root_B] = 0;
    }
}