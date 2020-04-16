public static int[] getMax() {
    int[] ans = new int[n];
    int num = 1;
    for (int i = 0; i < ans.length; i++) {
        if (arr[i] == '<') {
            int j = i;
            while (j != -1 && ans[j] == 0) {
                ans[j--] = num++;
            }
        }
    }
    return ans;
}