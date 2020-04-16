public void print(Object a) {
    try {
        bw.write(a.toString());
    } catch (Exception e) {
    }
}