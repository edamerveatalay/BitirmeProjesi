# QA Test Framework

## 📌 Proje Açıklaması
Bu proje, **Selenium WebDriver** ve **JUnit 5** kullanılarak oluşturulmuş bir test otomasyon framework'üdür. Web uygulamalarını otomatik olarak test etmek ve test süreçlerini hızlandırmak amacıyla geliştirilmiştir.

## ⚙️ Gereksinimler
Projeyi çalıştırmak için aşağıdaki yazılımların sisteminizde yüklü olması gerekmektedir:

- **Java 11** veya üzeri
- **Maven 3.6** veya üzeri
- **Google Chrome** tarayıcısı ve ChromeDriver

## 🚀 Kurulum
Projeyi kendi sisteminizde çalıştırmak için aşağıdaki adımları takip edebilirsiniz:

1. **Projeyi klonlayın:**
   ```bash
   git clone https://github.com/edamerveatalay/QA-Test-Framework.git
   ```
2. **Bağımlılıkları yükleyin:**
   ```bash
   mvn clean install
   ```

## 🛠️ Testleri Çalıştırma
Framework'ü kullanarak testleri çalıştırmak için aşağıdaki komutları kullanabilirsiniz:

- **Tüm testleri çalıştırmak için:**
   ```bash
   mvn test
   ```
- **Belirli bir test sınıfını çalıştırmak için:**
   ```bash
   mvn test -Dtest=GoogleSearchTest
   ```

## 📂 Proje Yapısı
Proje, aşağıdaki klasör yapısına sahiptir:

- `src/test/java/com/qa/base` → Temel test sınıfları ve yardımcı metotlar
- `src/test/java/com/qa/tests` → Test senaryolarının bulunduğu klasör
- `pom.xml` → Maven bağımlılıkları ve yapılandırma dosyası

## 📌 Katkıda Bulunma
Projeye katkıda bulunmak için aşağıdaki adımları takip edebilirsiniz:
1. Bu repoyu **fork** edin.
2. Yeni bir **branch** oluşturun (`git checkout -b yeni-ozellik`).
3. Değişikliklerinizi yapıp commit edin (`git commit -m 'Yeni özellik eklendi'`).
4. **Pull request** açarak değişikliklerinizi paylaşın.

## 📜 Lisans
Bu proje [MIT Lisansı](LICENSE) kapsamında sunulmaktadır.

---
Daha fazla bilgi almak veya geri bildirimde bulunmak için [GitHub Issues](https://github.com/edamerveatalay/QA-Test-Framework/issues) bölümünü ziyaret edebilirsiniz.

