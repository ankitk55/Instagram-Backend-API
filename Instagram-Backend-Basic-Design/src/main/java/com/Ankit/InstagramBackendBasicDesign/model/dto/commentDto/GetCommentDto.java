package com.Ankit.InstagramBackendBasicDesign.model.dto.commentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCommentDto {
    private Long commentId;
    private String commentContent;
    private LocalDateTime commentCreationTimeStamp;
    private Long commenterId;
    private String commenterName;


}
