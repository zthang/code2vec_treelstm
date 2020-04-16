public void weightedunion(int x, int y, int[] size, int[] arr) {
    int roota = root(arr, x);
    int rootb = root(arr, y);
    if (roota == rootb) {
        return;
    }
    if (size[roota] < size[rootb]) {
        arr[roota] = rootb;
        size[rootb] += size[roota];
    } else {
        arr[rootb] = roota;
        size[roota] += size[rootb];
    }
    numcomponents--;
}