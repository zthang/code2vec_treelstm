static void merge(int[] arr, int[] arr2, int l, int m, int r) {
    int qwerty1 = m - l + 1;
    int qwerty2 = r - m;
    int[] left1 = new int[qwerty1];
    int[] left2 = new int[qwerty1];
    int[] right1 = new int[qwerty1];
    int[] right2 = new int[qwerty1];
    for (int i = 0; i < qwerty1; i++) {
        left1[i] = arr[l + i];
        left2[i] = arr2[l + i];
    }
    for (int i = 0; i < qwerty2; i++) {
        right1[i] = arr[m + i + 1];
        right2[i] = arr2[m + i + 1];
    }
    int i = 0, j = 0, k = l;
    while ((i < qwerty1) && (j < qwerty2)) {
        if (left1[i] < right1[j]) {
            arr[k] = left1[i];
            arr2[k] = left2[i];
            k++;
            i++;
        } else {
            arr[k] = right1[j];
            arr2[k] = right2[j];
            k++;
            j++;
        }
    }
    while (i < qwerty1) {
        arr[k] = left1[i];
        arr2[k] = left2[i];
        k++;
        i++;
    }
    while (j < qwerty2) {
        arr[k] = right1[j];
        arr2[k] = right2[j];
        k++;
        j++;
    }
}