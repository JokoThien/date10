package mvc.controller;

import mvc.entity.BookEntity;
import mvc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @RequestMapping(method = GET)
    public Object getAllBook(){
        List<BookEntity> bookEntityList = bookRepository.findAll();
        return bookEntityList;
    }

    @RequestMapping(method = POST)
    public Object addNewBook(@RequestBody BookEntity newBookEntity){
        BookEntity result = bookRepository.save(newBookEntity);
        return result;

    }
    @RequestMapping(method = PUT)
    public Object updateBook(@RequestBody BookEntity updateBookEntity){
        BookEntity result = bookRepository.update(updateBookEntity);
        if (result == null){
            Map<String, String> error = new HashMap<String,String>(){
                {
                    put("error",updateBookEntity.getId()+"does not exit");
                }

            };
            return error;
        }
        return result;

    }
    @RequestMapping(value = "/{bookId}",method = DELETE)
    public Object deleteBook(@PathVariable(value = "bookId")String bookId){
        boolean result = bookRepository.delete(Integer.valueOf(bookId));
        if (!result){
            Map<String,String> error = new HashMap<String,String>(){{
                put("error","A book which book ID = " +bookId+"does not exist");
            }};
            return error;
        }else {
            Map<String,String> success =new HashMap<String,String>(){{
                put("success", "A book which book ID = " + bookId + "has been deleteed successfully");

            }};
            return success;
        }


    }



}
