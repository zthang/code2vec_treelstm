static boolean next_permutation(int[] per) {
    if (per.length < 2) {
        return false;
    }
    int i;
    for (i = per.length - 1; i > 0; i--) {
        if (per[i - 1] < per[i]) {
            break;
        }
    }
    if (0 < i) {
        i--;
        int tmp;
        int j;
        for (j = per.length - 1; j > i; j--) {
            if (per[j] > per[i]) {
                break;
            }
        }
        // swap(i,j)
        tmp = per[i];
        per[i] = per[j];
        per[j] = tmp;
        for (int k = i + 1; k < (i + 1 + per.length) / 2; k++) {
            // swap(k,per.length-k+i)
            tmp = per[k];
            per[k] = per[per.length - k + i];
            per[per.length - k + i] = tmp;
        }
        return true;
    }
    int tmp;
    for (int k = 0; k < per.length; k++) {
        // swap(k,per.length-k-1)
        tmp = per[k];
        per[k] = per[per.length - k - 1];
        per[per.length - k - 1] = tmp;
    }
    return false;
}