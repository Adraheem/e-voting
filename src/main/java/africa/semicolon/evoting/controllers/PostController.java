package africa.semicolon.evoting.controllers;

import africa.semicolon.evoting.data.dtos.requests.CreatePostRequestDto;
import africa.semicolon.evoting.data.dtos.responses.PostDto;
import africa.semicolon.evoting.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("")
    @Operation(summary = "Create new post")
    public ResponseEntity<PostDto> createNewPost(@RequestBody @Valid CreatePostRequestDto request){
        return new ResponseEntity<>(postService.createPost(request), HttpStatus.CREATED);
    }

    @PutMapping("")
    @Operation(summary = "Update post")
    public ResponseEntity<PostDto> updatePost(@RequestBody @Valid PostDto request){
        return new ResponseEntity<>(postService.updatePost(request), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get post")
    public ResponseEntity<PostDto> getPost(@PathVariable Long id){
        return new ResponseEntity<>(postService.getPost(id), HttpStatus.OK);
    }

    @GetMapping("/{electionId}/all")
    @Operation(summary = "Get all posts in an election")
    public ResponseEntity<List<PostDto>> getAllPostsInElection(@PathVariable Long electionId){
        return new ResponseEntity<>(postService.getPostsByElectionId(electionId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete post")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Deleted successfully!", HttpStatus.OK);
    }
}
