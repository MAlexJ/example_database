package com.malex.one_to_many_unidirectional.repository.oneToMany;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malex.one_to_many_unidirectional.entity.oneToMany.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {}
