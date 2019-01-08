package com.novik.workbooks.repositories;

import com.novik.workbooks.domain.Workbook;
import org.springframework.data.jpa.repository.JpaRepository;



public interface WBookRepo extends JpaRepository<Workbook, Long> {

}