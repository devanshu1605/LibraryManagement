package com.library.repository;

import org.springframework.data.repository.CrudRepository;
import com.library.model.Library;

public interface LibraryRepository extends CrudRepository<Library, Long> {
}

