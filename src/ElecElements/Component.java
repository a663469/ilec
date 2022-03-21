package ElecElements;

public abstract class Component {
    private String name;

    public Component(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }
}
