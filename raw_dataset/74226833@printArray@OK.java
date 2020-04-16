public void printArray(int[] arr) throws IOException {
    for (int i = 0; i < arr.length; i++) {
        if (i == arr.length - 1) {
            System.out.println(arr[i]);
        }
        System.out.print(arr[i] + " ");
    }
}