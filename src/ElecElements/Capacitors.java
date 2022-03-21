package ElecElements;

public class Capacitors extends Component implements ComponentInterface{
    private String capacity;
    private String voltage;
    private String caseSize;
    private String dielectric;
    private static String[] keyName = {"конденсатор", "capacitors"};

    public Capacitors(String str) {
        super(str);
//        super(str);
//        if(checkName(str)) {
//            System.out.println("Add new Cap!");
//        } else {
//            System.out.println("Error in the name!");
//        }
    }
//
//    private boolean checkName(String str) {
//        String[] str_arr = str.split(" ");
//        if(str_arr.length > 5) {
//            this.capacity = str_arr[1] + str_arr[2];
//            this.voltage = str_arr[3];
//            this.caseSize = str_arr[4];
//            this.dielectric = str_arr[5];
//            return true;
//        }
//        return false;
//    }
//
//    public String toString() {
//        return "Capacitor " + capacity + " " + voltage + " " + caseSize + " " + dielectric;
//    }
    public static String[] getKeyName() {
        return keyName;
    }
}
