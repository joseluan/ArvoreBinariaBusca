package br.com.luan.model;

public class Main {

    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        for (int i = 0; i < 5; i++) {
            arvore.insert(
                new Node(i)
            );
        }
        
        System.out.println(arvore.getMaxFolha().getValue());
        System.out.println(arvore.remove(9).getValue());
    }
}
