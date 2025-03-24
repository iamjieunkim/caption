package io.jieun.service;

import io.jieun.data.Board;
import io.jieun.data.Post;
import io.jieun.repository.BoardRepository;

public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public int createBoard(String boardName, String description) {
        return boardRepository.save(boardName, description).getId();
    }

    public Board getBoardById(int boardId) {
        return boardRepository.getBoardById(boardId);
    }

    public Board getBoardByName(String name) {
        return boardRepository.getBoardByName(name);
    }

    public void updateBoard(int boardId, String boardName, String description) {
        boardRepository.update(boardId, boardName, description);
    }

    public boolean removeBoardById(int boardId) {

        try {
            boardRepository.remove(boardId);
        } catch ( Exception e ) {
            return false;
        }

        return true;

    }

    public void putPostAtBoard(Board board, Post post) {
        board.getPostList().add(post);
    }

}
