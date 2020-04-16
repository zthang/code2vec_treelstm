static void writeLines(long[] as) {
    PrintWriter pw = new PrintWriter(System.out);
    for (long a : as) pw.println(a);
    pw.flush();
}