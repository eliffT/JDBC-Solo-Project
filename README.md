
# 📌 JDBC - Java Database Connectivity

## 🎯 Amaç

JDBC (Java Database Connectivity), Java uygulamalarının veritabanlarıyla iletişim kurmasını sağlayan bir API'dir.  
SQL sorguları çalıştırarak veritabanından veri alma, veri ekleme, güncelleme ve silme işlemleri yapılabilir.

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
