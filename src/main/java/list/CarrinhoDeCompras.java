package main.java.list;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add(item);
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }


    public double calcularValorTotal() {
        double valorTotal = 0;
        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia! ");
        }

    }

    public void exibirIens() {
        if (!itemList.isEmpty()) {
            System.out.println(this.itemList);
        } else {
            System.out.println("A lista está vazia! ");
        }
    }


//    @Override
//    public String toString() {
//        return "CarrinhoDeCompras{" +
//                "itemList=" + itemList +
//                '}';
//    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Caneta", 5.0, 10);
        carrinhoDeCompras.adicionarItem("Livro", 10.0, 2);
        carrinhoDeCompras.adicionarItem("Bloco de notas", 5.0, 3);

        carrinhoDeCompras.exibirIens();

        carrinhoDeCompras.removerItem("Livro");

        System.out.println("O valor total é: " + carrinhoDeCompras.calcularValorTotal());
    }
}
