void reverseArray(long[] ar) {
    for (int i = 0, j = ar.length - 1; i < j; i++, j--) {
        long a = ar[i];
        ar[i] = ar[j];
        ar[j] = a;
    }
}