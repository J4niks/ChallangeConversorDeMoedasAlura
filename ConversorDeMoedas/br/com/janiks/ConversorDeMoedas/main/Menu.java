package br.com.janiks.ConversorDeMoedas.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import br.com.janiks.ConversorDeMoedas.API.ApiConnection;

public class Menu {
    private String menu = """
                ********************************************
                  Seja bem-vindo/a ao Conversor de Moeda =]
                        1) Dólar =>> Peso Argentino
                        2) Dólar =>> Peso Colombiano
                        3) Dólar =>> Real Brasileiro
                        4) Euro =>> Real Brasileiro
                        5) Peso Argentino =>> Dólar
                        6) Peso Colombiano =>> Dólar
                        7) Real Brasileiro =>> Dólar
                        8) Real Brasileiro =>> Euro
                        9) Histórico de conversões
                        10) Sair
                  Escolha uma opção válida:
                ********************************************
                """;
    private String value = "Qual valor deseja fazer a conversão?";
    private String option = "Indisponivel";
    private int selected = 0;



    public void selection() {
        Scanner sc = new Scanner(System.in);

        while (selected != 10) {
            try{
                System.out.println(menu);
                selected = sc.nextInt();

                switch (selected) {
                    case 1:
                        option = "USD-ARS";
                        break;
                    case 2:
                        option = "USD-COP";
                        break;
                    case 3:
                        option = "USD-BRL";
                        break;
                    case 4:
                        option = "EUR-BRL";
                        break;
                    case 5:
                        option = "ARS-USD";
                        break;
                    case 6:
                        option = "COP-USD";
                        break;
                    case 7:
                        option = "BRL-USD";
                        break;
                    case 8:
                        option = "BRL-EUR";
                        break;
                    case 9:
                        option = "historico";
                        break;
                    case 10:
                        option = "Sair";
                        break;

                    default:
                        option = "Indisponivel";
                }
                selectedOption(option);
            }catch (InputMismatchException e){
                System.out.println("Entrada invalida!\n"+ e);
                this.selection();
            }catch (Exception e){
                System.out.println("Erro desconhecido:\n "+ e);
            }

        }
    }

    private String value(){
        try{
            System.out.println("\n\n"+value);
            Scanner sc = new Scanner(System.in);
            String inputValue = sc.next().replace(",",".");
            return inputValue;

        }catch (InputMismatchException | NumberFormatException e){
            System.out.println("Entrada invalida!\n"+ e);
            return this.value();
        }catch (Exception e){
            System.out.println("Erro desconhecido:\n "+ e);
            return this.value();
        }
    }

    private void selectedOption(String option){
        if (option.equalsIgnoreCase("indisponivel")){
            System.out.println("Opção indisponível");
            selection();
        }else if (option.equalsIgnoreCase("sair")){
            System.out.println("Saindo...");
        }else if(option.equalsIgnoreCase("historico")){
            System.out.println("historico");
        }
        else{
            String[] parts = option.split("-");

            ApiConnection connect = new ApiConnection();
            connect.Connection(parts[0],parts[1], value());
        }
    }
}
