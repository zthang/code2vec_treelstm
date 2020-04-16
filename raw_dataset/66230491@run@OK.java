private void run() throws IOException {
    fr = new FastReader();
    out = new BufferedOutputStream(System.out);
    solve();
    out.flush();
    out.close();
}