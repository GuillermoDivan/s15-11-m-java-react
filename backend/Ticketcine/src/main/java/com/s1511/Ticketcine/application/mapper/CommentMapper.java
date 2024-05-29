package com.s1511.Ticketcine.application.mapper;
import com.s1511.Ticketcine.application.dto.comment.CreateDtoComment;
import com.s1511.Ticketcine.application.dto.comment.ReadDtoComment;
import com.s1511.Ticketcine.domain.entities.Comment;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment createDtoToComment (CreateDtoComment createDtoComment);
    ReadDtoComment commentToReadDto (Comment comment);
    List<ReadDtoComment> commentListToReadDtoList (List<Comment> CommentList);
}
