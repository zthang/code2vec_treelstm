@Override
public int compareTo(P arg0) {
    if (value == arg0.value) {
        return type - arg0.type;
    }
    return value - arg0.value;
}