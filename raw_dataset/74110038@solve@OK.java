void solve() throws IOException {
    int n = ni();
    int[] a = new int[n];
    int girl_unmarried = -1;
    for (int i = 0; i < n; i++) {
        int k = ni();
        boolean found = false;
        for (int j = 0; j < k; j++) {
            int ki = ni();
            if (!found && a[ki - 1] == 0) {
                a[ki - 1] = i + 1;
                found = true;
            }
        }
        if (!found) {
            girl_unmarried = i;
        }
    }
    int kingdom = -1;
    for (int i = 0; i < n; i++) {
        if (a[i] == 0) {
            kingdom = i;
            break;
        }
    }
    if (girl_unmarried == -1 && kingdom == -1) {
        ob.println("OPTIMAL");
    } else {
        ob.println("IMPROVE");
        ob.println((girl_unmarried + 1) + " " + (kingdom + 1));
    }
}