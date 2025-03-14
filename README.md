# QA Test Framework

Bu proje, Selenium WebDriver ve JUnit 5 kullanılarak oluşturulmuş bir test otomasyon framework'üdür.

## Gereksinimler

- Java 11 veya üzeri
- Maven 3.6 veya üzeri
- Chrome tarayıcısı

## Kurulum

1. Projeyi klonlayın
2. Maven bağımlılıklarını yükleyin:
   ```bash
   mvn clean install
   ```

## Testleri Çalıştırma

Tüm testleri çalıştırmak için:
```bash
mvn test
```

Belirli bir test sınıfını çalıştırmak için:
```bash
mvn test -Dtest=GoogleSearchTest
```

## Proje Yapısı

- `src/test/java/com/qa/base`: Temel test sınıfları
- `src/test/java/com/qa/tests`: Test senaryoları
- `pom.xml`: Maven yapılandırması ve bağımlılıkları
