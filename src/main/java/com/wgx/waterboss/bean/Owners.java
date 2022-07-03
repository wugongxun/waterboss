package com.wgx.waterboss.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 业主表
 * author:wgx
 * version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("t_owners")
@KeySequence(value = "seq_owners", dbType = DbType.ORACLE)
public class Owners {
    @TableId(value = "id", type = IdType.INPUT)
//    @TableField(value = "id")
    private Long id;
//    @TableField(value = "name")
    private String name;
//    @TableField(value = "addressid")
    private Long addressid;
//    @TableField(value = "housenumber")
    private String housenumber;
//    @TableField(value = "watermeter")
    private String watermeter;
//    @TableField(value = "adddate")
    private Date adddate;
//    @TableField(value = "ownertypeid")
    private Long ownertypeid;
}
