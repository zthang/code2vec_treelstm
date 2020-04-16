public static <E> void print2D(E[][] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            pw.println(arr[i][j]);
        }
    }
}