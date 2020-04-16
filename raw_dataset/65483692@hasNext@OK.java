boolean hasNext() {
    try {
        return reader.ready();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return false;
}