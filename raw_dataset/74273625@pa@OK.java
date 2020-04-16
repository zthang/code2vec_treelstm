static void pa(double[][] arr) {
    for (int i = 0; i < arr.length; ++i) {
        for (double o : arr[i]) {
            p(o);
        }
        pl();
    }
}