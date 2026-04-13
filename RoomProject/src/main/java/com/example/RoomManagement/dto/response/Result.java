package com.example.RoomManagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String id;
    private String name;
    private String category;
    private Boolean is_online;
    private String lat;
    private String lon;
    private Long active_time;
    private Long update_time;
}
