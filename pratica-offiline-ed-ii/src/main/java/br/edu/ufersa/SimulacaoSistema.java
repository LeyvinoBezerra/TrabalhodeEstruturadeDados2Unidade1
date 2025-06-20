package br.edu.ufersa;

import java.time.LocalDateTime;
import java.util.Random;

public class SimulacaoSistema {
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        Cliente cliente = new Cliente(servidor);

        for (int i = 1; i <= 10; i++) {
            servidor.inserirRegistro(new RegistroClimatico(
                i, "MC-" + (i % 5), LocalDateTime.now(),
                new Random().nextDouble() * 40,
                new Random().nextDouble() * 100,
                new Random().nextDouble() * 1100
            ));
        }

        cliente.consultarId(5);
        cliente.alterarRegistro(5, 22.5, 65.0, 1012.0);
        cliente.consultarId(5);

        cliente.removerRegistro(3);
        cliente.consultarId(3);

        cliente.listarTudo();
    }
}
