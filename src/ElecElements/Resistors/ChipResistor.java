package ElecElements.Resistors;

import ElecElements.Component;

public class ChipResistor extends Component {
    private float Resistance;
    private String size;
    private float Tolerance;
    private String name;

    public ChipResistor(String str) {
        super(str);
    }

    public String getName() {
        return this.name;
    }
}
