public void shuffle(Pair[] a) {
    for (int i = 0; i < a.length; i++) {
        int x = random.nextInt(i + 1);
        Pair t = a[x];
        a[x] = a[i];
        a[i] = t;
    }
}