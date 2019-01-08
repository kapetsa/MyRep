package com.novik.workbooks.Controllers;

import com.novik.workbooks.domain.Comment;
import com.novik.workbooks.domain.User;
import com.novik.workbooks.repositories.CommentRepo;
import com.novik.workbooks.repositories.WBookRepo;
import com.novik.workbooks.domain.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class WorkbookController {
    @Autowired
    private WBookRepo wbookrepo;


    @Autowired
    private CommentRepo commentRepo;


    @GetMapping("/book/{id}")
    public String readWB( @AuthenticationPrincipal User user, @PathVariable Long id, Model model) {
        Workbook workbook = wbookrepo.findById(id).get();
        boolean isAuthor = user.getUsername().equals(workbook.getAuthorName());
        Iterable<Comment> comments = commentRepo.findByBookId(workbook.getId());

        {
            model.addAttribute("isAuthor", isAuthor);
        }
        model.addAttribute("bookname", workbook.getName());
        model.addAttribute("author", workbook.getAuthorName());
        model.addAttribute("spec", workbook.getSpec());
        model.addAttribute("description", workbook.getDescription());
        model.addAttribute("body", workbook.getBody());
        model.addAttribute("comments", comments);

        return "book";
    }


    @PostMapping("/book/{id}")
    public String addComment(@AuthenticationPrincipal User user, @PathVariable Long id, String text,
                            Model model) {

        Workbook workbook = wbookrepo.findById(id).get();
        Comment comment = new Comment();
        comment.setBook(workbook);
        comment.setAuthor(user.getUsername());
        comment.setText(text);

            commentRepo.save(comment);
            return "redirect:/book/{id}";



    }
}


