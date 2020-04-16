public void printArray(long[] arr) {
    for (int i = 0; i < arr.length; i++) {
        if (i != 0) {
            writer.print(' ');
        }
        writer.print(arr[i]);
    }
}