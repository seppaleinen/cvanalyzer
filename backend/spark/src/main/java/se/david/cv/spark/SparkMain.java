package se.david.cv.spark;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;

public class SparkMain {
    public static void main(String[] args) {
        get("/ping", (req, res) -> {
            res.status(200);
            return "pong";
        });
    }

}
