package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.GittiGidiyorPage;
import utilities.Driver;

import java.util.Random;

public class GittiStepDef {
    String sayfadakiFiyat = "";
    GittiGidiyorPage gittiGidiyorPage = new GittiGidiyorPage();
    @Given("kullanici once {string} sayfasina gider")
    public void kullanici_once_sayfasina_gider(String string) {
        Driver.getDriver().get(string);
    }

    @Given("kullanici {string} ve {string} ile login islemini tamamlar")
    public void kullanici_ve_ile_login_islemini_tamamlar(String string, String string2) {
        Driver.getDriver().get("https://www.gittigidiyor.com/uye-girisi");
        gittiGidiyorPage.kullaniciAdi.sendKeys(string);
        gittiGidiyorPage.sifre.sendKeys(string2 + Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("kullanici girisi dogrular")
    public void kullanici_girisi_dogrular() {
        String title = Driver.getDriver().getTitle();
        Assert.assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi", title);
    }

    @Given("kullanici arama kutusuna {string} yazar ve arar")
    public void kullanici_arama_kutusuna_yazar_ve_arar(String string) {
        gittiGidiyorPage.aramaKutusu.sendKeys(string + Keys.ENTER);
    }

    @Given("kullanici ikinci sayfaya gider")
    public void kullanici_ikinci_sayfaya_gider() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) Driver.getDriver())
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) Driver.getDriver())
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");

        gittiGidiyorPage.ikinciSayfaLinki.click();
    }

    @Then("kullanici ikinci sayfayi dogrular")
    public void kullanici_ikinci_sayfayi_dogrular() {
        String title = Driver.getDriver().getTitle();
        Assert.assertEquals("Bilgisayar - GittiGidiyor - 2/100", title);
    }

    @Then("kullanici rastgele bir urun secer")
    public void kullanici_rastgele_bir_urun_secer() {
        int rastgele = new Random().nextInt(gittiGidiyorPage.urunler.size()-1);

        gittiGidiyorPage.urunler.get(rastgele).click();
    }

    @Then("kullanici urunu sepete ekler")
    public void kullanici_urunu_sepete_ekler() {
        sayfadakiFiyat = gittiGidiyorPage.sayfadakiFiyat.getText();
        ((JavascriptExecutor) Driver.getDriver()).executeScript(
                "arguments[0].scrollIntoView();", gittiGidiyorPage.sepeteEkle);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gittiGidiyorPage.sepeteEkle.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("kullanici urun sayfasindaki fiyat ile sepettekini karsilastirir")
    public void kullanici_urun_sayfasindaki_fiyat_ile_sepettekini_karsilastirir() {
        Driver.getDriver().get("https://www.gittigidiyor.com/sepetim");
        String total = gittiGidiyorPage.sepettekiFiyat.getText();
        Assert.assertEquals(total,sayfadakiFiyat);

    }

    @Then("kullanici sepetteki sayiyi bir artirir")
    public void kullanici_sepetteki_sayiyi_bir_artirir() {

        Select dropdown = new Select(gittiGidiyorPage.dropdown);
        dropdown.selectByIndex(1);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("kullanici urunu sepetten siler")
    public void kullanici_urunu_sepetten_siler() {
        gittiGidiyorPage.sil.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(gittiGidiyorPage.sepetteUrunYok.isDisplayed());
    }
}