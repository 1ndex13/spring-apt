package com.start.egor.library.repository;

import com.start.egor.library.model.BookRentInfo;
import com.start.egor.library.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRentInfoRepository extends  GenericRepository<BookRentInfo> {
}