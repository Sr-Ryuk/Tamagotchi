import java.util.Random;
import java.util.Scanner;

public class Main {

    private String nome;
    private int fome;
    private int felicidade;
    private int higiene;
    private int idade;
    private int energia;
    private int cicloVida;
    private int saude;

    public Main(String nome) {
        this.nome = nome;
        this.fome = 100;
        this.felicidade = 100;
        this.higiene = 100;
        this.idade = 0;
        this.energia = 100;
        this.saude = 100;
        this.cicloVida = 0;
    }

    public void mostrarStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade + " dias");

        if (fome <= 50) {
            System.out.println("Fome: " + fome + "%");
            System.out.println("(ALERTA) " + nome + " está com fome!");
        } else {
            System.out.println("Fome: " + fome + "%");
        }

        System.out.println("Felicidade: " + felicidade + "%");

        if (higiene <= 50) {
            System.out.println("(ALERTA) " + nome + " está sujo!");
            System.out.println("Higiene: " + higiene + "%");
        } else {
            System.out.println("Higiene: " + higiene + "%");
        }

        if (energia <= 50) {
            System.out.println("(ALERTA) " + nome + " está cansado!");
            System.out.println("Energia: " + energia + "%");
        } else if (energia >= 90) {
            System.out.println("(ALERTA) " + nome + " quer brincar!");
            System.out.println("Energia: " + energia + "%");
        } else {
            System.out.println("Energia: " + energia + "%");
        }

        System.out.println("Saúde: " + saude + "%");

        if (idade >= 0 && idade <= 3) {
            System.out.println("Estágio de Vida: Criança");
        } else if (idade >= 4 && idade <= 7) {
            System.out.println("Estágio de Vida: Adulto");
        } else if (idade >= 8 && idade <= 12) {
            System.out.println("Estágio de Vida: Velho");
        } else {
            System.out.println("Estágio de Vida: Ancestral");
        }
    }

    public void alimentar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de comida:");
        System.out.println("1 - Banana");
        System.out.println("2 - Maçã");
        System.out.println("3 - Cenoura");
        System.out.println("4 - Pepino");
        System.out.println("5 - Morango");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                fome += 20;
                System.out.println(nome + ": * Chomp Chomp Chomp * Que delícia!");
                break;
            case 2:
                fome += 15;
                System.out.println(nome + ": * Munch Munch Munch * Delicioso!");
                break;
            case 3:
                fome += 10;
                System.out.println(nome + ": * Crunch Crunch Crunch * Estou gostando disso!");
                break;
            case 4:
                fome += 10;
                System.out.println(nome + ": * Slurp Slurp Slurp * Que refrescante!");
                break;
            case 5:
                fome += 25;
                System.out.println(nome + ": * Nom Nom Nom * Uau, que saboroso!");
                break;
            default:
                System.out.println("Opção de alimento inválida!");
                return;
        }

        if (fome > 100) {
            fome = 100;
        }
    }

    public void brincar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de brincadeira:");
        System.out.println("1 - Correr no Parque");
        System.out.println("2 - Jogar Bola");
        System.out.println("3 - Brincar de Esconde-Esconde");
        System.out.println("4 - Pular Corda");
        System.out.println("5 - Brincar com Bolhas de Sabão");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                felicidade += 20;
                higiene -= 20;
                energia -= 20;
                fome -= 15;
                System.out.println(nome + ": Que legal! Correr no parque é muito divertido!");
                break;
            case 2:
                felicidade += 15;
                higiene -= 15;
                energia -= 15;
                fome -= 15;
                System.out.println(nome + ": Vamos jogar bola, isso vai ser demais!");
                break;
            case 3:
                felicidade += 10;
                higiene -= 10;
                energia -= 10;
                fome -= 15;
                System.out.println(nome + ": Onde será que ele está? Haha, essa brincadeira é ótima!");
                break;
            case 4:
                felicidade += 10;
                higiene -= 10;
                energia -= 10;
                fome -= 15;
                System.out.println(nome + ": Pular corda é uma diversão saudável!");
                break;
            case 5:
                felicidade += 25;
                higiene -= 25;
                energia -= 25;
                fome -= 15;
                System.out.println(nome + ": Olha só as bolhas! Isso é muito legal!");
                break;
            default:
                System.out.println("Opção de brincadeira inválida!");
                return;
        }
    }

    public void limpar() {
        if (higiene < 100) {
            higiene = 100;
            energia -= 5;

            System.out.println(nome + ": Adoro tomar banho de espuma!");
        } else {
            System.out.println(nome + ": Já estou limpo. Não é necessário outro banho agora.");
        }
    }

    public void dormir() {
        if (energia < 100) {
            energia = 100;
            System.out.println(nome + ": Zzz... Zzz... Zzz...");
        } else {
            System.out.println(nome + ": Eu já descansei bastante.");
        }
    }

    public void passarTempo() {
        fome -= 10;
        felicidade -= 10;
        higiene -= 10;
        energia += 10;
        idade++;

        if (fome <= 0 || felicidade <= 0 || higiene <= 0) {
            System.out.println("Essa não! " + nome + " morreu! :(");
            System.exit(0);
        }

        // Chamando o método para eventos aleatórios
        eventosAleatorios();
    }

    // Método para eventos aleatórios
    private void eventosAleatorios() {
        Random random = new Random();
        int evento = random.nextInt(3); // Gera um número aleatório de 0 a 2

        switch (evento) {
            case 0:
                // Evento: Tamagotchi encontra um petisco
                System.out.println(nome + " encontrou um petisco! Sua fome diminui e sua felicidade aumenta!");
                fome += 10;
                felicidade += 20;
                break;
            case 1:
                // Evento: Tamagotchi está com sede
                System.out.println(nome + " está com sede! Sua energia diminui.");
                energia -= 15;
                break;
            case 2:
                // Evento: Tamagotchi está entediado
                System.out.println(nome + " está entediado! Sua felicidade diminui.");
                felicidade -= 15;
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do seu Tamagotchi: ");
        String nome = scanner.nextLine();

        Main tamagotchi = new Main(nome);

        while (true) {
            tamagotchi.mostrarStatus();

            System.out.println("O que você quer fazer?");
            System.out.println("1 - Alimentar");
            System.out.println("2 - Brincar");
            System.out.println("3 - Limpar");
            System.out.println("4 - Passar tempo");
            System.out.println("5 - Dormir");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    tamagotchi.alimentar();
                    break;
                case 2:
                    tamagotchi.brincar();
                    break;
                case 3:
                    tamagotchi.limpar();
                    break;
                case 4:
                    tamagotchi.passarTempo();
                    break;
                case 5:
                    tamagotchi.dormir();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção de 0 a 5.");
            }
        }
    }
}
