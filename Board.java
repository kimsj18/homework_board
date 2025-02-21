import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data

public class Board {

    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private LocalDateTime bdate;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public Board(int bno, String btitle, String bcontent, String bwriter) {
        this.bno = bno;
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
        this.bdate = LocalDateTime.now();
    }

    public Board() {
    }

}




