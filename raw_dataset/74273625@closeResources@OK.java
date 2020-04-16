private static void closeResources() throws IOException {
    pw.flush();
    pw.close();
    scan.close();
}