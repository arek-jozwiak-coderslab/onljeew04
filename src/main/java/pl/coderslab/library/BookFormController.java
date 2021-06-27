package pl.coderslab.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/book-form")
@Controller
public class BookFormController {


    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/all")
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "books/all";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("book", new Book());
        return "books/add";
    }

    @PostMapping("/add")
    public String save(Book book) {
        bookDao.save(book);
        return "redirect:/book-form/all";
    }
}
