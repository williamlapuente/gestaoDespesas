import base.BaseTest;
import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.Cadastro;
import page.RelatorioDespesasPeriodo;

@Log
public class Teste extends BaseTest {

    @Test
    public void testeCamposCadastroCompleto() {
        Cadastro page = new Cadastro(getDriver());
        page.informarCadastro("Robson", "Robson@Lang", "123", "123");
        String resultadoFinal = page.getResultadoLogin();
        Assert.assertTrue(resultadoFinal.contains("Status: Usuário cadastrado com sucesso!"));
    }


    @Test
    public void testeCamposCadastroIncompleto() {
        Cadastro page = new Cadastro(getDriver());
        page.informarCadastroIncompleto("Robson", "123", "123");
        String resultadoFinal = page.getResultadoLogin();
        Assert.assertTrue(resultadoFinal.contains("Status: Todos os campos são obrigatórios!"));
    }

    @Test
    public void testeRelatorioData() {
        WebDriver driver = getDriver(); // Certifique-se de que este método está definido
        RelatorioDespesasPeriodo page = new RelatorioDespesasPeriodo(driver);
        page.preencherBusca("01012024", "01012025", "tipo");
    }
}
