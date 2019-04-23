package com.sap.model;

import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, String> {

}
