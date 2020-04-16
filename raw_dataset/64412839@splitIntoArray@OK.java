public static int[] splitIntoArray(int i, int[] max) {
    int[] res = new int[max.length];
    for (int j = max.length - 1; j >= 0; j--) {
        res[j] = i % max[j];
        i /= max[j];
    }
    return res;
}