package io.jieun.config;

import io.jieun.data.Account;
import io.jieun.data.Board;
import io.jieun.repository.AccountRepository;
import io.jieun.repository.BoardRepository;
import io.jieun.repository.PostRepository;
import io.jieun.sys.Container;

import java.util.ArrayList;
import java.util.List;

public class PostConstructor {

    private final AccountRepository accountRepository;
    private final BoardRepository boardRepository;
    private final PostRepository postRepository;

    public PostConstructor() {
        this.accountRepository = Container.accountRepository;
        this.boardRepository = Container.boardRepository;
        this.postRepository = Container.postRepository;

        dataInitialize(5, 4, 50);
    }

    protected void dataInitialize(int accountAmount, int boardAmount, int postAmount ) {

        List<Account> accountList = new ArrayList<>();
        List<Board> boardList = new ArrayList<>();

        Account admin = accountRepository.saveAdmin(
                "admin",
                "admin",
                "관리자",
                "admin@admin.com"
        );

        boardRepository.save(
                "공지사항",
                "공지사항 입니다."
        );

        for ( int i = 0; i < accountAmount; i++ ) {

            Account account = accountRepository.save(
                    "user" + i
                    , "user" + i
                    , "사용자" + i
                    , "user" + i + "@user.com"
            );

            accountList.add(account);
        }

        for ( int i = 0; i < boardAmount; i++ ) {

            Board savedBoard = boardRepository.save(
                    "게시판" + i,
                    "게시판" + i
            );

            boardList.add(savedBoard);

        }

        for ( int i = 0; i < postAmount; i++ ) {
            postRepository.save(
                    "제목 "  + i,
                    "내용 " + i,
                    accountList.get(i % accountAmount),
                    boardList.get(i % boardAmount)
            );
        }

    }


}
