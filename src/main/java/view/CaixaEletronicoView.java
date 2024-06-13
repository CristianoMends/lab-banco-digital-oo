package view;

import java.util.Scanner;

public class CaixaEletronicoView {
    Scanner scanner = new Scanner(System.in);
    public void exibir(Object obj){
        System.out.println(obj);
    }
    public String input(){
        return scanner.nextLine();
    }
}
