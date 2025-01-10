package com.Task_management.repository;


import com.Task_management.Entity.Comment;
import com.Task_management.dto.CommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByTaskId(Long taskId);
}
