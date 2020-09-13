package com.bootcamptech.stream;


import com.sun.tools.classfile.Synthetic_attribute;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExamples {

    /*
     Takes two arrays, of numbers and create a pair where the sum is divsible by 3
     Approcah 1
     */

    public void approach1() {

    List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    List<Integer> numbers2 = Arrays.asList(3, 4);

    //Approach 1

    List<int[]> pairs =
            numbers1.stream().
                    flatMap(i ->
                         numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> {
                             System.out.println(i);
                             return new int[]{i, j};
                         }))
                    .limit(1)
                    .collect(Collectors.toList());

   pairs.stream().forEach(p-> System.out.println(p[0] + ":" + p[1]));
}

    public void approach2()
    {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        //Approach 1

        List<int[]> pairs =
                numbers1.stream().
                        flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                        .filter(i -> (i[0] + i[1])%3 == 0).collect(Collectors.toList());

        pairs.stream().forEach(p-> System.out.println(p[0] + ":" + p[1]));
    }


    public static void main(String[] args) {
        FlatMapExamples examples = new FlatMapExamples();
        examples.approach1();
        examples.approach2();
    }
}
