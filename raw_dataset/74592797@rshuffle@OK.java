int[] rshuffle(int[] a) {
    // RANDOM shuffle
    Random r = new Random();
    for (int i = a.length - 1, j, t; i >= 0; j = r.nextInt(a.length), t = a[i], a[i] = a[j], a[j] = t, i--) ;
    return a;
}