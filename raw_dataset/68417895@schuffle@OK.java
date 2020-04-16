public static int[] schuffle(int[] a2) {
    for (int i = 0; i < a2.length; i++) {
        int x = (int) (Math.random() * a2.length);
        int temp = a2[x];
        a2[x] = a2[i];
        a2[i] = temp;
    }
    return a2;
}