package com.amrni.sport.shop.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class Stream2Utils {

    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";


    public static <S, T, K> void convert(List<S> source,
                                         List<T> target,
                                         Function<S, K> sourceKeyFunction,
                                         Function<T, K> targetKeyFunction,
                                         BiConsumer<T, S> consumer) {
        Map<K, S> map = source.stream().collect(Collectors.toMap(sourceKeyFunction, Function.identity()));
        convertByMap(target, targetKeyFunction, map, consumer);
    }

    public static <T, K, S> void convertByMap(List<T> target,
                                              Function<T, K> keyFunction,
                                              Map<K, S> map,
                                              BiConsumer<T, S> consumer) {
        target.forEach(t -> consumer.accept(t, map.get(keyFunction.apply(t))));
    }

    public static <T, R> Set<R> set(Collection<T> list, Function<T, R> function) {
        if (list == null) {
            return Sets.newHashSet();
        }
        return list.stream().map(function).collect(Collectors.toSet());
    }

    public static <T, R> List<R> map(Collection<T> list, Function<T, R> function) {
        if (list == null) {
            return Lists.newArrayList();
        }
        return list.stream().map(function).collect(Collectors.toList());
    }

    public static String listToString(Collection<String> list) {
        if (list == null) {
            return "";
        }
        return list.stream().collect(Collectors.joining(COMMA));
    }

    public static String listToString(Collection<String> list, String joinString) {
        if (list == null) {
            return "";
        }
        return list.stream().collect(Collectors.joining(joinString));
    }

    public static <T> String listToString(Collection<T> list, Function<T, String> function, String joinString) {
        if (list == null) {
            return "";
        }
        return list.stream().map(function).collect(Collectors.joining(joinString));
    }

    public static <T> String listToString(Collection<T> list, Function<T, String> function) {
        if (list == null) {
            return "";
        }
        return list.stream().map(function).collect(Collectors.joining(COMMA));
    }

    public static <T> String listToStringNewLine(Collection<T> list, Function<T, String> function) {
        if (list == null) {
            return "";
        }
        return list.stream().map(function).collect(Collectors.joining(NEW_LINE));
    }

    public static <T, R> Map<R, T> toMap(Collection<T> list, Function<T, R> function) {
        if (list == null) {
            return Maps.newHashMap();
        }
        return list.stream().collect(Collectors.toMap(function, Function.identity()));
    }

    public static <T, R> Map<R, T> toMapIgnoreDuplicate(Collection<T> list, Function<T, R> function) {
        if (list == null) {
            return Maps.newHashMap();
        }
        return list.stream().collect(Collectors.toMap(function, Function.identity(), (o, n) -> o));
    }

    public static <T, R, V> Map<R, V> toMapIgnoreDuplicate(Collection<T> list, Function<T, R> keyFunction, Function<T, V> valueFunction) {
        if (list == null) {
            return Maps.newHashMap();
        }
        return list.stream().collect(Collectors.toMap(keyFunction, valueFunction, (o, n) -> o));
    }
    public static <T> Collection<T> filterNull(Collection<T> list) {
        if (list == null) {
            return Lists.newArrayList();
        }
        return list.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static <T> List<T> filter(Collection<T> list, Predicate<T> predicate) {
        if (list == null) {
            return Lists.newArrayList();
        }
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    public static <T, R> List<R> filter(Collection<T> list, Predicate<T> predicate, Function<T, R> function) {
        if (list == null) {
            return Lists.newArrayList();
        }
        return list.stream().filter(predicate).map(function).collect(Collectors.toList());
    }

    public static <T> Set<T> filterToSet(Collection<T> list, Predicate<T> predicate) {
        if (list == null) {
            return Sets.newHashSet();
        }
        return list.stream().filter(predicate).collect(Collectors.toSet());
    }

    public static <T> Integer maxSize(Collection<List<T>> listList) {
        if (CollectionUtils.isEmpty(listList)) {
            return 0;
        }
        return listList.stream().mapToInt(List::size).max().getAsInt();
    }

    public static <T> List<T> reverseFilter(Collection<T> list, Predicate<T> predicate) {
        if (list == null) {
            return Lists.newArrayList();
        }
        return list.stream().filter(t -> !predicate.test(t)).collect(Collectors.toList());
    }

    public static <T, R, V> Map<R, V> toMap(Collection<T> list, Function<T, R> keyFunction, Function<T, V> valueFunction) {
        if (list == null) {
            return Maps.newHashMap();
        }
        return list.stream().collect(Collectors.toMap(keyFunction, valueFunction));
    }

    public static <T> List<T> toList(Collection<List<T>> listList) {
        return listList.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
    }

    public static <T> Set<T> toSet(Collection<Set<T>> setList) {
        return setList.stream().collect(HashSet::new, HashSet::addAll, HashSet::addAll);
    }

    public static <T> Set<T> ListListToSet(Collection<List<T>> listList) {
        return listList.stream().collect(HashSet::new, HashSet::addAll, HashSet::addAll);
    }

    public static <T> Set<T> setToList(Collection<Set<T>> setList) {
        return setList.stream().collect(HashSet::new, HashSet::addAll, HashSet::addAll);
    }

    public static <T, K> List<T> removeDuplicates(List<T> list, Function<T, K> function) {
        return list.stream()
                .collect(Collectors.toMap(function, Function.identity(), (existing, replacement) -> existing))
                .values().stream()
                .collect(Collectors.toList());
    }

    /**
     * 合并集合并返回新的列表。
     * allList 通过 keyFunction 变成 map<R, List<T>> 再取 value 获得 List<List>
     * List<List> foreach 通过 mergeFunction 变成 List
     */
    public static <T, R> List<T> merge(Collection<T> allList,
                                       Function<T, R> keyFunction,
                                       Function<List<T>, T> mergeFunction) {
        Map<R, List<T>> groupMap = groupBy(allList, keyFunction);
        return groupMap.values().stream()
                .map(mergeFunction::apply)
                .collect(Collectors.toList());
    }

    public static <T, R> Map<R, List<T>> groupBy(Collection<T> list,
                                                 Function<T, R> function) {
        return list.stream().collect(Collectors.groupingBy(function));
    }

    public static <T, R, V> Map<R, List<V>> groupBy(Collection<T> list,
                                                    Function<T, R> keyFunction,
                                                    Function<T, V> valueFunction) {
        return list.stream().collect(Collectors.groupingBy(keyFunction,
                HashMap::new,
                Collectors.mapping(valueFunction, Collectors.toList())
        ));
    }

    public static BigDecimal reduceBigDecimal(Collection<BigDecimal> list) {
        return reduce(list, BigDecimal::add, () -> BigDecimal.ZERO);
    }

    public static <R> BigDecimal reduceBigDecimal(Collection<R> list,
                                                  Function<R, BigDecimal> keyFunction) {
        return reduce(map(list, keyFunction), BigDecimal::add, () -> BigDecimal.ZERO);
    }

    public static <T> T reduce(Collection<T> list,
                               BinaryOperator<T> accumulator) {
        return list.stream().reduce(accumulator).get();
    }

    public static <T> T reduce(Collection<T> list,
                               BinaryOperator<T> accumulator,
                               Supplier<T> supplier) {
        return list.stream().reduce(accumulator).orElseGet(supplier);
    }

    public static <R, T> T reduce(Collection<R> list,
                                  Function<R, T> keyFunction,
                                  BinaryOperator<T> accumulator,
                                  Supplier<T> supplier) {
        return reduce(map(list, keyFunction), accumulator, supplier);
    }

    // first -> group map<k, list>
    // second -> sum value map<l, value>
    public static <T, R> Map<R, Integer> groupBySumInt(Collection<T> list,
                                                       Function<T, R> keyFunction,
                                                       Function<T, Integer> valueFunction) {
        return list.stream().collect(Collectors.groupingBy(keyFunction,
                Collectors.summingInt(item -> valueFunction.apply(item))));
    }

    public static <T, R> Map<R, BigDecimal> groupBySumBigDecimal(Collection<T> list,
                                                                 Function<T, R> keyFunction,
                                                                 Function<T, BigDecimal> valueFunction) {
        return list.stream().collect(Collectors.groupingBy(keyFunction,
                Collectors.reducing(BigDecimal.ZERO, valueFunction, BigDecimal::add)));
    }

    public static <T> List<T> sorted(Collection<T> list,
                                     Comparator<T> comparator) {
        return list.stream().sorted(comparator).collect(Collectors.toList());
    }

    public static <T, R extends Comparable<? super R>> List<T> sorted(Collection<T> list,
                                                                      Function<T, R> keyExtractor) {
        return list.stream()
                .sorted(Comparator.comparing(keyExtractor))
                .collect(Collectors.toList());
    }


    public static <T> List<T> newList(Collection<T>... lists) {
        List<T> all = Lists.newArrayList();
        for (Collection<T> list : lists) {
            all.addAll(list);
        }
        return all;
    }
}
