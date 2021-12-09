package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class LoginSteps {

    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;

    @Dado("o usuario valido")
    public void o_usuario_valido() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();

    }




    @Quando("realiza login")
    public void realiza_login() {
        this.leiloesPage = loginPage.realizaLoginComo("fulano","pass");

    }
    @Entao("e redirecionado para a pagina de leiloes")
    public void e_redirecionado_para_a_pagina_de_leiloes() {
        Assert.assertTrue(leiloesPage.estaNaPaginaDeLeiloes());

    }




    @Dado("o usuario invalido")
    public void o_usuario_invalido() {
        browser = new Browser();
        loginPage = browser.getLoginPage();

    }




    @Quando("tenta logar")
    public void tenta_logar() {
        this.leiloesPage = loginPage.realizaLoginComo("Notfulano","Notpass");


    }
    @Entao("continua na pagina de login")
    public void continua_na_pagina_de_login() {
        Assert.assertFalse(leiloesPage.estaNaPaginaDeLeiloes());
        browser.clean();

    }
}
