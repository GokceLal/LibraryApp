Unit Test 

@SpringBootTest

public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
void testGetAllBooks() {
    assertNotNull(bookService.getAllBooks());
}

@Test
void testGetBookStrartingWithA() {

List<Book> books = bookService.findByTitleStartingWithA();
assertTrue(books.size() > 0);
}
}


ctrl alt l otomatik düzenleme