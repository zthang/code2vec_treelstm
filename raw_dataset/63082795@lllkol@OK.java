void lllkol(int f1, int f2, int f3) {
    System.out.println(check(f1, f2, f3));
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
        if (i % 3 == 0) {
            ans[arr.get(i)] = f1;
        } else if (i % 3 == 1) {
            ans[arr.get(i)] = f2;
        } else {
            ans[arr.get(i)] = f3;
        }
    }
    for (int i = 0; i < n; i++) {
        System.out.print(ans[i] + " ");
    }
}