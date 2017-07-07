package sparglingblogapi;

import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import spark.ResponseTransformer;

import static spark.Spark.*;

public class BlogApplication {

    private static final Gson GSON = new Gson();

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new BlogModule());
        PostService postService = injector.getInstance(PostService.class);

        path("/api", () -> {
            path("/posts",() -> {
                get("",(req,res) -> postService.get(),GSON::toJson);
                post("",(req,res) -> postService.create(GSON.fromJson(req.body(),Post.class)),GSON::toJson);
                get("/:id",(req,res) -> postService.get(req.params("id")),GSON::toJson);
                delete("/:id",(req,res) -> {
                    postService.delete(req.params("id"));
                    return null;
                });
            });
        });
    }



}