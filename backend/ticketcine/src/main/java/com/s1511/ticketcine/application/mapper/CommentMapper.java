package com.s1511.ticketcine.application.mapper;
import org.mapstruct.Mapper;

import com.s1511.ticketcine.application.dto.comment.CreateDtoComment;
import com.s1511.ticketcine.application.dto.comment.ReadDtoComment;
import com.s1511.ticketcine.domain.entities.Comment;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment createDtoToComment (CreateDtoComment createDtoComment);
    ReadDtoComment commentToReadDto (Comment comment);
    List<ReadDtoComment> commentListToReadDtoList (List<Comment> CommentList);
}
