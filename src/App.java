import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> lista1 = new LinkedList<>();
        LinkedList<Integer> lista2 = new LinkedList<>();

        try (Scanner input = new Scanner(System.in)) {
            Random random = new Random();
            
            // Solicitado o tamanho das listas
            System.out.print("Digite o tamanho da lista 1: ");
            int tamanhoLista1 = input.nextInt();
            if (tamanhoLista1 <= 0) {
                System.out.println("Digite um valor válido para o tamanho da lista 1!");
                return;
            }
            
            System.out.print("Digite o tamanho da lista 2: ");
            int tamanhoLista2 = input.nextInt();
                if (tamanhoLista2 <= 0) {
                System.out.println("Digite um valor válido para o tamanho da lista 2!");
                return;
            }
            
            // Populando as listas com números aleatórios
            for (int i = 0; i < tamanhoLista1; i++) {
                lista1.add(random.nextInt(51));
            }
            
            for (int i = 0; i < tamanhoLista2; i++) {
                lista2.add(random.nextInt(51));
            }
            
            lista1.sort(null);
            System.err.print("Lista 1: " + lista1);
            
            lista2.sort(null);
            System.err.print("\nLista 2: " + lista2);
            
            System.out.println("\nLista Final Ordenada: "+ intercalaEmOrdem(lista1, lista2));
        }
    }

    public static LinkedList<Integer> intercalaEmOrdem(LinkedList<Integer> a, LinkedList<Integer> b) {
        LinkedList<Integer> listaFinal = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) {
                listaFinal.add(a.get(i));
                i++;
            } else {
                listaFinal.add(b.get(j));
                j++;
            }
        }
        // Se restar numero em a
        while (i < a.size()) {
            listaFinal.add(a.get(i));
            i++;
        }

        // Se restar numero em b
        while (j < b.size()) {
            listaFinal.add(b.get(j));
            j++;
        }
        
        return listaFinal;
    }
}
