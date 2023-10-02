package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventoMap;

    public AgendaEventos() {
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        //Evento evento = new Evento(nome, atracao);
        eventoMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
        System.out.println(eventosTreeMap);


    }

    public void obterProximoEvento() {
        /*Set<LocalDate> dateSet = eventoMap.keySet();
        Collection<Evento> values = eventoMap.values();*/

        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O próximo evento: " + proximoEvento + "acontecerá na data " + proximaData);
                break;
            }
        }

    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.OCTOBER, 15), "Evento 1", "Atração 1");
        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 9), "Evento 2", "Atração 2");
        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JANUARY,  10), "Evento 3", "Atração 3");
        //agendaEventos.adicionarEvento(LocalDate.of(2023, Month.OCTOBER,  2), "Evento 4", "Atração 4");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.OCTOBER,  3), "Evento 5", "Atração 5");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.OCTOBER,  20), "Evento 6", "Atração 6");

        agendaEventos.exibirAgenda();
        agendaEventos.obterProximoEvento();

    }
}
