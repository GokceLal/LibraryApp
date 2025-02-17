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


Projenin görselleri aşağıdadır. Burada yer alan görseller kodun yaptıklarının sadece bir kısmıdır.




<img width="518" alt="Screenshot 2025-02-10 at 13 04 07" src="https://github.com/user-attachments/assets/3804f5e9-05d7-4a3e-85a6-808a3c9cf96f" />


<img width="1105" alt="Screenshot 2025-02-17 at 13 55 31" src="https://github.com/user-attachments/assets/6cd4be2e-e786-44f6-bf18-79d47122f426" />


<img width="1088" alt="Screenshot 2025-02-17 at 13 55 58" src="https://github.com/user-attachments/assets/200cd685-1821-4fce-a07c-b49cfd8bc879" />


<img width="1467" alt="Screenshot 2025-02-17 at 13 53 59" src="https://github.com/user-attachments/assets/7986b9ce-3d2f-4891-8e33-139641b327f3" />


<img width="1086" alt="Screenshot 2025-02-17 at 13 56 32" src="https://github.com/user-attachments/assets/ca0ebc4f-e90d-4ae9-8928-da02c96bd456" />


<img width="1157" alt="Screenshot 2025-02-17 at 13 54 39" src="https://github.com/user-attachments/assets/9dd32fa8-dbec-4fbc-83ce-612d985c915b" />


<img width="1466" alt="Screenshot 2025-02-17 at 13 54 13" src="https://github.com/user-attachments/assets/3b54f4a8-f668-4b3e-b419-43ed895943be" />
