boolean insert(int i) {
    if (tree[i].ci > sz || !flag) {
        return false;
    }
    sz++;
    for (int j = sz - 1; j >= tree[i].ci + 1; j--) {
        arr[j] = arr[j - 1];
    }
    arr[tree[i].ci] = i;
    return true;
}