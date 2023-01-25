package com.bookstore.book.entity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Book")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }
    @GetMapping
    public ResponseEntity<List<Store>> getAllBooks(){
        List<Store> stores = storeService.getAllBooks();
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Store> getBookById(@PathVariable("id")Long id){
        Store store = storeService.findBookById(id);
        return new ResponseEntity<>(store,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Store> addBook(@RequestBody Store store){
        Store newBook=storeService.addBook(store);
        return new ResponseEntity<>(newBook,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Store> updateBook(@PathVariable("id")Long id,@RequestBody Store store ){

        Store updateBook=storeService.addBook(store);
        updateBook.setTitle(store.getTitle());
        updateBook.setAuthor(store.getAuthor());
        updateBook.setPrice(store.getPrice());
        storeService.addBook(updateBook);
        return new ResponseEntity<>(updateBook,HttpStatus.OK);

    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id")Long id){
        storeService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
