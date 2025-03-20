package io.jieun;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean programStatus = true;
        int id = 0;

        while (programStatus) {
            System.out.print("명령어> ");
            String command = sc.nextLine().trim();

            switch (command) {
                case "write":
                    System.out.println("게시글을 작성합니다.");
                    System.out.print("제목: ");
                    String title = sc.nextLine().trim();

                    System.out.print("내용: ");
                    String body = sc.nextLine().trim();
                    id++;
                    Post post = new Post(id, title, body);
                    System.out.println("게시글이 작성되었습니다!");
                    System.out.println(post);

                    break;

                case "exit":
                    System.out.println("프로그램을 종료합니다.");
                    programStatus = false;
                    break;
                default:
                    System.out.println("존재하지 않는 명령어 입니다!");


            }
        }

    }


    static class Post {

        private int id;

        private String title;
        private String body;

        private LocalDate createdAt;
        private LocalDate updatedAt;


        public Post(int id, String title, String body) {
            this.id = id;
            this.title = title;
            this.body = body;
            this.createdAt = LocalDate.now();
            this.updatedAt = LocalDate.now();
        }

        @Override
        public String toString() {
            return "Post{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", body='" + body + '\'' +
                    ", createdAt=" + createdAt +
                    ", updatedAt=" + updatedAt +
                    '}';
        }
    }


}



