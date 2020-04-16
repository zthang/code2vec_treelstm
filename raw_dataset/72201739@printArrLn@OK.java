<T> void printArrLn(T[] arr) throws IOException {
    for (int i = 0; i < arr.length - 1; i++) {
        print(arr[i] + " ");
    }
    println(arr[arr.length - 1]);
}