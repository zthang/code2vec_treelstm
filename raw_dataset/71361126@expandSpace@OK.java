private void expandSpace(int len) {
    while (n < len) {
        n = Math.max(n + 10, n * 2);
    }
    int[] newData = new int[n];
    if (bpos <= epos) {
        if (bpos < epos) {
            System.arraycopy(data, bpos, newData, 0, epos - bpos);
        }
    } else {
        System.arraycopy(data, bpos, newData, 0, data.length - bpos);
        System.arraycopy(data, 0, newData, data.length - bpos, epos);
    }
    epos = size();
    bpos = 0;
    data = newData;
}