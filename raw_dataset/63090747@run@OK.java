void run() {
    if (!work()) {
        out.println(-1);
    }
    out.flush();
}