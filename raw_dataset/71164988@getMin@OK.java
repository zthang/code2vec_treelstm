public static void getMin(int i, int j, int l, int r) {
    if (i > j)
        return;
    int fidx = -1;
    int sidx = -1;
    for (int k = i; k < j; k++) {
        if (fidx == -1 && arr[k] == '<') {
            fidx = k;
            sidx = k;
        }
        if (fidx != -1) {
            if (arr[k] == '<')
                sidx = k;
            else
                break;
        }
    }
    if (fidx == -1) {
        int cur = r;
        for (int k = i; k <= j; k++) {
            min[k] = cur--;
        }
    } else {
        int before = fidx - i;
        int cur = r - before;
        for (int k = sidx + 1; k >= fidx; k--) min[k] = cur--;
        // System.out.println(Arrays.toString(min)+" "+sidx);
        getMin(i, fidx - 1, min[sidx + 1] + 1, r);
        getMin(sidx + 2, j, l, min[fidx] - 1);
    }
}