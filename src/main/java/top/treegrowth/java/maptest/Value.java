package top.treegrowth.java.maptest;

import java.util.Objects;

/**
 * @author Administrator
 */
public class Value {

    private String id;
    private String value;


    public Value() {
    }

    public Value(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Value)) return false;
        Value value1 = (Value) o;
        return Objects.equals(getId(), value1.getId()) &&
                Objects.equals(getValue(), value1.getValue());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getValue());
    }
}
