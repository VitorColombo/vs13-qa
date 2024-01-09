import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        //TRATANDO ENTRADA POR SCANNER NA MAIN
//        System.out.println("Digite um numero: ");
//        Scanner scan = new Scanner(System.in);
//        String entrada = scan.nextLine();
//        int escolha;
//
//        try{
//            escolha = Integer.parseInt(entrada);
//            System.out.println(entrada);
//        }catch(NumberFormatException e){
//            System.err.println("Por favor, digite um numero.");
//        }

        //STRING
        //com String literal ---> string pool
        String nome = "Mayra";
        String nome1 = "Mayra";
        nome.concat(("oi"));
        System.out.println(nome);
        System.out.println(nome == nome1);
        nome = nome.concat("oi");
        System.out.println(nome + nome1);

        // com String Object
        String nome3 = new String ("Mayra");
        String nome4 = new String ("Mayra");

        System.out.println(nome3 == nome4);

        //API DE DATA

        Locale localeBrasil = new Locale("pt", "BR");
        LocalDate localDate = LocalDate.of(2024, Month.DECEMBER, 5);
        System.out.println(localDate.getDayOfYear());
        DayOfWeek dia = localDate.getDayOfWeek();
        System.out.println(dia);
        System.out.println(dia.getDisplayName(TextStyle.FULL, localeBrasil));

        String date = "2023-11-10";
        LocalDate localDateDois = LocalDate.parse(date);
        System.out.println(localDateDois);
        System.out.println(localDateDois.minusDays(10));

        System.out.println(localDateDois.compareTo(localDate));

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime2 = LocalDateTime.of(2024, 1,05, 14, 45);
        System.out.println(localDateTime2);
        System.out.println(localDateTime.isAfter(localDateTime2));

        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

    }
}















