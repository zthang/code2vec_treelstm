private static int sumArray(int[] a) {
    int sum = 0;
    if (a != null) {
        for (int x : a) {
            sum += x;
        }
    }
    return sum;
}