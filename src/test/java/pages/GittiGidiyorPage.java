package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class GittiGidiyorPage {
    public GittiGidiyorPage(){
        PageFactory.initElements(Driver.getDriver() , this);
    }

    @FindBy( id = "L-UserNameField")
    public WebElement kullaniciAdi;

    @FindBy( id = "L-PasswordField")
    public WebElement sifre;

    @FindBy (name = "k")
    public WebElement aramaKutusu;

    @FindBy (xpath = "//*[.='2']")
    public WebElement ikinciSayfaLinki;

    @FindBy (className = "product-link")
    public List<WebElement> urunler;

    @FindBy (id = "add-to-basket")
    public WebElement sepeteEkle;

    @FindBy (id = "sp-price-highPrice")
    public WebElement sayfadakiFiyat;

    @FindBy (className = "total-price")
    public WebElement sepettekiFiyat;

    @FindBy (xpath = "//select[@class='amount']")
    public WebElement dropdown;

    @FindBy (xpath = "//*[@title='Sil']")
    public WebElement sil;

    @FindBy(xpath = "//*[.='Sepetinizde ürün bulunmamaktadır.']")
    public WebElement sepetteUrunYok;

}