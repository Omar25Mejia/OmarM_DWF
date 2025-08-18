package sv.edu.udb.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.repository.domain.Post;
import sv.edu.udb.repository.domain.PostComment;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostCommentRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostCommentRepository postCommentRepository;

    @Test
    void shouldHasOneComment_When_FindAll() {
        final List<PostComment> list = postCommentRepository.findAll();
        assertNotNull(list);
        assertEquals(1, list.size());
    }

    @Test
    void shouldGetComment_When_IdExist() {
        final Long id = 1L;
        final PostComment pc = postCommentRepository.findById(id);
        assertNotNull(pc);
        assertEquals(id, pc.getId());
        assertEquals("Great post", pc.getReview());
        assertNotNull(pc.getPost());
        assertEquals(1L, pc.getPost().getId());
    }

    @Test
    @Transactional
    void shouldSaveAndDeleteComment_When_New() {
        final Post post = postRepository.findById(1L);
        assertNotNull(post);

        final Long newId = 2L;
        final PostComment newPc = PostComment.builder()
                .id(newId)
                .review("Second review")
                .commentDate(LocalDate.of(2024, 8, 24))
                .post(post)
                .build();

        postCommentRepository.save(newPc);

        final PostComment fetched = postCommentRepository.findById(newId);
        assertNotNull(fetched);
        assertEquals("Second review", fetched.getReview());
        assertEquals(1L, fetched.getPost().getId());

        postCommentRepository.delete(newPc);
        final PostComment deleted = postCommentRepository.findById(newId);
        assertNull(deleted);
    }
}
