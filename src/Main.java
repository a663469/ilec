import ElecElements.Library;
import ElecElements.Resistors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Library lib = new Library(21);

        //Пока не пройдана курс по чтению данных из файла, будум делать так:
        String[] cmp_arr_str = {
                "Конденсатор 0,1 мкФ 50В, 0805, X7R",
                "Конденсатор 0,47 мкФ 25В, 0603, X7R ",
                "Конденсатор 0,68 мкФ 50В, 0603, X7R ",
                "Конденсатор 1 мкФ 16В, 0402, X5R ",
                "Конденсатор 5,6 пФ 50В, 0402, C0G ",
                "Резистор 3 кОм, 0603, 5% ",
                "Резистор 0 Ом, 0402, 5% 0,63 Вт ",
                "Резистор 10 кОм, 0402, 5% ",
                "Резистор 10 кОм, 0603, 1% ",
                "Резистор 10 кОм, 0603, 0,1% ",
                "Резистор 10 Ом, 0603, 5% 0,1 Вт ",
                "Резистор 110 Ом, 1206, 5% ",
                "Резистор 15 Ом, 0805, 5% ",
                "Резистор 3,9 МОм, 1206, 1% (1206)"};


        for(String str: cmp_arr_str) {
            lib.addNewComponent(str);
        }

        lib.printComponents();


    }
}
