package pl.coderslab.library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {

    private final PublisherDao publisherDao;
    private final BookDao bookDao;

    public BookController(PublisherDao publisherDao, BookDao bookDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.save(publisher);
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setDescription("Very long book about java");
        book.setPublisher(publisher);
        bookDao.save(book);
        return "added book";
    }

}
