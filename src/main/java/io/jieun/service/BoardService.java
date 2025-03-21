package io.jieun.service;

import io.jieun.data.Board;
import io.jieun.repository.BoardRepository;

public class BoardService {

    private BoardRepository boardRepository = new BoardRepository();

    public int createBoard(String boardName, String description) {
        return boardRepository.save(boardName, description);
    }

    public Board getBoardById(int boardId){
        return boardRepository.getBoardById(boardId);
    }

    public Board getBoardByName(String name){
        return boardRepository.getBoardByName(name);
    }

    public void updateBoard(int boardId, String boardName, String description) {
        boardRepository.update(boardId, boardName, description);
    }

    public boolean removeBoardById(int boardId) {
        try{
            boardRepository.remove(boardId);
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
