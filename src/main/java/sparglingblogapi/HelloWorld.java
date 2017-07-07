package sparglingblogapi;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {

        new HelloWorld().routes();
    }

    private void routes() {
        path("/api", () -> {
            path("/posts",() -> {
                get("",(req,res) -> "post list");
                post("",(req,res) -> req.body());
                get("/:id",(req,res) -> "single post "+req.params("id"));
                delete("/:id",(req,res) -> "deleted post "+req.params("id"));
            });
        });
    }
}