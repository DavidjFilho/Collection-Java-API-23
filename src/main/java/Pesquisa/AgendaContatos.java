package main.java.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));

    }

    public void exibirContatos() {
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato c : contatoSet) {
            if (c.getNome().startsWith(nome)) {
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        for (Contato c : contatoSet) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("David", 123456);
        agendaContatos.adicionarContato("David", 654654);
        agendaContatos.adicionarContato("David Filho", 111111);
        agendaContatos.adicionarContato("David D.", 654987);
        agendaContatos.adicionarContato("Mª S.", 1111111);

        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("David"));

        System.out.println("Contato atulizado: " + agendaContatos.atualizarNumeroContato("David Filho", 8883354));
        agendaContatos.exibirContatos();
    }
}
