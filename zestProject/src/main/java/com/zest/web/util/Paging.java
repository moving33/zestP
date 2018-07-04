package com.zest.web.util;

import org.springframework.stereotype.Component;

//페이징 처리 모델
@Component
public class Paging {
    private Integer w_size; //페이지당 보여줄 글수
    private Integer p_size; //페이지번호 표시수 (= 페이지블록사이즈)
    private Integer writing_Count; //전체 글수
    private Integer cur_Page; //현재 페이지

    public Paging() {
        super();
    }

    public void setPaging(Integer w_size, Integer p_size, Integer writing_Count, Integer cur_Page) {
        this.w_size = w_size;
        this.p_size = p_size;
        this.writing_Count = writing_Count;
        this.cur_Page = cur_Page;
    }
    /**
     * 총 페이지 수를 리턴해주는 메소드 , 전체 글수를 페이지당 보여줄
     * 글수로 나눈값에 전체글수를 페이지당 보여줄 글수로
     * 나머지 연산을 하여 구한값이 0보다 크면 1을더하고
     * 아니면 0을 더함
     */
    public Integer getPage_Count(){
        return (writing_Count/w_size)+(writing_Count%w_size > 0 ? 1 : 0);
    }

    /** 페이지 시작수를 리턴해주는 메서드
     *  = 사용자가 보는 페이지의 범위를 의미함 예를들어 페이지블럭의 표시 페이지갯수가 4이고 현재 페이지가 5이면
     *  해당 페이지 블록에서 보여질 페이지 범위는 5 6 7 8 이렇게 나와야됨 이걸 메서드로 구현것
     * */
    public Integer getPage_start(){
        return ((cur_Page - 1)/p_size)*p_size+1;
    }

    /** 페이지의 마지막 수를 리턴해주는 메서드
     *  Math.min() 은 min(a,b) a <= b 비교하여 참이면 a를 틀리면 b를 리턴함
     *  ex) 총 페이지 수가 8이고 페이지블록이 3일시 7페이지를 보고 있으면 7 8 9 이렇게 나오면 안되고  7 8 이렇게 나와야하기떄문...
     *
     * @return 페이지의 마지막수
     */
    public Integer getPage_end(){
        return Math.min(getPage_start()+p_size -1,getPage_Count());
    }

    /**
     * Previous(이전) 표시 여부 현재 페이지가 1일경우 필요 없음
     * @return
     */
    public boolean isPre(){
        return getPage_start() !=1;
    }

    /**
     * Next(다음) 표시 여부 마지막페이지가 전체 페이지수보다 작을경우 필요
     * @return
     */
    public boolean isNext(){
        return getPage_end() < getPage_Count();
    }


    //페이지의 끝번호 , 해당페이지에서 마지막글의 번호를 의미함 why? 최신글은 항상 1번이기 때문...????????
    public Integer getWriting_End(){
        return cur_Page * w_size;
    }

    //페이지의 시작번호
    public Integer getWriting_Start(){
        return getWriting_End() - w_size +1;
    }

    public Integer getW_size() {
        return w_size;
    }

    public void setW_size(Integer w_size) {
        this.w_size = w_size;
    }

    public Integer getP_size() {
        return p_size;
    }

    public void setP_size(Integer p_size) {
        this.p_size = p_size;
    }

    public Integer getWriting_Count() {
        return writing_Count;
    }

    public void setWriting_Count(Integer writing_Count) {
        this.writing_Count = writing_Count;
    }

    public Integer getCur_Page() {
        return cur_Page;
    }

    public void setCur_Page(Integer cur_Page) {
        this.cur_Page = cur_Page;
    }
}
