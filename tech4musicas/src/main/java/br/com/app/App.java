package br.com.app;

import java.util.Optional;

public class App {
    public static void main(String[] args) {
        Optional<String> opcao = Optional.empty();
        System.out.println(opcao.get());
    }
}
