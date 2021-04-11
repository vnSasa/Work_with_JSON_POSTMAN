package com.floor.layout.dto;

import java.util.ArrayList;
import java.util.List;

public class RoomDto {

    private List<PointDto> room = new ArrayList<>();

    public List<PointDto> getRoom() {
        return room;
    }

    public void setRoom(List<PointDto> room) {
        this.room = room;
    }
}