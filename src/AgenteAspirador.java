import java.util.List;
import java.util.Random;

public class AgenteAspirador {
    private Sensor sensor;
    private Aspirador aspirador;
    private int estadoAtual;

    public AgenteAspirador() {
        this.sensor = new Sensor();
        this.aspirador = new Aspirador();
        this.estadoAtual = 0;
    }

    public void executar() {
        while (true) {
            List<Percepcao> percepcoes = sensor.perceberAmbiente();
            atualizarEstado(percepcoes);
            Acao acao = selecionarAcao();
            executarAcao(acao);
        }
    }

    private void atualizarEstado(List<Percepcao> percepcoes) {
        Random random = new Random();
        estadoAtual = random.nextInt(3); // Assume-se 3 estados para este exemplo
    }

    private Acao selecionarAcao() {
        Random random = new Random();
        int acaoIndex = random.nextInt(Acao.values().length);
        return Acao.values()[acaoIndex];
    }
    private void executarAcao(Acao acao) {
        switch (acao) {
            case MOVER_FRENTE:
                System.out.println("Movendo para frente...");
                break;
            case MOVER_TRAS:
                System.out.println("Movendo para trás...");
                break;
            case GIRAR_DIREITA:
                System.out.println("Girando para direita...");
                break;
            case GIRAR_ESQUERDA:
                System.out.println("Girando para esquerda...");
                break;
            case ASPIRAR:
                aspirador.aspirar();
                break;
            default:
                System.out.println("Ação inválida!");
        }
    }
    public static void main(String[] args) {
        AgenteAspirador agente = new AgenteAspirador();
        agente.executar();
    }
}
