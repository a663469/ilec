package ElecElements;

import ElecElements.Capacitors.ChipCapacitor;
import ElecElements.Resistors.ChipResistor;

public class Library {

    private Component[] cmps;
    private int count_cmps;
    private static int size_arr = 50;

    public Library(int size_arr) {
        this.size_arr = size_arr;
        cmps = new Component[size_arr];
        System.out.println("Created new Component lib");
    }

    public void addNewComponent(String str) {
        if(size_arr > count_cmps) {
            if(str.indexOf("Резистор") == 0) {
                cmps[count_cmps] = new ChipResistor(str);
            } else if (str.indexOf("Конденсатор") == 0) {
                cmps[count_cmps] = new ChipCapacitor(str);
            } else {
                System.out.println("Failed to recognize the element");
            }
            System.out.println(str + " add to cmps");
            count_cmps++;
        } else {
            System.out.println("The array is full");
        }
    }


    public void printComponents() {
        for(int i = 0; i < count_cmps; i++) {
            System.out.println((cmps[i]));
        }
    }

    public void resValue() {
        for (Component a : cmps) {
            if (a instanceof ChipResistor) {
                System.out.println(((ChipResistor) a).getResistance());
            }
        }
    }
}
