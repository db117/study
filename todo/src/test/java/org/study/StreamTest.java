package org.study;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream表达式
 *
 * @author 大兵
 * @date 2018-07-12 23:32
 **/
public class StreamTest {
    private List<A> list;

    @Test
    public void mapTest() {
        init();

        //提出字段
        List<Integer> idList = list.stream().map(A::getId).collect(Collectors.toList());
        System.out.println(idList);

        //提取不重复字段
        List<Integer> ageList = list.stream().map(A::getAge).distinct().collect(Collectors.toList());
        System.out.println(ageList);

        //排序
        List<Integer> collect = ageList.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 初始化数据
     */
    public void init() {
        list = new ArrayList<>();
        for (int i = 0; i < 777; i++) {
            A a = new A();
            a.setAge((int) (Math.random() * 100));
            a.setId(i);
            a.setName("我叫" + i * (Math.random() * 100));
            list.add(a);
        }
    }

    static class A {
        private Integer id;
        private Integer age;
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
