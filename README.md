# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/html/#build-image)

## `Case Study`

## 1. SQL Injection Handling
SQL Injection Handling berfungsi untuk menangani input paramater yang dibuat sedemikian rupa untuk bisa mendapatkan data dari database.
![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

Problem

> Pada API get data, user memasukkan query param dengan value "1;SELECT ..." , user bisa mendapatkan data list table pada database dengan melakukan enumerasi database

DoD

> Gunakan prepare statement & paramaterized query saat menangani query sql.


## 2. Data Encryption
Data Encryption digunakan untuk mengamankan data yang sensitif di dalam database yang diubah ke format tertentu
![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

Problem

> Pada api insert pada aplikasi cms admin, password yang diberikan masih belum terenkripsi

DoD

> Kolom password setiap participant harus sudah di enkripsi


## 3. Rate limit Attempt
Rate Limit digunakan untuk membatasi jumlah request api pada satuan waktu tertentu, untuk menangani request yang membanjiri server sehingga bisa membuat server download
![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)

Problem

> Pada api login menggunakan captcha, tidak ada rate limit yang dibuat dan validasi lain seperti captcha.

DoD

> Gunakan rate limit attempt pada api tersebut dan juga validasi captcha 


## 4. Data Type Evaluation
Data type dalam kasus ini digunakan untuk field id sebagain tipe integer pada database
![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

Problem

> Pada request api, id ini dijadikan sebagai float. Terdapat keterbatasan angka pada float, sehingga beberapa id gagal didapatkan misal irequestd 16833169, tetapi data yang di adalah berdasarkan id 16833168

DoD
> Semua id dipastikan harus bisa didapatkan pada api tersebut