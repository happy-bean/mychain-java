package org.happybean;

import java.util.Date;

/**
 * @author wgt
 * @date 2018-07-16
 * @description 区块
 **/
public class Block {
    public String hash;
    public String previousHash;
    private String data; //数据
    private long timeStamp; //时间戳

    //区块构造函数
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); //确保hash值的来源
    }

    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        data
        );
        return calculatedhash;
    }
}
