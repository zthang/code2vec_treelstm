void close() {
    try {
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}