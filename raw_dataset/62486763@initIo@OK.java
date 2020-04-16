static void initIo(boolean isFileIO) throws IOException {
    scan = new MyScanner(isFileIO);
    if (isFileIO) {
        pw = new PrintWriter("/Users/amandeep/Desktop/output.txt");
    } else {
        pw = new PrintWriter(System.out, true);
    }
}