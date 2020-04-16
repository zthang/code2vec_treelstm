@Override
public int compareTo(Object otherLock) {
    return Integer.compare(this.val, ((Lock) otherLock).val);
}