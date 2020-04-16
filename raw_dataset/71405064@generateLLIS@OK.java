private static int[] generateLLIS(final int n, final char[] s) {
    final int[] a = new int[n];
    LinkedList<Integer> q = new LinkedList<Integer>();
    int from = 2;
    a[0] = 1;
    for (int i = 0; i < s.length; i++) {
        int j = i;
        char c = s[j];
        q.add(a[i]);
        while (j < s.length && c == s[j]) {
            j++;
            q.add(from);
            from++;
        }
        if (c == '>') {
            for (int k = i; k <= j; k++) {
                a[k] = q.removeLast();
            }
        }
        if (c == '<') {
            for (int k = i; k <= j; k++) {
                a[k] = q.removeFirst();
            }
        }
        i = j - 1;
    }
    return a;
}