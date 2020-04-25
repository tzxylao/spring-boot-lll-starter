package com.company.project.backgroundservice.pojo.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

import java.util.Date;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-24 15:25:35
 **/
@Data
@ApiModel(value = "订单表结果参数")
public class OrderResultVo {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "订单编号", name = "orderNo")
    private String orderNo;

    @ApiModelProperty(value = "状态 1待付款 2待发货 3待收货 4完成", name = "state")
    private Integer state;

    @ApiModelProperty(value = "0 失效  1未失效", name = "invalidState")
    private Integer invalidState;

    @ApiModelProperty(value = "活动id", name = "activityId")
    private Long activityId;

    @ApiModelProperty(value = "用户id", name = "userId")
    private Long userId;

    @ApiModelProperty(value = "商品id", name = "goodId")
    private Long goodId;

    @ApiModelProperty(value = "商品数量", name = "goodNum")
    private Integer goodNum;

    @ApiModelProperty(value = "单价", name = "unitPrice")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "总价", name = "toatlPrice")
    private BigDecimal toatlPrice;

    @ApiModelProperty(value = "实付款", name = "realPay")
    private BigDecimal realPay;

    @ApiModelProperty(value = "支付交易号", name = "tradeNo")
    private String tradeNo;

    @ApiModelProperty(value = "支付类型 1-支持宝 2-微信 3-扫码支付(支付宝) 4-扫码支付(微信) 5-网银转账 6-其他", name = "payType")
    private Integer payType;

    @ApiModelProperty(value = "创建人", name = "creator")
    private String creator;

    @ApiModelProperty(value = "创建时间", name = "created")
    private Date created;

    @ApiModelProperty(value = "修改人", name = "modifier")
    private String modifier;

    @ApiModelProperty(value = "修改时间", name = "modified")
    private Date modified;

    @ApiModelProperty(value = "sku编号", name = "skuCode")
    private String skuCode;

    @ApiModelProperty(value = "0 展示 1不展示", name = "beShow")
    private Integer beShow;

}
