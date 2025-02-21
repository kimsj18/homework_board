import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Data

public class Board {

    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private Date bdate;

    public Board(int bno, String btitle, String bcontent, String bwriter) {



        this.bno = bno;
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
        this.bdate = new Date();

    }


    public Board() {


    }


    static List<Integer> removelist = new ArrayList<>();

    static void Create() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("새 게시물 입력");
            System.out.print("제목: ");
            String btitle = sc.nextLine();
            System.out.print("내용: ");
            String bcontent = sc.nextLine();
            System.out.print("작성자: ");
            String briter = sc.nextLine();
            System.out.println("---------------");
            System.out.println("보조 메뉴: 1.OK | 2.Cancel");
            int select = sc.nextInt();
            sc.nextLine();
//

            if (select == 1) {
                Board newBoard = new Board();
                if (!removelist.isEmpty()) {
                    newBoard.bno = removelist.remove(0);
//                    Board newBoard = new Board();
//                    newBoard.btitle = btitle;
//                    newBoard.bcontent = bcontent;
//                    newBoard.bwriter = briter;
//                    newBoard.bdate = new Date();
//
//                    BoardExample.boardlist.add(newBoard);
//
//                    System.out.println("새게시물추가");
//                    break;1
                } else {
//                    Board newBoard = new Board();
                    newBoard.bno = BoardExample.boardlist.size();
//                    newBoard.btitle = btitle;
//                    newBoard.bcontent = bcontent;
//                    newBoard.bwriter = briter;
//                    newBoard.bdate = new Date();
//
//                    BoardExample.boardlist.add(newBoard);
//
//                    System.out.println("새게시물추가");
//
//                    break;

                }
                newBoard.btitle = btitle;
                newBoard.bcontent = bcontent;
                newBoard.bwriter = briter;
                newBoard.bdate = new Date();

                BoardExample.boardlist.add(newBoard);

                System.out.println("새게시물추가");
                BoardExample.list();
                break;


            }
            if (select == 2) {
                BoardExample.list();
                break;
            } else {
            }

        }
    }

    static void Read() {

        Scanner sc = new Scanner(System.in);
        System.out.println("게시물 읽기");
        System.out.println();
        System.out.print("bno: ");
        int a = sc.nextInt() - 1;
        System.out.println("###########");
        if (a >= 0 && a < BoardExample.boardlist.size()) {
            Board board = BoardExample.boardlist.get(a);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

            System.out.print("번호: ");
//            System.out.println((BoardExample.boardlist.get(BoardExample.boardlist.get(a).getBno())));
            System.out.println(board.getBno() + 1);
            System.out.print("제목: ");
            System.out.println(board.getBtitle());
            System.out.print("내용: ");
            System.out.println(board.getBcontent());
            System.out.print("작성자: ");
            System.out.println(board.getBwriter());
            System.out.print("날짜: ");
            System.out.println(dateFormat.format((board.getBdate())));
            System.out.println("-----------------------");
        }


        while (true) {
//                Board board = new Board();

            System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
            System.out.print("메뉴 선택");
            int selec = sc.nextInt();
            sc.nextLine();

            if (selec == 1) {
                update(a);
                break;
            }


            if (selec == 2) {
//                    removelist.add(board1.getBno());
                BoardExample.boardlist.remove(a);
                BoardExample.list();
                break;

            } else if (selec == 3) {
                BoardExample.list();
                break;
            } else {
                Read();

            }
        }
    }





    static void Clear() {


        BoardExample.boardlist.clear();
        BoardExample.list();
    }

    static void Exit() {


    }

    public static void update(int a) {
        Scanner sc = new Scanner(System.in);
        Board board = BoardExample.boardlist.get(a);
        System.out.println("[수정 내용 입력]");
        System.out.print("제목: ");
        String newbtitle = sc.nextLine();
        System.out.print("내용: ");
        String newbcontent = sc.nextLine();
        System.out.print("작성자: ");
        String newbriter = sc.nextLine();
        System.out.println("---------------");
        System.out.println("보조 메뉴: 1.OK | 2.Cancel");
        int select = sc.nextInt();
        sc.nextLine();

//            SimpleDateFormat dateFormat = new SimpleDateFormat("yy.MM.ss");

        if (select == 1) {

            board.setBtitle(newbtitle);
            board.setBcontent(newbcontent);
            board.setBwriter(newbriter);
            board.setBdate(new Date());

//                        BoardExample.boardlist.add(newBoard);

            System.out.println("새게시물추가");
            BoardExample.list();


        } else if (select == 2) {

            BoardExample.list();

        }
    }


}




