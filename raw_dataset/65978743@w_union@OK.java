void w_union(int A, int B) {
    int root_A = root(A);
    int root_B = root(B);
    if (size[root_A] < size[root_B]) {
        arr[root_A] = arr[root_B];
        size[root_B] += size[root_A];
        size[root_A] = 0;
    } else {
        arr[root_B] = arr[root_A];
        size[root_A] += size[root_B];
        size[root_B] = 0;
    }
    ans--;
}