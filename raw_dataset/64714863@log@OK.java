static void log(long[] X) {
    if (verb) {
        for (long U : X) System.err.print(U + " ");
        System.err.println("");
    }
}