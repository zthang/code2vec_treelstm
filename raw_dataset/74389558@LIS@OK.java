static void LIS(int n, int[] arr, int m) {
    I = new int[n + 1];
    I[0] = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
        I[i] = Integer.MAX_VALUE;
    }
    int lisLength = 0;
    for (int i = 0; i < n; i++) {
        int low = 0;
        int high = lisLength;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (I[mid] < arr[i]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        I[low] = arr[i];
        if (low > lisLength) {
            lisLength = low;
        }
        if (lisLength == m) {
            for (int j = 1; j <= low; j++) {
                if (I[j] == low) {
                    System.out.println(I[j]);
                } else {
                    System.out.print(I[j] + " ");
                }
            }
            return;
        }
    }
    System.out.println("Impossible");
}