package io.jieun.controller;

import io.jieun.data.Post;
import io.jieun.service.PostService;
import io.jieun.sys.Request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostController {

    private Scanner sc = new Scanner(System.in);

    private PostService postService = new PostService();

    //요청 다루어 주는 곳
    public void requestHandle(Request request) {
        switch (request.getTarget()) {
            case "remove":
                try {
                    System.out.println("게시물을 삭제합니다!");
                    System.out.print("게시물 번호: ");
                    String targetId = sc.nextLine().trim();

                    int postId = Integer.parseInt(targetId);

                    //TODO: Service를 이용해서 Post지우기
                    postService.removeById(postId);
                    System.out.println("성공적으로 삭제 되었습니다.!");


                } catch (IndexOutOfBoundsException e) {
                    System.out.println("게시물 번호를 확인해주세요!!");
                } catch (NumberFormatException e) {
                    System.out.println("게시물 번호는 정수로 입력하여 주세요 :)");
                } catch (NullPointerException e) {
                    System.out.println("비어있는 게시물 입니다.");
                } catch (Exception e) {
                    System.out.println("알 수 없는 오류가 발생했습니다.");
                    e.printStackTrace();
                }

                break;
            case "edit":
                try {
                    System.out.println("게시물을 수정합니다!");

                    System.out.print("게시물 번호: ");
                    String targetId = sc.nextLine().trim();

                    int postId = Integer.parseInt(targetId);



                    System.out.print("제목: ");
                    String updateTitle = sc.nextLine().trim();

                    System.out.print("내용: ");
                    String updateBody = sc.nextLine().trim();

                    //TODO: Service를 이용해서 Post수정하기
                    postService.update(postId, updateTitle, updateBody);

                    System.out.println("게시물 수정이 완료되었습니다!");

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("게시물 번호를 확인해주세요!!");
                } catch (NumberFormatException e) {
                    System.out.println("게시물 번호는 정수로 입력하여 주세요 :)");
                } catch (NullPointerException e) {
                    System.out.println("비어있는 게시물 입니다.");
                } catch (Exception e) {
                    System.out.println("알 수 없는 오류가 발생했습니다.");
                    e.printStackTrace();
                }

                break;
            case "view":
                try {
                    System.out.println("게시물을 조회합니다.");

                    System.out.println("게시물 번호는 양의 정수(+)로 입력해주세요!!");
                    System.out.print("게시물 번호: ");
                    String targetIdStr = sc.nextLine().trim();
                    int targetId = Integer.parseInt(targetIdStr);

                    //todo: Service에서 Post찾아서 가져오기
                    Post findPost = postService.getById(targetId);

                    if (findPost != null) {
                        System.out.println("게시물 번호: " + findPost.getId());
                        System.out.println("게시물 제목: " + findPost.getTitle());
                        System.out.println("게시물 내용: " + findPost.getBody());
                        System.out.println("게시물 생성일: " + findPost.getCreatedAt());
                    } else {
                        System.out.println("게시물이 존재하지 않습니다.");
                    }

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("게시물 번호를 확인해주세요!!");
                } catch (NumberFormatException e) {
                    System.out.println("게시물 번호는 정수로 입력하여 주세요 :)");
                } catch (NullPointerException e) {
                    System.out.println("비어있는 게시물 입니다.");
                } catch (Exception e) {
                    System.out.println("알 수 없는 오류가 발생했습니다.");
                    e.printStackTrace();
                }
                break;
            case "add":
                System.out.println("게시글을 작성합니다.");
                System.out.print("제목: ");
                String title = sc.nextLine().trim();

                System.out.print("내용: ");
                String body = sc.nextLine().trim();

                //id++;
                //VO(value object), DTO(data trans Object) 2개는 하는일이 비슷하다.
                //VO-값을 집어넣기만 하는 객체, DTO값을 전달하는 객체

                //postService.save(title, body);
                //todo: Service를 이용해서 Post를 저장하기
                int savedPostId = postService.save(title, body);

                //id를 받아오는것 보다 방금 작성된 게시글 번호를 받아서 오는게 더 좋다. 그래서 newPost.getId()
                System.out.println(savedPostId + "번 게시물 작성을 완료했습니다!");

                //System.out.println(newPost);

                break;
            default:
                System.out.println("존재하지 않는 명령어 입니다.");
        }
    }

}
