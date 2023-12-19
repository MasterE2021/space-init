package com.master.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 批量处理工具类
 *
 * @author yiqunjie
 * @description
 * @date 2023-12-18 14:31
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class BatchUtils {

    public static final long BATCH_SIZE = 2000;


    /**
     * 批量处理的工具类(有返回值)
     *
     * @param list     入参集
     * @param function 批量调用的方法
     *
     * @return 返回的结果
     */
    public static List callBatch(List list, Function<List, List> function) {
        List result = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return result;
        }
        if (list.size() > BATCH_SIZE) {
            long batchNum = list.size() / BATCH_SIZE;
            for (int i = 0; i < batchNum + 1; i++) {
                List batch = batch(list, i);
                if (batch == null || batch.size() == 0) {
                    continue;
                }
                List apply = function.apply(batch);
                if (apply != null && apply.size() != 0) {
                    result.addAll(apply);
                }
            }
        } else {
            return function.apply(list);
        }
        return result;
    }


    /**
     * 批量处理方法(无返回值, 两个入参, 可用于批量更新等逻辑)
     *
     * @param list       第一个参数
     * @param t          第二个参数, 单个对象或基本数据类型等
     * @param biFunction 调用的方法
     * @param <T>        第二个参数的泛型
     *
     * @return 返回结果
     */
    public static <T> List callMultiParamBatch(List list, T t, BiFunction<List, T, List> biFunction) {
        List result = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return result;
        }
        if (list.size() > BATCH_SIZE) {
            long batchNum = list.size() / BATCH_SIZE;
            for (int i = 0; i < batchNum + 1; i++) {
                List batch = batch(list, i);
                if (batch == null || batch.size() == 0) {
                    continue;
                }
                List apply = biFunction.apply(batch, t);
                if (apply != null && apply.size() != 0) {
                    result.addAll(apply);
                }
            }
        } else {
            return biFunction.apply(list, t);
        }
        return result;
    }

    /**
     * 批量处理的工具类(无返回值)
     *
     * @param list     入参集合
     * @param consumer 批量调用的方法
     */
    public static <T> void runBatch(List list, Consumer<List> consumer) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (list.size() > BATCH_SIZE) {
            long batchNum = list.size() / BATCH_SIZE;
            for (int i = 0; i < batchNum + 1; i++) {
                List batch = batch(list, i);
                if (batch == null || batch.size() == 0) {
                    continue;
                }
                consumer.accept(batch);
            }
        } else {
            consumer.accept(list);
        }
    }


    /**
     * 批量处理方法(无返回值)
     *
     * @param list       第一个参数
     * @param t          第二个参数单个对象或基本数据类型等
     * @param biConsumer 调用的方法
     * @param <T>        第二个参数的泛型
     */
    public static <T> void runMultiParamBatch(List list, T t, BiConsumer<List, T> biConsumer) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (list.size() > BATCH_SIZE) {
            long batchNum = list.size() / BATCH_SIZE;
            for (int i = 0; i < batchNum + 1; i++) {
                List batch = batch(list, i);
                if (batch == null || batch.size() == 0) {
                    continue;
                }
                biConsumer.accept(batch, t);
            }
        } else {
            biConsumer.accept(list, t);
        }
    }

    /**
     * 用于获取子批次集合的方法
     *
     * @param list 源集合
     * @param num  第几批
     *
     * @return 子批集合
     */
    private static List batch(List list, int num) {
        return (List) list.stream().skip(num * BATCH_SIZE).limit(BATCH_SIZE).collect(Collectors.toList());
    }
}
