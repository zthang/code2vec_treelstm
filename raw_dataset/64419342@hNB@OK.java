private boolean hNB() {
    if (p < bl) {
        return true;
    } else {
        p = 0;
        try {
            bl = in.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bl <= 0) {
            return false;
        }
    }
    return true;
}