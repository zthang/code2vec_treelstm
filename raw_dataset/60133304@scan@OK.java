private int scan() {
    if (INDEX >= TOTAL) {
        INDEX = 0;
        try {
            TOTAL = in.read(buf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TOTAL <= 0)
            return -1;
    }
    return buf[INDEX++];
}