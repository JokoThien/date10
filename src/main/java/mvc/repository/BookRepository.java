package mvc.repository;

import mvc.entity.BookEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository  {
    private List<BookEntity> bookList = new ArrayList<>();
    @PostConstruct
    public void init(){
        bookList.add(new BookEntity(1,"Java A-Z",13.2,"Roger"));
        bookList.add(new BookEntity(2,".Net tutorial",23.9,"Peter"));
    }
    public List<BookEntity> findAll(){
        return bookList;
    }
    public BookEntity save(BookEntity bookEntity){
        bookList.add(bookEntity);
        return bookEntity;
    }
    public BookEntity update(BookEntity newBookData){
        BookEntity result =null;
        for (BookEntity book : bookList){
            if (book.getId() == newBookData.getId()){
                book.setName(newBookData.getName());
                book.setAuthor(newBookData.getAuthor());
                book.setPrice(newBookData.getPrice());
                result =book;
                break;
            }
        }
        return result;

//        boolean isFoourd = false;
//        BookEntity foundBook =null;
//        for (BookEntity book : bookList){
//            if (book.getId()== newBookData.getId()){
//                isFoourd = true;
//                foundBook = book;
//                break;
//            }
//        }
//        if (!isFoourd){
//            return null;
//
//        }
//        bookList.remove(foundBook);
//        newBookData.setId(foundBook.getId());

    }
    public boolean delete(int bookId){
        boolean isFound = false;
        BookEntity foundBook = null;
        for (BookEntity book: bookList){
            if (book.getId()== bookId){
                isFound = true;
                foundBook = book;
                break;
            }
        }
        if (!isFound){
            return false;
        }
        bookList.remove(foundBook);
        return true;
    }

}
