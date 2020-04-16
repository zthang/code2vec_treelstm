public int[] nextSumIntArray(int n) {
    int[] array = new int[n];
    array[0] = nextInt();
    for (int i = 1; i < n; ++i) array[i] = array[i - 1] + nextInt();
    return array;
}