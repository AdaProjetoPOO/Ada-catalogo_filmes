package br.com.ada;

import br.com.ada.catalogoFilmes.controller.MenuController;
import br.com.ada.catalogoFilmes.repository.AtorRepository;
import br.com.ada.catalogoFilmes.repository.CatalogoFimeRepository;
import br.com.ada.catalogoFilmes.repository.DiretorRepository;
import br.com.ada.catalogoFilmes.repository.FilmeRepository;
import br.com.ada.catalogoFilmes.service.AtorService;
import br.com.ada.catalogoFilmes.service.CatalogoFilmeService;
import br.com.ada.catalogoFilmes.service.DiretorService;
import br.com.ada.catalogoFilmes.service.FilmeService;

public class Principal {

    public static void main(String[] args) {
        AtorService atorService = new AtorService(new AtorRepository());
        CatalogoFimeRepository catalogoFilmeRepository = new CatalogoFimeRepository();
        CatalogoFilmeService catalogoFilmeService = new CatalogoFilmeService(catalogoFilmeRepository);
        DiretorService diretorService = new DiretorService(new DiretorRepository());
        FilmeService filmeService = new FilmeService(new FilmeRepository());
        FilmeRepository filmeRepository = new FilmeRepository();
        MenuController menuController = new MenuController(atorService, catalogoFilmeService, diretorService, filmeService, catalogoFilmeRepository, filmeRepository);
        menuController.menuPrincipal();
    }
}
