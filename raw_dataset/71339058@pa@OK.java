static void pa(String arrayName, double[][] arr) {
    pl(arrayName + " : ");
    for (int i = 0; i < arr.length; ++i) {
        for (double o : arr[i]) p(o);
        pl();
    }
}