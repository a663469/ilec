package ElecElements;

public abstract class Component implements ComponentInterface{

    private String name;

    public Component(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //abstract public Component(String str);

    //abstract public String getInitialStr();
}
