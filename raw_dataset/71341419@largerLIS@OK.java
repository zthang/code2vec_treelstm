static void largerLIS(String s, int n) {
    int[] A = new int[n];
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '<') {
            cnt++;
        }
    }
    int tmp = n - cnt + 1;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '<') {
            A[i + 1] = tmp;
            tmp++;
        }
    }
    tmp = n - cnt;
    for (int i = 0; i < s.length() + 1; i++) {
        if (A[i] == 0) {
            A[i] = tmp;
            tmp--;
        }
    }
    for (int i = 0; i < s.length() + 1; i++) {
        System.out.print(A[i] + " ");
    }
    System.out.println();
}