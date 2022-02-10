package ElecElements.Capacitors;

import ElecElements.Component;

public class ChipCapacitor extends Component {
    private float capacity;
    private String size;
    private float tolerance;
    private String name;

    public ChipCapacitor(String str) {
        super(str);
    }

    public String getName() {
        return this.name;
    }
}
