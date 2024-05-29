package com.s1511.Ticketcine.domain.services;
import com.s1511.Ticketcine.application.dto.comment.CreateDtoComment;
import com.s1511.Ticketcine.application.dto.comment.ReadDtoComment;
import com.s1511.Ticketcine.application.dto.comment.UpdateDtoComment;

import java.util.List;

public interface CommentService {
    ReadDtoComment createComment(CreateDtoComment createDtoComment);
    ReadDtoComment readCommentByCommentId(String id, Boolean active);
    List<ReadDtoComment> readAllCommentByUserIdAndActive(String userId, Boolean active);
    List<ReadDtoComment> readAllCommentByMovieIdAndActive(String movieId, Boolean active);
    ReadDtoComment updateComment(UpdateDtoComment updateDtoComment);
    Boolean toggleComment(String id, String userId);
}
