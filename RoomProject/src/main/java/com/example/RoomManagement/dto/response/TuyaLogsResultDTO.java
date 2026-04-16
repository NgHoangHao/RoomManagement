package com.example.RoomManagement.dto.response;

import java.util.List;

public class TuyaLogsResultDTO {
    private String device_id;
    private boolean has_more;
    private int total;
    private List<TuyaLogItemDTO> logs;
}

