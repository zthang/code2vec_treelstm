@Override
public int compareTo(node o) {
    if (db == o.db)
        return o.de - de;
    return db - o.db;
}