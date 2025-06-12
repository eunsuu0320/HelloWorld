package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
  int replyNo;
  int boardNo;
  String reply;
  String replyer;
  Date replyDate;
}
