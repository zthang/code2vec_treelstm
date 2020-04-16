private static void findVal(int n, int m, int[] ar) {
    int total = 0;
    if (m < n || n == 2) {
        System.out.println("-1");
    } else if (m == n) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += 2 * ar[i];
        }
        System.out.println(sum);
        for (int i = 1; i <= ar.length - 1; i++) {
            System.out.println(i + " " + (i + 1));
        }
        System.out.println(ar.length + " " + 1);
    }
}