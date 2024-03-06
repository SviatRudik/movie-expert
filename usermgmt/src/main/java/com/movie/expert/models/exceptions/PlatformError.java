package com.movie.expert.models.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class PlatformError {
    @Setter
    @Getter
    private Integer errorCode;
    @Setter
    @Getter
    private String msg;

}
