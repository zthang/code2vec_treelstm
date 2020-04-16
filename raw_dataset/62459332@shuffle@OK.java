public void shuffle(long[] ar) {
    int r;
    for (int i = 0; i < ar.length; ++i) {
        r = rnd.nextInt(ar.length);
        if (r != i) {
            ar[i] ^= ar[r];
            ar[r] ^= ar[i];
            ar[i] ^= ar[r];
        }
    }
}