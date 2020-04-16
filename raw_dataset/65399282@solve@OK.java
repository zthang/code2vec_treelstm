static void solve() throws IOException {
    int n = Reader.nextInt(), m = Reader.nextInt();
    int[] arr = new int[n + 1];
    long sum = 0;
    for (int i = 0; i < n; i++) {
        sum += Reader.nextInt() * 2;
    }
    if (n == 2) {
        System.out.println(-1);
        return;
    }
    if (m < n) {
        System.out.println(-1);
        return;
    }
    System.out.println(sum);
    for (int i = 1; i < n; i++) {
        System.out.println(i + " " + (i + 1));
    }
    System.out.println(n + " " + 1);
}