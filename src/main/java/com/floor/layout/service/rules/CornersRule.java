package com.floor.layout.service.rules;

import com.floor.layout.host.Point;

import java.util.List;

public class CornersRule implements Rule {
    @Override
    public boolean validate(List<Point> points) {
        return points.size() >= 4;
    }

    @Override
    public String getMessage() {
        return "Room must have at least four corners";
    }
}
