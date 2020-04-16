void work() {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] A = new int[n];
    int[] B = new int[n];
    for (int i = 0; i < n; i++) {
        A[i] = in.nextInt() - 1;
    }
    for (int i = 0; i < n; i++) {
        B[i] = in.nextInt() - 1;
    }
    int[] rec = new int[n];
    int[] count = new int[200004];
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        count[A[i]]++;
        if (count[A[i]] == 1) {
            cnt++;
        } else if (count[A[i]] == 0) {
            cnt--;
        }
        count[B[i]]--;
        if (count[B[i]] == -1) {
            cnt++;
        } else if (count[B[i]] == 0) {
            cnt--;
        }
        if (cnt == 0) {
            rec[i] = 1;
        }
    }
    int c = 0;
    for (int i = 0; i < n; i++) {
        if (rec[i] == 1)
            c++;
    }
    if (c < k) {
        out.println("NO");
        return;
    }
    out.println("YES");
    char[] ret = new char[n];
    char cur = 'a';
    for (int i = 0; i < n; i++) {
        int index = A[i];
        ret[index] = cur;
        if (rec[i] == 1 && cur < 'z') {
            cur++;
        }
    }
    for (int i = 0; i < n; i++) {
        out.print(ret[i]);
    }
}