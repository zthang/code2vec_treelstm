static void smallLIS(String s, int n) {
    int[] A = new int[n];
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '<') {
            int last = i;
            while (last + 1 < s.length() && s.charAt(last + 1) == '<') {
                last++;
            }
            int tmplast = last;
            while (last >= i) {
                A[last + 1] = n;
                n--;
                last--;
            }
            i = tmplast;
        }
    }
    for (int i = 0; i < s.length() + 1; i++) {
        if (A[i] == 0) {
            A[i] = n;
            n--;
        }
    }
    for (int i = 0; i < s.length() + 1; i++) {
        System.out.print(A[i] + " ");
    }
    System.out.println();
}