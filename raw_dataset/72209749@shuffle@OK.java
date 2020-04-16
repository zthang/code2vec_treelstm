private static void shuffle(char[] s) {
    for (int i = 0; i < s.length; ++i) {
        int j = random.nextInt(i + 1);
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}