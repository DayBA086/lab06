
public class Test2 {
    public static void main(String[] args) {
        String[] pruebas = {
            "()()()[()]()",
            "((()))[]",
            "([])[](",
            "([{)]}",
            "[",
            "[][][]{{{}}}"
        };

        for (String s : pruebas) {
            System.out.println("Entrada: " + s + " -> " + Application.symbolBalancing(s));
        }
    }
}
