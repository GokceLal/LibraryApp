package com.example.LibraryApp.constants;

public class RestApiUrls {

    private static final String VERSION = "/v1";
    private static final String API = "/api";
    private static final String TEST = "/test";
    private static final String DEV = "/dev";
    private static final String PROD = "/prod";

    private static final String ROOT = DEV + VERSION;

    public static final String AUTHOR = ROOT + "/author";
    public static final String PUBLISHER = ROOT + "/publisher";
    public static final String BOOK = ROOT + "/book";
    public static final String GOOGLE_BOOKS = "/google-books";

    public static final String GET_ALL_AUTHORS = "/getAllAuthors";
    public static final String GET_ALL_PUBLISHERS = "/getAllPublishers";
    public static final String GET_TWO_PUBLISHERS = "/getTwoPublishers";
    public static final String GET_ALL_BOOKS = "/getAllBooks";
    public static final String GET_STARTING_WITH_A = "/getStartingWithA";
    public static final String GET_BOOK_AFTER_2023 = "/getBookAfter2023";
    public static final String CREATE_BOOK = "/createBook";
    public static final String UPDATE_BOOK = "/updateBook";
    public static final String DELETE_BOOK = "/deleteBook";
    public static final String API_GOOGLE_BOOKS = API + GOOGLE_BOOKS;
    public static final String SEARCH_GOOGLE_BOOKS = "/searchBooks";


}
//AIzaSyCwdR--XNf10VGYgMf2TEXFjscsNzHc9bE
//https://www.google.books.ap+.url=https://www.googleap+s.com/books/v1/volumes?q=AIzaSyCwdR--XNf10VGYgMf2TEXFjscsNzHc9bE
//https://www.googleapis.com/books/v1/volumes?q=time&printType=magazines&key=AIzaSyCwdR--XNf10VGYgMf2TEXFjscsNzHc9bE