public class Dictionary <K, V> {
    private K key;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    private V value;

    public Dictionary(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "- " + key + ": " + value;
    }

}
