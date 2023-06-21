package com.xubiao;

import com.xubiao.awesome.ExcelAnalysisHelper;
import com.xubiao.awesome.UploadDataListener;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * 额外信息（批注、超链接、合并单元格信息读取）
 * <p>
 * 由于是流式读取，没法在读取到单元格数据的时候直接读取到额外信息，所以只能最后通知哪些单元格有哪些额外信息
 *
 * <p>
 * 1. 创建excel对应的实体对象 参照{@link UserOrderTable}
 * <p>
 * 2. 由于默认异步读取excel，所以需要创建excel一行一行的回调监听器，参照{@link UploadDataListener}
 * <p>
 * 3. 直接读即可
 *
 * @since 2.2.0-beat1
 */

public class App {
    public static void main(String[] args) throws URISyntaxException {
        URI uri = Objects.requireNonNull(App.class.getResource("/用户订单表.xlsx")).toURI();
        File file = new File(uri);
        ExcelAnalysisHelper<UserOrderTable> helper = new ExcelAnalysisHelper<>();
        List<UserOrderTable> tableList = helper.getList(file, UserOrderTable.class);
        // 封装成订单
        Map<String,List<Object>> orderMap = new HashMap<>();
        tableList.stream().peek(System.out::println).forEach(record ->{
            // 如果没有，就创建并添加
            if (!orderMap.containsKey(record.getOrderId())){
                ArrayList<Object> value = new ArrayList<>();
                value.add(record);
                orderMap.put(record.getOrderId(), value);
            }else{
                orderMap.get(record.getOrderId()).add(record);
            }
        });
        System.out.println("=============================");
        orderMap.forEach((key, value) -> {
            System.out.println("key = " + key + ", value = " + value);
        });
    }

}
