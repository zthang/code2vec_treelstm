void close() {
    try {
        stream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}