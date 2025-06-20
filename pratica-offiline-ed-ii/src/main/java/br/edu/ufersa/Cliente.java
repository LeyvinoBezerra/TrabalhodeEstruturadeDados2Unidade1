package br.edu.ufersa;

public class Cliente {
    Servidor servidor;

    public Cliente(Servidor servidor) {
        this.servidor = servidor;
    }

    public void consultarId(int id) {
        RegistroClimatico r = servidor.buscarPorId(id);
        if (r != null)
            System.out.println("Encontrado: " + r.idRegistro + " - " + r.idDispositivo);
        else
            System.out.println("Registro não encontrado.");
    }

    public void listarTudo() {
        servidor.listarRegistros();
    }

    public void removerRegistro(int id) {
        boolean sucesso = servidor.removerRegistro(id);
        System.out.println(sucesso ? "Remoção realizada." : "Registro não encontrado para remoção.");
    }

    public void alterarRegistro(int id, double temp, double umid, double press) {
        boolean sucesso = servidor.alterarRegistro(id, temp, umid, press);
        System.out.println(sucesso ? "Alteração realizada." : "Registro não encontrado para alteração.");
    }
}
