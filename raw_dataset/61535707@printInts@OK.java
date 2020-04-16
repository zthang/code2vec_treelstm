public void printInts(int[] values) {
    for (int i = 0; i < values.length; i++) {
        if (i > 0)
            print(" ");
        print(values[i]);
    }
    println();
}