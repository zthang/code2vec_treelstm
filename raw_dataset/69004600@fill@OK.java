private void fill(char[] a, int lo, int c, char letter) {
    // System.out.println("fill " + lo + " " + c + " " + letter);
    for (int i = lo; i < lo + c; i++) a[i] = letter;
}