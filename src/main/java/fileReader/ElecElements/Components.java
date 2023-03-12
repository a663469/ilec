package fileReader.ElecElements;

import fileReader.ElecElements.Resistors.ChipResistor;

public class Components {

    private Component[] cmps;
    private int count_cmps;

    public Components() {
        cmps = new Component[50];
        System.out.println("Created new Component lib");
    }

    public void addNewComponents(String str) {
        cmps[count_cmps] = new ChipResistor(str);
        System.out.println(str + " add to cmps");
        count_cmps++;
    }

    public void printComponents() {
        for(int i = 0; i < count_cmps; i++) {
            System.out.println((cmps[i]).getCodeComponent() + " from cmps");
        }
    }
}
