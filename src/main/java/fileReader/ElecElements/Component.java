package fileReader.ElecElements;

public class Component {
    private Object component;
    private String[] partNumbers;
    private int id;
    private String codeComponent; //Зашифраованный код компонента по своим правилам

    public Component(String str) {
        this.codeComponent = str;
    }

    public String getCodeComponent() {
        return codeComponent;
    }
}
