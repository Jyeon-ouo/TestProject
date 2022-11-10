package com.example.testproject;

//테이블이라고 생각하고 테이블에 들어갈 속성 값 넣기
//파이어베이스는 RDBMS와 다르게 테이블이라는 개념이 없음, 원래는 '키'
public class otcAdd {
    private String otcName;  //일반의약품명
    private String otcReason;  //일반의약품 복용 이유
    private String otcDate;  //일반의약품 복용 날짜

    public otcAdd(){} //생성자 메서드

    public String getOtcName() {
        return otcName;
    }

    public void setOtcName(String otcName) {
        this.otcName = otcName;
    }

    public String getOtcReason() {
        return otcReason;
    }

    public void setOtcReason(String otcReason) {
        this.otcReason = otcReason;
    }

    public String getOtcDate() {
        return otcDate;
    }

    public void setOtcDate(String otcDate) {
        this.otcDate = otcDate;
    }

    //값을 추가할 때 쓰는 함수, MainActivity에서 사용
    public otcAdd(String otcName, String otcReason, String otcDate){
        this.otcName = otcName;
        this.otcReason = otcReason;
        this.otcDate = otcDate;
    }
}
