static int find(int x, int[] array) {
    if (x == -1)
        return -1;
    if (array[x] == x)
        return x;
    else {
        array[x] = find(array[x], array);
        return array[x];
    }
}