public void run() throws Exception {
    FastIO file = new FastIO();
    int n = file.nextInt();
    DSU d = new DSU(n);
    int[] a = new int[26];
    Arrays.fill(a, -1);
    for (int i = 0; i < n; i++) {
        char[] c = file.next().toCharArray();
        for (int j = 0; j < c.length; j++) {
            if (a[c[j] - 'a'] == -1) {
                a[c[j] - 'a'] = i;
            } else {
                d.unify(i, a[c[j] - 'a']);
            }
        }
    }
    System.out.println(d.numsets);
    file.out.flush();
    file.out.close();
}