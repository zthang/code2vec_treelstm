public void println(int[] array) {
    for (int i = 0; i < array.length; i++) {
        if (i > 0)
            print(' ');
        print(array[i]);
    }
    println();
}