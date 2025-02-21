import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BoardExample {
    static Scanner sc = new Scanner(System.in);
    static List<Integer> removelist = new ArrayList<>();
    static List<Board> boardlist = new ArrayList<>();


    static void run(){
        System.out.println("[게시물 목록]");
        System.out.println("---------------------------------------------------------");
        System.out.println("no      writer      date          title");
        System.out.println("---------------------------------------------------------");
        System.out.println("1      winter     2024.01.02      게시판에 오신 것을 환영합니다.");
        System.out.println("2      winter     2024.01.01      올 겨울은 많이 춥습니다.");

        System.out.println("------------------------------------------------- -------");
        BoardExample.boardlist.add(new Board(0,"눈 오는 날","어렵다.","winter"));
        BoardExample.boardlist.add(new Board(1,"크리스마스","집가고싶다","winter"));
        BoardExample.boardlist.add(new Board(2,"봄의 정원","정원의 꽃이 예쁘네요","winter"));
        mainMunu();
    }


    static void mainMunu() {

        int choice;

        System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit ");
        System.out.print("메뉴 선택: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println();
                System.out.println("*** create() 메소드 실행됨");
                BoardExample.Create();
                break;


            case 2:
                System.out.println();
                System.out.println("*** read() 메소드 실행됨");
                BoardExample.Read();
                break;

            case 3:
                System.out.println();
                System.out.println("*** clear() 메소드 실행됨");
                BoardExample.Clear();
                break;

            case 4:
                System.out.println("**게시판 종료**");
                break;


            default:
                System.out.println("재입력");
                mainMunu();

        }
    }


    public static void list () {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        System.out.println("[게시물 목록]");
        System.out.println("-".repeat(50));
        System.out.println("no\twriter\tdate\ttitle");
        System.out.println("-".repeat(50));

        boardlist.sort(Comparator.comparing(Board::getBno));
        for(Board board : boardlist){
//
            System.out.println((board.getBno()+1)+"\t"+board.getBwriter()+"\t"+now.format(dtf)+"\t"+board.getBtitle());

        }
        System.out.println();
        System.out.println("-".repeat(50));
        mainMunu();
    }



    static void Create() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
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
                    newBoard.setBno(removelist.remove(0));
//
                } else {
//                    Board newBoard = new Board();
                    newBoard.setBno(BoardExample.boardlist.size());
////
                }
                newBoard.setBtitle(btitle);
                newBoard.setBcontent(bcontent);
                newBoard.setBwriter(briter);
                newBoard.setBdate(now);
                BoardExample.boardlist.add(newBoard);


//

                System.out.println("새게시물추가");
                BoardExample.list();
                break;


            }
            if (select == 2) {
                BoardExample.list();
                break;
            } else {
                System.out.println("잘못 선택하였습니다.");
                BoardExample.list();

            }

        }
    }

    static void Read() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        Scanner sc = new Scanner(System.in);
        System.out.println("게시물 읽기");
        System.out.println();
        System.out.print("bno: ");
        int a = sc.nextInt() - 1;
        System.out.println("###########");
        if (a >= 0 && a < BoardExample.boardlist.size()) {
            Board board = BoardExample.boardlist.get(a);

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
            System.out.println(now.format(dtf));
            System.out.println("-----------------------");
            readManu(a);
        }
    }

        static void readManu(int a){
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
                readManu(a);


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
            board.setBdate(LocalDateTime.now());

//          BoardExample.boardlist.add(newBoard);

            System.out.println("새게시물추가");
            BoardExample.list();


        } else if (select == 2) {

            BoardExample.list();

        }else{
            System.out.println("잘못 입력하였습니다.");
            update(a);
        }

    }





}


