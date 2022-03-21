package ElecElements;

public class Resistors extends Component implements ComponentInterface{
    private String resistance;
    private String tolerance;
    private String caseSize;
    private static String[] keyName = {"резистор", "resistor"};


    public Resistors(String str) {
        super(str);
    }

//    @Override
    public static String[] getKeyName() {
        return keyName;
    }

//    private boolean checkName(String str) {
//        String[] str_arr = str.split(" ");
//        if(str_arr.length > 4) {
//            this.resistance = str_arr[1] + str_arr[2];
//            this.caseSize = str_arr[3];
//            this.tolerance = str_arr[4];
//            return true;
//        }
//        return false;
//    }
//

//    public String toString() {
//        return "Resistor " + resistance + " " + tolerance + " " + caseSize;
//    }

    public String getResistance() {
        return resistance;
    }
}
