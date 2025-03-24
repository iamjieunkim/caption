package io.jieun.sys;

import io.jieun.config.PostConstructor;
import io.jieun.controller.AccountController;
import io.jieun.controller.BoardController;
import io.jieun.controller.PostController;
import io.jieun.repository.AccountRepository;
import io.jieun.repository.BoardRepository;
import io.jieun.repository.PostRepository;
import io.jieun.service.AccountService;
import io.jieun.service.BoardService;
import io.jieun.service.PostService;

import java.util.Scanner;

public class Container {

    public static Scanner sc;

    public static Session session;

    public static PostRepository postRepository;
    public static BoardRepository boardRepository;
    public static AccountRepository accountRepository;

    public static PostService postService;
    public static BoardService boardService;
    public static AccountService accountService;

    public static PostController postController;
    public static BoardController boardController;
    public static AccountController accountController;

    public static PostConstructor postConstructor;

    static {

        sc = new Scanner(System.in);

        session = new Session();

        accountRepository = new AccountRepository();
        boardRepository = new BoardRepository();
        postRepository = new PostRepository();

        accountService = new AccountService(accountRepository);
        boardService = new BoardService(boardRepository);
        postService = new PostService(postRepository, accountService);

        accountController = new AccountController(sc, accountService);
        boardController = new BoardController(sc, boardService);
        postController = new PostController(sc, postService, boardService);

        postConstructor = new PostConstructor();

    }

}