package com.example.hyejin.sungshintcommuproject.Data;
import java.util.ArrayList;

public class PostData{

    private int seq;                                                                                //게시글의 seq
    private int writerSeq;                                                                          //글쓴 사람의 seq(고유번호)
    private boolean isAnonymity;                                                                    //글쓴 사람의 익명 여부 : true = 익명 / false = 실명

    private String boardName;                                                                       //글이 쓰여진 게시판의 이름
    private String contents;                                                                        //게시글 내용
    private ArrayList<String> imageUrls;                                                            //게시글에 첨부된 이미지의 url들
    //동영상 링크는 일단 보류
    private ArrayList<String> viedioUrls;                                                           //게시글에 첨부된 동영상의 url들
    private String writeDate;                                                                       //게시글이 최초로 쓰여진 날짜

    private boolean isUpdate;                                                                       //게시글 수정여부 : 기본값 false
    private String updateDate;                                                                      //게시글 수정 날짜

    private boolean isDelete;                                                                       //게시글의 삭제 여부 : 기본값false
    private String deleteDate;                                                                      //게시글의 삭제 날짜 : 삭제 후 3개월 지나면 디비에서 완전 삭제.


    public PostData() {
    }

    public PostData(int seq, int writerSeq, boolean isAnonymity, String boardName, String contents, ArrayList<String> imageUrls, ArrayList<String> viedioUrls, String writeDate, boolean isUpdate, String updateDate, boolean isDelete, String deleteDate) {
        this.seq = seq;
        this.writerSeq = writerSeq;
        this.isAnonymity = isAnonymity;
        this.boardName = boardName;
        this.contents = contents;
        this.imageUrls = imageUrls;
        this.viedioUrls = viedioUrls;
        this.writeDate = writeDate;
        this.isUpdate = isUpdate;
        this.updateDate = updateDate;
        this.isDelete = isDelete;
        this.deleteDate = deleteDate;
    }

    public int getSeq() {
        return seq;
    }

    public int getWriterSeq() {
        return writerSeq;
    }

    public boolean isAnonymity() {
        return isAnonymity;
    }

    public String getBoardName() {
        return boardName;
    }

    public String getContents() {
        return contents;
    }

    public ArrayList<String> getImageUrls() {
        return imageUrls;
    }

    public ArrayList<String> getViedioUrls() {
        return viedioUrls;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public boolean isUpdate() {
        return isUpdate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public String getDeleteDate() {
        return deleteDate;
    }
}
