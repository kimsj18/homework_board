import java.text.SimpleDateFormat;
import java.util.*;

public class BoardExample {
    static Scanner sc = new Scanner(System.in);
    static List<Board> boardlist = new ArrayList<>();

    static void mainMunu() {

            int choice;

            System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit ");
            System.out.print("메뉴 선택: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("*** create() 메소드 실행됨");
                    Board.Create();
                    break;


                case 2:
                    System.out.println();
                    System.out.println("*** read() 메소드 실행됨");
                    Board.Read();
                    break;

                case 3:
                    System.out.println();
                    System.out.println("*** clear() 메소드 실행됨");
                    Board.Clear();
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
                SimpleDateFormat aaa = new SimpleDateFormat("yyyy.MM.dd");
                System.out.println("[게시물 목록]");
                System.out.println("---------------------------------------------------------");
                System.out.println("no      writer      date          title");
                System.out.println("---------------------------------------------------------");
                boardlist.sort(Comparator.comparing(Board::getBno));
                for(Board board : boardlist){
//
                    System.out.printf("%d\t\t %s\t\t %s\t\t %s\n",board.getBno()+1,board.getBwriter(),aaa.format(board.getBdate()),board.getBtitle());

                }
                System.out.println();
                System.out.println("------------------------------------------------- -------");
                mainMunu();
            }





}


