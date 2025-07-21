import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String entrada;
        System.out.println("Digite a rolagem no formato RPG (ex: 3d6, 2d10+1, 1d20-2), ou 'sair' para encerrar.");

        while (true){
            System.out.println("\nSua rolagem: ");
            entrada = sc.nextLine().trim().toLowerCase();

            if (entrada.equals("sair")){
                System.out.println("Encerradno...");
                break;
            }

            //Regex
            Pattern pattern = Pattern.compile("(\\d+)d(\\d+)([+-]\\d+)?");
            Matcher matcher = pattern.matcher(entrada);

            if (matcher.matches()){
                int quantidade = Integer.parseInt(matcher.group(1));
                int lados = Integer.parseInt(matcher.group(2));
                int modificador = 0;

                if (matcher.group(3) != null){
                    modificador = Integer.parseInt(matcher.group(3));
                }

                if(quantidade <=0 || lados <=1 || lados%2 != 0){
                    System.out.println("Valores inválidos. Use dados com lados pares maiores que 1.");
                    continue;
                }

                int soma = 0;
                System.out.println("Rolando...");
                for (int i = 0; i < quantidade; i++) {
                    int resultado = random.nextInt(lados)+1;
                    System.out.println("Dado: " + (i+1) + ": " + resultado);
                    soma+=resultado;
                }

                soma+=modificador;
                System.out.println("Total com modificador (" + modificador + "): " + soma);
            }else {
                System.out.println("Formato inválido. Use algo como '2d6+1', '1d20', etc.");
            }
        }

        sc.close();
    }
}