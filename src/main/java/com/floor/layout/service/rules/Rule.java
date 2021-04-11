package com.floor.layout.service.rules;

import com.floor.layout.host.Point;

import java.util.List;

public interface Rule {
    boolean validate(List<Point> points);

    String getMessage();
}
