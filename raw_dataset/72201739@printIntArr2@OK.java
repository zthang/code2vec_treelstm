void printIntArr2(int[][] arr) throws IOException {
    for (int j = 0; j < arr.length; j++) {
        for (int i = 0; i < arr[j].length - 1; i++) {
            print(arr[j][i] + " ");
        }
        println(arr[j][arr.length - 1]);
    }
}