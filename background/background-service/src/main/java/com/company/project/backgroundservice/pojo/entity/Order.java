package com.company.project.backgroundservice.pojo.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "order_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单编号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 状态 1待付款 2待发货 3待收货 4完成
     */
    private Integer state;

    /**
     * 0 失效  1未失效
     */
    @Column(name = "invalid_state")
    private Integer invalidState;

    /**
     * 活动id
     */
    @Column(name = "activity_id")
    private Long activityId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 商品id
     */
    @Column(name = "good_id")
    private Long goodId;

    /**
     * 商品数量
     */
    @Column(name = "good_num")
    private Integer goodNum;

    /**
     * 单价
     */
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    /**
     * 总价
     */
    @Column(name = "toatl_price")
    private BigDecimal toatlPrice;

    /**
     * 实付款
     */
    @Column(name = "real_pay")
    private BigDecimal realPay;

    /**
     * 支付交易号
     */
    @Column(name = "trade_no")
    private String tradeNo;

    /**
     * 支付类型 1-支持宝 2-微信 3-扫码支付(支付宝) 4-扫码支付(微信) 5-网银转账 6-其他
     */
    @Column(name = "pay_type")
    private Integer payType;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 修改时间
     */
    private Date modified;

    /**
     * sku编号
     */
    @Column(name = "sku_code")
    private String skuCode;

    /**
     * 0 展示 1不展示
     */
    @Column(name = "be_show")
    private Integer beShow;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取订单编号
     *
     * @return order_no - 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单编号
     *
     * @param orderNo 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取状态 1待付款 2待发货 3待收货 4完成
     *
     * @return state - 状态 1待付款 2待发货 3待收货 4完成
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态 1待付款 2待发货 3待收货 4完成
     *
     * @param state 状态 1待付款 2待发货 3待收货 4完成
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取0 失效  1未失效
     *
     * @return invalid_state - 0 失效  1未失效
     */
    public Integer getInvalidState() {
        return invalidState;
    }

    /**
     * 设置0 失效  1未失效
     *
     * @param invalidState 0 失效  1未失效
     */
    public void setInvalidState(Integer invalidState) {
        this.invalidState = invalidState;
    }

    /**
     * 获取活动id
     *
     * @return activity_id - 活动id
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * 设置活动id
     *
     * @param activityId 活动id
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取商品id
     *
     * @return good_id - 商品id
     */
    public Long getGoodId() {
        return goodId;
    }

    /**
     * 设置商品id
     *
     * @param goodId 商品id
     */
    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    /**
     * 获取商品数量
     *
     * @return good_num - 商品数量
     */
    public Integer getGoodNum() {
        return goodNum;
    }

    /**
     * 设置商品数量
     *
     * @param goodNum 商品数量
     */
    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    /**
     * 获取单价
     *
     * @return unit_price - 单价
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * 设置单价
     *
     * @param unitPrice 单价
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * 获取总价
     *
     * @return toatl_price - 总价
     */
    public BigDecimal getToatlPrice() {
        return toatlPrice;
    }

    /**
     * 设置总价
     *
     * @param toatlPrice 总价
     */
    public void setToatlPrice(BigDecimal toatlPrice) {
        this.toatlPrice = toatlPrice;
    }

    /**
     * 获取实付款
     *
     * @return real_pay - 实付款
     */
    public BigDecimal getRealPay() {
        return realPay;
    }

    /**
     * 设置实付款
     *
     * @param realPay 实付款
     */
    public void setRealPay(BigDecimal realPay) {
        this.realPay = realPay;
    }

    /**
     * 获取支付交易号
     *
     * @return trade_no - 支付交易号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置支付交易号
     *
     * @param tradeNo 支付交易号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    /**
     * 获取支付类型 1-支持宝 2-微信 3-扫码支付(支付宝) 4-扫码支付(微信) 5-网银转账 6-其他
     *
     * @return pay_type - 支付类型 1-支持宝 2-微信 3-扫码支付(支付宝) 4-扫码支付(微信) 5-网银转账 6-其他
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 设置支付类型 1-支持宝 2-微信 3-扫码支付(支付宝) 4-扫码支付(微信) 5-网银转账 6-其他
     *
     * @param payType 支付类型 1-支持宝 2-微信 3-扫码支付(支付宝) 4-扫码支付(微信) 5-网银转账 6-其他
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建时间
     *
     * @return created - 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置创建时间
     *
     * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取修改人
     *
     * @return modifier - 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置修改人
     *
     * @param modifier 修改人
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * 获取修改时间
     *
     * @return modified - 修改时间
     */
    public Date getModified() {
        return modified;
    }

    /**
     * 设置修改时间
     *
     * @param modified 修改时间
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * 获取sku编号
     *
     * @return sku_code - sku编号
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * 设置sku编号
     *
     * @param skuCode sku编号
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    /**
     * 获取0 展示 1不展示
     *
     * @return be_show - 0 展示 1不展示
     */
    public Integer getBeShow() {
        return beShow;
    }

    /**
     * 设置0 展示 1不展示
     *
     * @param beShow 0 展示 1不展示
     */
    public void setBeShow(Integer beShow) {
        this.beShow = beShow;
    }
}