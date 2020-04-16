private boolean readPRT() throws IOException {
    if ($readCount == EOF) {
        return false;
    }
    T: for (; ; ) {
        while ($index < $readCount) {
            if (buffer[$index] > SPC) {
                break T;
            } else {
                $index++;
            }
        }
        $index = 0;
        $readCount = stream.read(buffer);
        if ($readCount == EOF) {
            return false;
        }
    }
    for (itr = 0; ; ) {
        while ($index < $readCount) {
            if (buffer[$index] > SPC) {
                if (itr == cBuff.length) {
                    inc();
                }
                cBuff[itr++] = (char) buffer[$index++];
            } else {
                return true;
            }
        }
        $index = 0;
        $readCount = stream.read(buffer);
        if ($readCount == EOF) {
            return true;
        }
    }
}