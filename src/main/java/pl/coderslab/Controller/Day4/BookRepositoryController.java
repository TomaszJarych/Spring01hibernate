package pl.coderslab.Controller.Day4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.Service.BookService;

@Controller
@RequestMapping("/day4")
public class BookRepositoryController {


    private final BookService bookService;
    
    @Autowired
    public BookRepositoryController(BookService bookService) {
	this.bookService = bookService;
    }
    
    @RequestMapping(path="/getNumberOfBooks", method=RequestMethod.GET)
    @ResponseBody
    public String getBookQuantity() {
	
	return "Liczba książek to: "+bookService.getBookCount();
	
    }
    
    
    
    
}
