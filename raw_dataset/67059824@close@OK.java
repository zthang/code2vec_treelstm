public void close() {
    try {
        this.input.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}