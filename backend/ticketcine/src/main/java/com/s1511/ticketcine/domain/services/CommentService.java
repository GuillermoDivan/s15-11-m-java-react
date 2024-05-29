package com.s1511.ticketcine.domain.services;
import java.util.List;

import com.s1511.ticketcine.application.dto.comment.CreateDtoComment;
import com.s1511.ticketcine.application.dto.comment.ReadDtoComment;
import com.s1511.ticketcine.application.dto.comment.UpdateDtoComment;

public interface CommentService {
    ReadDtoComment createComment(CreateDtoComment createDtoComment);
    ReadDtoComment readCommentByCommentId(String id, Boolean active);
    List<ReadDtoComment> readAllCommentByUserIdAndActive(String userId, Boolean active);
    List<ReadDtoComment> readAllCommentByMovieIdAndActive(String movieId, Boolean active);
    ReadDtoComment updateComment(UpdateDtoComment updateDtoComment);
    Boolean toggleComment(String id, String userId);
}
