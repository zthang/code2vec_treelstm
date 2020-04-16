private boolean readLINE() throws IOException {
    if ($readCount == EOF) {
        return false;
    }
    for (itr = 0; ; ) {
        while ($index < $readCount) {
            if (buffer[$index] != NL) {
                if (itr == cBuff.length) {
                    inc();
                }
                cBuff[itr++] = (char) buffer[$index++];
            } else {
                $index++;
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