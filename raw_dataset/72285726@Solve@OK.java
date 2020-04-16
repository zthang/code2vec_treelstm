private static void Solve() {
    int n = scanner.nextInt();
    String s = scanner.next();
    int[] a = new int[n];
    int m = n;
    for (int i = 0; i < n; i++) {
        int len = 1;
        while (i < s.length() && s.charAt(i) == '<') {
            len++;
            i++;
        }
        for (int j = i; j > i - len; j--) {
            a[j] = m;
            m--;
        }
    }
    for (int i = 0; i < n; i++) {
        System.out.print(a[i] + " ");
    }
    System.out.println();
    m = 1;
    for (int i = 0; i < n; i++) {
        int len = 1;
        while (i < s.length() && s.charAt(i) == '>') {
            len++;
            i++;
        }
        for (int j = i; j > i - len; j--) {
            a[j] = m;
            m++;
        }
    }
    for (int i = 0; i < n; i++) {
        System.out.print(a[i] + " ");
    }
    System.out.println();
}