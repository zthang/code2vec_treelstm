public int find(int i) {
    int original = i;
    while (arr[i] != i) {
        i = arr[i];
    }
    while (i != original) {
        int no = arr[original];
        arr[original] = i;
        original = no;
    }
    return i;
}