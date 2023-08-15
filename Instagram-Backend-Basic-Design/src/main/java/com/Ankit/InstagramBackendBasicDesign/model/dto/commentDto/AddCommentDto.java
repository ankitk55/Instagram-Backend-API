package com.Ankit.InstagramBackendBasicDesign.model.dto.commentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddCommentDto {
    private String commentContent;
}
