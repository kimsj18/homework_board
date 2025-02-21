public class testMain {
    public static void main(String[] args) {


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
        BoardExample.list();
    }
}
