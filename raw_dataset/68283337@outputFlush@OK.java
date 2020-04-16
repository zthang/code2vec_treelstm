static void outputFlush(Object o) {
    try {
        out.write("" + o + "\n");
        out.flush();
    } catch (Exception e) {
    }
}