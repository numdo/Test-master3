package com.example.testsearch.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class Data {

    private String Objects;
    private String Title;
    private String Title_Ru;
    private String Subject;
    private String Subject_Ru;
    private String Description;
    private String Description_Ru;
    private String Institute_Identifier;
    private String Identifier;
    private String Language;
    private String Language_Ru;
    private String Temporary;
    private String Temporary_Ru;
    private String Place;
    private String Place_Ru;
    private String Current_location;
    private String Current_location_Ru;
    private String Object_Type;
    private String Object_Type_Ru;
    private String Object_Size;
    private String Object_Size_Ru;
    private String Object_Material;
    private String Object_Material_Ru;
    private String Object_Etc;
    private String Object_Etc_Ru;
    private String Raw_Data_Type;
    private String Raw_Data_Type_Ru;
    private String Digital_Data_Type;
    private String Digital_Data_Type_Ru;
    private String File_Extension;
    private String Coverage;
    private String Coverage_Ru;
    private String Creator;
    private String Creator_Ru;
    private String Publisher;
    private String Publisher_Ru;
    private String Provider;
    private String Provider_Ru;
    private String Participants;
    private String Participants_Ru;
    private String Providing_Institution;
    private String Providing_Institution_Ru;
    private String Provider_Country;
    private String Provider_Country_Ru;
    private String Source;
    private String Source_Ru;
    private String Collection_Name;
    private String Collection_Name_Ru;
    private String IsPartOf;
    private String IsPartOf_Ru;
    private String Links;
    private String Rights_Statement_Media;
    private String Rights;
    private String Rights_Ru;
    private String Data_Code;
    private String userId;
    private LocalDateTime Created_Time;
    private LocalDateTime Updated_Time;
    private Float Latitude;
    private Float Longitude;

    private UserDto userDto;
    private List<FileDto> fileList;
}
