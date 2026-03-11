import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu(banco, sc);
        menu.iniciar();
        sc.close();
    }
}