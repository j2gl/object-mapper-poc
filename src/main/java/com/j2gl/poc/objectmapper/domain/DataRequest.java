package com.j2gl.poc.objectmapper.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
@AllArgsConstructor
public class DataRequest {

    private Integer number;
    private String data;
    private boolean flag;

}
