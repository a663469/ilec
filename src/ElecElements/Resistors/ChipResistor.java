package ElecElements.Resistors;

import ElecElements.Component;

public class ChipResistor extends Component {
    private String resistance;
    private String tolerance;
    private String caseSize;

    public ChipResistor(String str) {
        super(str);
        if(checkName(str)) {
            System.out.println("Add new Res!");
        } else {
            System.out.println("Error in the name!");
        }
    }

    private boolean checkName(String str) {
        String[] str_arr = str.split(" ");
        if(str_arr.length > 4) {
            this.resistance = str_arr[1] + str_arr[2];
            this.caseSize = str_arr[3];
            this.tolerance = str_arr[4];
            return true;
        }
        return false;
    }

    public String toString() {
        return "Resistor " + resistance + " " + tolerance + " " + caseSize;
    }

    public String getResistance() {
        return resistance;
    }
}
