private static int[] generateSLIS(final int n, final char[] s) {
    final int[] a = new int[n];
    LinkedList<Integer> q = new LinkedList<Integer>();
    int from = n - 1;
    a[0] = n;
    for (int i = 0; i < s.length; i++) {
        int j = i;
        char c = s[j];
        q.add(a[i]);
        while (j < s.length && c == s[j]) {
            j++;
            q.add(from);
            from--;
        }
        if (c == '>') {
            for (int k = i; k <= j; k++) {
                a[k] = q.removeFirst();
            }
        }
        if (c == '<') {
            for (int k = i; k <= j; k++) {
                a[k] = q.removeLast();
            }
        }
        i = j - 1;
    }
    return a;
}