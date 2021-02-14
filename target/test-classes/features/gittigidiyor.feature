Feature: Gittigidiyor Arama
  @gittigidiyor
  Scenario: TC_001
    Given kullanici once "http://gittigidiyor.com" sayfasina gider
    And kullanici "berkayfurkan.bfd@gmail.com" ve "27625434ab" ile login islemini tamamlar
    Then kullanici girisi dogrular
    Then kullanici arama kutusuna "bilgisayar" yazar ve arar
    Then kullanici ikinci sayfaya gider
    Then kullanici ikinci sayfayi dogrular
    Then kullanici rastgele bir urun secer
    Then kullanici urunu sepete ekler
    Then kullanici urun sayfasindaki fiyat ile sepettekini karsilastirir
    Then kullanici sepetteki sayiyi bir artirir
    Then kullanici urunu sepetten siler