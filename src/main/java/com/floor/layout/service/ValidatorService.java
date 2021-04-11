package com.floor.layout.service;

import com.floor.layout.host.Point;
import com.floor.layout.dto.PointDto;
import com.floor.layout.exception.RoomException;
import com.floor.layout.service.rules.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValidatorService {

    private final List<Rule> rules = new ArrayList<>();

    @PostConstruct
    void init() {
        rules.add(new CornersRule());
        rules.add(new RoomFinishedArea());
        rules.add(new NoDiagonalRule());
        rules.add(new NoIntersectRule());
    }

    public List<Point> getValidatedCorners(List<PointDto> corners) {
        List<Point> points = corners
                .stream()
                .map(this::toPoint)
                .collect(Collectors.toList());

        validateWithReason(points);

        return points;
    }

    private Point toPoint(PointDto req) {
        try {
            int x = Integer.parseInt(req.getX());
            int y = Integer.parseInt(req.getY());
            if (x < 0 || x > 200 || y < 0 || y > 200) {
                throw new RoomException("The coordinates must be in the range of 0 to 200");
            }
            Point point = new Point();
            point.setX(x);
            point.setY(y);
            return point;
        } catch (NumberFormatException e) {
            throw new RoomException("Coordinates must be integers");
        }
    }

    private void validateWithReason(List<Point> points) {
        for (Rule rule : rules) {
            if (!rule.validate(points)) {
                throw new RoomException(rule.getMessage());
            }
        }
    }
}