static void solve() {
    int n = in.nextInt();
    int m = in.nextInt();
    ArrayList<F> fs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        int a = in.nextInt();
        fs.add(new F(a, i + 1));
    }
    if (m < n || n == 2) {
        out.println(-1);
        return;
    }
    Collections.sort(fs, new Comparator<F>() {

        @Override
        public int compare(F o1, F o2) {
            return Integer.compare(o1.a, o2.a);
        }
    });
    long sum = 0;
    for (int i = 0; i < n; i++) {
        sum += fs.get(i).a * 2;
    }
    for (int i = n; i < m; i++) {
        sum += fs.get(0).a + fs.get(1).a;
    }
    out.println(sum);
    for (int i = 0; i < n - 1; i++) {
        out.println(fs.get(i).i + " " + fs.get(i + 1).i);
    }
    out.println(fs.get(0).i + " " + fs.get(n - 1).i);
    for (int i = n; i < m; i++) {
        out.println(fs.get(0).i + " " + fs.get(1).i);
    }
}