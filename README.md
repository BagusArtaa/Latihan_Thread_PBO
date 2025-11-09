# Latihan_Thread_PBO
---

## **Deskripsi Program**

Program ini merupakan simulasi pemesanan tiket perjalanan luar angkasa menggunakan Java. Sistem ini menggabungkan dua konsep dalam pemrograman berorientasi objek, yaitu multithreading dan JDBC (Java Database Connectivity). Melalui multithreading, program dapat mensimulasikan banyak pengguna yang melakukan pemesanan tiket secara bersamaan. Sementara JDBC digunakan agar Java dapat terhubung langsung ke database MySQL melalui XAMPP untuk membaca dan memperbarui data tiket.

---

## Thread 
### **Peran Thread dalam Program**
Thread pada program ini berperan sebagai simulasi dari beberapa pemesan tiket luar angkasa yang melakukan pemesanan pada waktu yang hampir bersamaan.
Setiap pemesan diwakili oleh satu objek Thread, yang dijalankan secara bersamaan sehingga seluruh proses pemesanan tampak terjadi pada waktu yang sama.
Dengan cara ini, kita dapat melihat bagaimana program menangani situasi ketika dua atau lebih pengguna mencoba memesan tiket yang sama dalam waktu berdekatan.
Kelas BookingThread memperluas kelas Thread dan berisi perilaku setiap pemesan, di mana method run() akan memanggil fungsi bookTicket() dari kelas SpaceTicket untuk menjalankan proses pemesanan tiket.
Cuplikan kode:
```java
public class BookingThread extends Thread {
    private String namaPemesan;
    private int idTiket;
    private SpaceTicket spaceTicket;

    public BookingThread(String namaPemesan, int idTiket, SpaceTicket spaceTicket) {
        this.namaPemesan = namaPemesan;
        this.idTiket = idTiket;
        this.spaceTicket = spaceTicket;
    }

    @Override
    public void run() {
        spaceTicket.bookTicket(namaPemesan, idTiket);
    }
}
```

## JDBC 
### **Menyiapkan Database**
```java
CREATE DATABASE space_travel;

USE space_travel;

CREATE TABLE tickets (
  id INT AUTO_INCREMENT PRIMARY KEY,
  tujuan VARCHAR(100),
  harga DOUBLE,
  stok INT
);

INSERT INTO tickets (tujuan, harga, stok) VALUES
('Mars', 1500000, 2),
('Jupiter', 2500000, 1),
('Saturnus', 3000000, 3);
```

### **Peran JDBC dalam Program**
JDBC (Java Database Connectivity) memungkinkan program Java untuk terhubung dengan database MySQL agar dapat membaca dan memperbarui data tiket yang tersimpan. Dalam program ini, JDBC digunakan untuk membuka koneksi ke database space_travel yang dijalankan melalui XAMPP. Semua data tiket, termasuk tujuan planet, harga, dan stok tersedia, disimpan di dalam tabel tickets. Koneksi ke database dilakukan dengan menggunakan kelas DriverManager, yang menyediakan metode getConnection() untuk membuat jalur komunikasi antara aplikasi dan database.
Cuplikan kode:
```java
private Connection connect() {
    try {
        String url = "jdbc:mysql://localhost:3306/space_travel";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}
```
---
## Output Program 

<img width="700" height="317" alt="image" src="https://github.com/user-attachments/assets/9120bc57-eea4-449d-92bf-9f3ce60728c6" />




