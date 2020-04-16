static StringBuilder printArr(int[] arr) {
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
        ans.append(arr[i] + " ");
    }
    return ans;
}