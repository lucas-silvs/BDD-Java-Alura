package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Do;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PropondoLanceSteps {

    private Lance lance;
    private Leilao leilao;
    private List<Lance> lista;

    // O Before é executado antes de cada cenário
    @Before
    public void iniciarLista() {
        lista = new ArrayList<>();
        leilao= new Leilao("Tabela XPTO");
    }

    @After
    public void executadoAposCadaCenario(){
        System.out.printf("será executado após finalizar cada cenário");
    }

    @Given("Dado um lance valido")
    public void dado_um_lance_valido() {
        // Write code here that turns the phrase above into concrete actions
        Usuario usuario = new Usuario("fulano");
        lance = new Lance(usuario, BigDecimal.TEN);

    }




    @When("Quando propoe o lance")
    public void quando_propoe_o_lance() {
        leilao.propoe(lance);


    }
    @Then("entao o lance eh aceito")
    public void entao_o_lance_eh_aceitos() {
        Assert.assertEquals(1,leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN,leilao.getLances().get(0).getValor());

    }


//    @Given("varios lances validos")
//    public void variosLancesValidos() {
//        Usuario primeiro = new Usuario("fulano");
//        lanceprimeiro = new Lance(primeiro, BigDecimal.TEN);
//        Usuario segundo = new Usuario("ciclano");
//        lancesegundo = new Lance(segundo, new BigDecimal("100"));
//
//    }



    @Given("um lance de {double} do {string}")
    public void umLanceDeDo(double valor,String nomeUsuario) {
        Usuario primeiro = new Usuario(nomeUsuario);
        lance= new Lance(primeiro,new BigDecimal(valor));
        lista.add(lance);

    }

    @When("propoe varios lances ao leilao")
    public void propoeVariosLancesAoLeilao() {
        this.lista.forEach(lance1 -> leilao.propoe(lance1));

    }

    @Then("os lances sao aceitos")
    public void osLancesSaoAceitos() {
        Assert.assertEquals(lista.size(),leilao.getLances().size());
        Assert.assertEquals(lista.get(0).getValor(),leilao.getLances().get(0).getValor());
        Assert.assertEquals(lista.get(1).getValor(),leilao.getLances().get(1).getValor());
    }




    @Then("o lacne nao eh aceito")
    public void oLacneNaoEhAceito() {
        Assert.assertEquals(0,leilao.getLances().size());
    }


    @Then("o segundo lance nao eh aceito")
    public void oSegundoLanceNaoEhAceito() {
        Assert.assertEquals(1,leilao.getLances().size());
    }

    @Given("um lance de {double} reais do usuario {string}")
    public void umLanceDeValorReaisDoUsuarioNomeusuario(Double valor, String nomeUsuario) {
        lance = new Lance(new Usuario(nomeUsuario),new BigDecimal(valor));
        lista.add(lance);
    }

    @Given("um lance invalido de {double} reais do usuario {string}")
    public void umLanceInvalidoDeValorReaisDoUsuarioNomeusuario(Double valor, String nomeUsuario) {
        System.out.println(nomeUsuario);
        lance = new Lance(new BigDecimal(valor));

    }



    @Given("dois lances")
    public void dois_lances(DataTable dataTable) {
        List<Map<String,String>> table = dataTable.asMaps();

        for(Map<String,String> mapa : table){
            String valor= mapa.get("valor");
            String nomeUsuario = mapa.get("nomeusuario");
            lance = new Lance(new Usuario(nomeUsuario),new BigDecimal(valor));
            lista.add(lance);

        }
    }

}
