void solve() throws Exception {
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) sum += (a[i] = sc.nextInt());
    int min1 = 29349832, idx1 = -1;
    int min2 = 29349832, idx2 = -1;
    for (int i = 0; i < n; i++) if (a[i] < min1) {
        idx1 = i;
        min1 = a[i];
    }
    for (int i = 0; i < n; i++) if (a[i] < min2 && i != idx1) {
        idx2 = i;
        min2 = a[i];
    }
    int smallest = min1 + min2;
    if (m < n || n == 2)
        System.out.println(-1);
    else {
        System.out.println(sum * 2 + (m - n) * smallest);
        for (int i = 0; i < n; i++) System.out.println((1 + i) + " " + (1 + ((i + 1) % n)));
        for (int i = 0; i < m - n; i++) System.out.println((idx1 + 1) + " " + (idx2 + 1));
    }
}