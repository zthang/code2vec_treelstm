private int scan() {
    try {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0)
                return -1;
        }
        return buf[index++];
    } catch (Exception e) {
        return 7 / 0;
    }
}