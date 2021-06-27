package pl.coderslab.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.car.Category;
import pl.coderslab.car.CategoryDao;

public class PublisherConverter implements Converter<String, Publisher> {
    @Autowired
    private PublisherDao publisherDao;

    @Override
    public Publisher convert(String source) {
        return publisherDao.findById(Long.parseLong(source));
    }
}
