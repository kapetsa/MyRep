package com.novik.workbooks.repositories;

import com.novik.workbooks.domain.Workbook;
import org.springframework.data.repository.CrudRepository;


public interface WBookRepo extends CrudRepository<Workbook, Long>{

}