private static void handleQ(Scanner scan) {
    int n = scan.nextInt();
    int m = scan.nextInt();
    int sum = 0;
    int min1 = Integer.MAX_VALUE;
    int index1 = 0;
    int min2 = Integer.MAX_VALUE;
    int index2 = 0;
    for (int i = 0; i < n; i++) {
        int x = scan.nextInt();
        sum += x;
        if (x < min1) {
            min2 = min1;
            index2 = index1;
            min1 = x;
            index1 = i + 1;
        } else if (x < min2) {
            min2 = x;
            index2 = i + 1;
        }
    }
    if (n == 2) {
        System.out.println(-1);
        return;
    }
    if (m < n) {
        System.out.println(-1);
        return;
    }
    int dif = m - n;
    System.out.println(2 * sum + (m - n) * (min1 + min2));
    System.out.println(n + " 1");
    for (int i = 1; i < n; i++) {
        System.out.println(i + " " + (i + 1));
    }
    for (int i = 0; i < dif; i++) {
        System.out.println(index1 + " " + index2);
    }
}