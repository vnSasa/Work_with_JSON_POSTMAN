package com.floor.layout.dto;

import com.floor.layout.host.Point;

import java.util.List;

public class RoomResDto {

    private Long id;

    private Integer size;

    private List<Point> corners;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<Point> getCorners() {
        return corners;
    }

    public void setCorners(List<Point> corners) {
        this.corners = corners;
    }
}