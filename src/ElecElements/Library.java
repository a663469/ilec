package ElecElements;

import java.util.Locale;

public class Library {
    private int size_arr;
    private int count_cmps;
    private Component[] cmps;

    public Library(int size_arr) {
        this.size_arr = size_arr;
        cmps = new Component[this.size_arr];
    }

    public Library() {
        this(50);
    }

    public boolean addNewComponent(String str) {
        boolean retVal = false;
        if(count_cmps < (size_arr - 1)) {

            for (String word : Resistors.getKeyName()) {
                if ((str.toLowerCase(Locale.ROOT)).indexOf(word) != -1) {
                    cmps[count_cmps] = new Resistors(str);
                    count_cmps++;
                    retVal = true;
                    break;
                }
            }

            for (String word : Capacitors.getKeyName()) {
                if ((str.toLowerCase(Locale.ROOT)).indexOf(word) != -1) {
                    cmps[count_cmps] = new Capacitors(str);
                    count_cmps++;
                    retVal = true;
                    break;
                }
            }
        }
        return retVal;
    }

    public void printComponents() {
        for(int i = 0; i < count_cmps; i++) {
            System.out.println((cmps[i]));
        }
    }



////    private Component[] cmps;
//    private int count_cmps;
//    private static int size_arr = 50;
//    //Temporarily, for testing
//    private static String[] keyName = {"резистор", "resistor"};
////    private Component Resistors;
////    private Component[] cmpsType = {Resistors};
//
//    public Library(int size_arr) {
//        this.size_arr = size_arr;
////        cmps = new Component[size_arr];
//        System.out.println("Created new Component lib");
//    }
//
//    public boolean addNewComponent(String str) {
//        if(size_arr > count_cmps) {
//            //A function that can tell which object can be created from the string str
//            // It is desirable to implement modularly
//            str = str.toLowerCase(Locale.ROOT);
////            for(Component cmp: cmpsType) {
//
//            }
//
////            if(str.indexOf("Резистор") == 0) {
////                cmps[count_cmps] = new Resistors(str);
//////            } else if (str.indexOf("Конденсатор") == 0) {
//////                cmps[count_cmps] = new Capacitors(str);
////            } else {
////                System.out.println("Failed to recognize the element");
////            }
////            System.out.println(str + " add to cmps");
////            count_cmps++;
////        } else {
////            System.out.println("The array is full");
//        }
//    }
//
//
//    public void printComponents() {
//        for(int i = 0; i < count_cmps; i++) {
//            System.out.println((cmps[i]));
//        }
//    }
//
//    public void resValue() {
//        for (Component a : cmps) {
//            if (a instanceof Resistors) {
//                System.out.println(((Resistors) a).getResistance());
//            }
//        }
//    }
}
