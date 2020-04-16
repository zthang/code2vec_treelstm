public void close() {
    try {
        mIs.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}