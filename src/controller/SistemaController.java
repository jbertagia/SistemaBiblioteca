package controller;

import view.MenuView;
import factory.PreCarga;

public class SistemaController {
    public void iniciar() {
        PreCarga.executar();
        MenuView menu = new MenuView();
        menu.exibirMenu();
    }
}