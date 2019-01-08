package com.novik.workbooks.repositories;

import com.novik.workbooks.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CommentRepo extends CrudRepository<Comment, Long> {

    List<Comment> findByBookId(Long id);
}
