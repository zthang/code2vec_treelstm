static void solve() throws IOException {
    int n = Reader.nextInt();
    int m = Reader.nextInt();
    int[][] arr = new int[n][2];
    long sum = 0;
    for (int i = 0; i < n; i++) {
        arr[i][0] = Reader.nextInt();
        arr[i][1] = i + 1;
        sum += arr[i][0];
    }
    sum *= 2;
    sortbyColumn(arr, 0);
    int num1 = arr[0][1];
    int num2 = arr[1][1];
    int s1 = arr[0][0];
    int s2 = arr[1][0];
    if (n == 2) {
        System.out.println(-1);
        return;
    }
    if (m < n) {
        System.out.println(-1);
        return;
    }
    // System.out.println(sum);
    sum += (m - n) * (s1 + s2);
    System.out.println(sum);
    for (int i = 1; i < n; i++) {
        System.out.println(i + " " + (i + 1));
    }
    System.out.println(n + " " + 1);
    for (int i = 0; i < m - n; i++) {
        System.out.println(num1 + " " + num2);
    }
}