
# 📌 JDBC - Java Database Connectivity

## 🎯 Amaç

JDBC (Java Database Connectivity), Java uygulamalarının veritabanlarıyla iletişim kurmasını sağlayan bir API'dir.  
SQL sorguları çalıştırarak veritabanından veri alma, veri ekleme, güncelleme ve silme işlemleri yapılabilir.


### ✅ JDBC’nin Görevleri ve Avantajları (4 Maddede)

1.  **Veritabanı Bağlantısı Sağlar**  
    Java uygulamasının MySQL, PostgreSQL gibi veritabanlarına bağlanmasını mümkün kılar.
    
2.  **SQL Sorgularını Çalıştırır**  
    Java kodu içerisinden SQL komutlarının yazılıp çalıştırılmasını sağlar.
    
3.  **Sonuçları Yönetir**  
    Veritabanından dönen sonuçları alır, işler ve Java nesnelerine dönüştürür.
    
4.  **Taşınabilir ve Esnektir**  
    Tek bir API ile farklı veritabanlarında çalışabilir, platformdan bağımsızdır.

---


## 🧱 Temel Bileşenler

| Bileşen              | Açıklama                                                                 |
|----------------------|--------------------------------------------------------------------------|
| `DriverManager`      | Veritabanı sürücülerini yönetir, bağlantı sağlar                         |
| `Connection`         | Veritabanı bağlantısını temsil eder                                     |
| `Statement` / `PreparedStatement` | SQL sorgularını çalıştırmak için kullanılır                     |
| `ResultSet`          | Sorgu sonucu dönen verileri tutar                                       |

---

## 🔧 JDBC ile Veritabanı Bağlantısı

```java
String url = "jdbc:postgresql://localhost:5432/db_adi";
String user = "kullanici";
String password = "sifre";

Connection conn = DriverManager.getConnection(url, user, password);
