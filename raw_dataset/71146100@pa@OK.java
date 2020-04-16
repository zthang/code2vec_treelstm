static void pa(String arrayName, boolean[][] arr) {
    pl(arrayName + " : ");
    for (int i = 0; i < arr.length; ++i) {
        for (boolean o : arr[i]) p(o);
        pl();
    }
}