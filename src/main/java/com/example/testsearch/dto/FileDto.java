package com.example.testsearch.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileDto {

    private String fileIdx;
    private String fileOriginalName;
    private String fileNewName;
    private String filePath;
    private String fileSize;


}
