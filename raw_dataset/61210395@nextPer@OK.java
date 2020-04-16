public static boolean nextPer(int[] data) {
    int i = data.length - 1;
    while (i > 0 && data[i] < data[i - 1]) {
        i--;
    }
    if (i == 0) {
        return false;
    }
    int j = data.length - 1;
    while (data[j] < data[i - 1]) {
        j--;
    }
    int temp = data[i - 1];
    data[i - 1] = data[j];
    data[j] = temp;
    Arrays.sort(data, i, data.length);
    return true;
}