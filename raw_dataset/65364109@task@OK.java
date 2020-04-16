private static void task() {
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[] a = scanner.readArray(n);
    if (m < n || n == 2) {
        System.out.println(-1);
    } else {
        Arrays.sort(a);
        System.out.println(2 * sumArray(a) + (m - n) * (a[0] + a[1]));
        for (int i = 1; i < n; i++) {
            System.out.println(String.format("%d %d", i, i + 1));
        }
        System.out.println(String.format("%d %d", n, 1));
        for (int i = 0; i < m - n; i++) {
            System.out.println(String.format("%d %d", 1, 2));
        }
    }
}