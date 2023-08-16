package com.Ankit.InstagramBackendBasicDesign.model.dto.likeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetLikeDto {
    private Long userId;
    private String userFirstName;
    private String userLastName;
}
