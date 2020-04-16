private void shuffle(int[] s) {
    for (int i = 0; i < s.length; ++i) {
        int j = random.nextInt(i + 1);
        int t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}