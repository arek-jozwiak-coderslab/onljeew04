package pl.coderslab.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/edit")
    public String editSave(Model model, @RequestParam long id) {
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("book", bookDao.findById(id));
        return "books/edit";
    }

    @PostMapping("/edit")
    public String edit(Book book) {
        bookDao.update(book);
        return "redirect:/book-form/all";
    }



    @GetMapping("/delete")
    public String delete(@RequestParam long id) {
        bookDao.deleteById(id);
        return "redirect:/book-form/all";
    }
}
