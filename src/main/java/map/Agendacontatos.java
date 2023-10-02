package main.java.map;

import java.util.HashMap;
import java.util.Map;

public class Agendacontatos {

    private Map<String, Integer> agendaContatoMap;

    public Agendacontatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if (!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContatos() {
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if (!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        Agendacontatos agendacontatos = new Agendacontatos();

        agendacontatos.adicionarContato("David", 81988123);
        agendacontatos.adicionarContato("David", 811235);
        agendacontatos.adicionarContato("David J", 11111111);
        agendacontatos.adicionarContato("David F", 81988445);
        agendacontatos.adicionarContato("Mª S", 11111111);
        agendacontatos.adicionarContato("David", 44848);

        agendacontatos.exibirContatos();

        agendacontatos.removerContato("David J");

        agendacontatos.exibirContatos();

        System.out.println("O número é: " + agendacontatos.pesquisarPorNome("David"));
    }

}
