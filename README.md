# LibraryApp with Spring Boot

## Proje özeti

LibraryApp **java spring boot, feign client, google Books API** kullanılarak yapılmıştır.

Genel olarak projenin özeti:

- Bir yayınevinin kitapları, yazarları ve yayınevlerini yöneten bir sistemin prototipini geliştirilmiştir..
- Spring Boot kullanılarak geliştirilmiş olan uygulama, Clean Code, SOLID prensipleri ve MVC yapısı gibi yazılım
  geliştirme ilkelerine uygun olacak şekilde modüler bir yapıya sahiptir.
- Projede yayınevleri, kitaplar ve yazarlar arasındaki ilişkiler tanımlanmıştır ve kitaplar üzerinde CRUD işlemleri
  yapılmıştır.
- Kitap eklerken yayınevi ve yazar bilgileri de sisteme dahil edilmiştir..
- Ayrıca, kitapları filtrelemek için Stream yapısı ve JPA query kullanılarak özel sorgular oluşturulmuştur.
- Google Books API ile entegrasyon sağlanmış ve kitap adıyla arama yapılmıştır.
- Uygulama Swagger ile test , unit testler ile işlevsellik kontrol edilmiştir.
- Veriler PostgreSQL veritabanında saklanacak ve projede kullanılan tüm teknolojiler Spring Boot temelindedir.

Atılan isteklerin cevapları aşağıdaki gibi dönmektedir :

```
{
"title": "Effective Java",
"price": 1431.8,
"ISBN13": "9780134686042",
"publisherName": "Addison-Wesley Professional",
"authorNameSurname": "Joshua Bloch"
}


```

## Projeyi nasıl kurmalısınız

```   
Projeyi kullanabilmek için postgreSQL ve jdk gereklidir. Spring Boot projelerini daha iyi 
görebilmek için IDE tercihen Intellij Idea kullanabilirsiniz. Daha sonra projeyi 
githubdan clone özelliği ile Idenize atabilirsiniz. Eğer kodun lamda bölümleri kızarırsa pluging bölümünden lamda uzantısını ekleyebilirsiniz.
API Key entegre edildikten sonra, uygulamayı kullanmaya başlayabilirsiniz. 
API'nin çalışıp çalışmadığını test etmek için Swagger UI veya Postman üzerinden endpoint'leri kontrol edebilirsiniz. 
```   

Projenin swagger sayfası için tıklayabilirsiniz ya da alttaki linki tarayıcınıza
yapıştırabilirsiniz  [Swagger](http://localhost:8080/swagger-ui/index.html/)

```
http://localhost:8080/swagger-ui/index.html
```

### Google Books API:

Google Book Apı ile Apı Key aldığım ve dokumantasyonunu okuduğum site:

```
https://developers.google.com/books?hl=tr
```

## Gereksinimler:

Müşteri Gereksinimleri; Bir yayınevinin birçok kitabı vardır ve her kitaba bir yazar
atanmıştır.
Prototipin aşağıdaki işlevleri sağlaması amaçlanmaktadır:

- Tüm yayınevlerini listele
- Tüm kitapları listele
- Tüm yazarları listele
- Tüm kitapları ve ilgili yazarlarıyla birlikte 2 yayınevi listele
- Sadece ‘A’ harfiyle başlayan kitapları getiren stream yapısı
- 2023 den sonra basılan kitapları filtreleyen jpa query yapısı

## Kullanılan sürümler ve teknolojiler:

* Java 23
* Spring Boot 3.4.2
* postgreSQL 13
* Swagger
* isteğe bağlı olarak Postman kullanılabilir
* Feign Client

## Proje Kaynak Kodu:

Projenin kaynak kodu [GitHub](https://github.com/gokcelalarslan/LibraryApp)

## Proje Yapılısı:

```
LibraryApp
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── LibraryApp
│   │   │               ├── constant
│   │   │               │   └── RestApiUrls.java
│   │   │               ├── controller
│   │   │               │   ├── AuthorController.java
│   │   │               │   ├── BookController.java
│   │   │               │   ├── PublisherController.java
│   │   │               ├── dto
│   │   │               │   ├── request
│   │   │               │   │   ├── BookCreateDto.java
│   │   │               │   │   ├── BookUpdateDTO.java
│   │   │               │   ├── response
│   │   │               │   │   ├── BookResponseDTO.java
│   │   │               │   │   ├── AuthorResponseDTO.java
│   │   │               │   │   ├── GoogleBookResponseDTO.java
│   │   │               │   │   ├── PublisherResponseDTO.java
│   │   │               ├── entity
│   │   │               │   ├── Author.java
│   │   │               │   ├── Book.java
│   │   │               │   ├── Publisher.java
│   │   │               ├── exception
│   │   │               ├── googleBooks
│   │   │               │   ├── GoogleBooksClient.java
│   │   │               │   ├── GoogleBooksController.java
│   │   │               │   ├── GoogleBooksResponse.java
│   │   │               │   ├── GoogleBooksService.java
│   │   │               ├── repository
│   │   │               │   ├── AuthorRepository.java
│   │   │               │   ├── BookRepository.java
│   │   │               │   ├── PublisherRepository.java
│   │   │               ├── service
│   │   │               │   ├── AuthorService.java
│   │   │               │   ├── BookService.java
│   │   │               │   ├── PublisherService.java
│   │   │               ├── LibraryAppApplication.java
│   │   └── resources
│   │       └── application.yml
│   └── test
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── LibraryApp
│       │               └── controller
│       │                   ├── TestPublisherService.java



```

## Bana Ulasabilirsiniz:

My Linkedin Profile [Linkedin Pages](https://tr.linkedin.com/in/gokcelalarslan).




