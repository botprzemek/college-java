package pl.wsti.edu.no_5;

import java.util.*;

public class Exercise {
    int[][] points = {
            {2, 3},
            {-3, 0},
            {-1, 2},
            {-1, 2},
            {-3, -2}
    };

    public void set() {
        TreeSet<Coordinate> coordinates = new TreeSet<>();
        int[][] points = {
                {2, 3},
                {-3, 0},
                {-1, 2},
                {-1, 2},
                {-3, -2}
        };

        for (int[] point : points) {
            coordinates.add(new Coordinate(point[0], point[1]));
        }

        for (Coordinate coordinate : coordinates) {
            System.out.println(coordinate.toString());
        }
    }

    public void map() {
        Map<Coordinate, String> coordinates = new HashMap<Coordinate, String>();

        String[] mapping = {
            "Czerwony",
            "Czarny",
            "Czerwony",
            "Czarny",
        };

        for (int i = 0; i <= points.length; i++) {
            Coordinate coordinate = new Coordinate(points[i][0], points[i][1]);

            coordinates.put(coordinate, mapping[i]);
        }

        Coordinate searched = new Coordinate(points[2][0], points[2][1]);

        System.out.println(
            "Punkt " + searched.toString() +
            " ma kolor " + coordinates.get(searched)
        );
    }
}