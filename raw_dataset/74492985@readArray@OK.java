static int[] readArray(int size, InputReader in) {
    int[] a = new int[size];
    for (int i = 0; i < size; i++) {
        a[i] = in.nextInt();
    }
    return a;
}