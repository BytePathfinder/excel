package com.xubiao;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 *  工程：ConsumerOrderSheet
 *  包名：com.xubiao
 * </pre>
 *
 * @author 徐彪 1534089606@qq.com
 * @version 1.0.0
 * @apiNote 将excel记录映射成JavaBean
 * @since 2023/6/21 8:48
 */
@Data
public class UserOrderTable {
    @ExcelProperty(value = "订单号", index = 0)
    private String orderId;

    @ExcelProperty(value = "用户名", index = 1)
    private String username;

    @ExcelProperty(value = "密码", index = 2)
    private String password;

    @ExcelProperty(value = "商品名", index = 3)
    private String productName;

    @ExcelProperty(value = "数量", index = 4)
    private BigDecimal quantity;

    @ExcelProperty(value = "价格", index = 5)
    private BigDecimal price;

    @ExcelProperty(value = "日期", index = 6)
    @DateTimeFormat(value = "yyyy年MM月dd日")
    private Date date;

}
