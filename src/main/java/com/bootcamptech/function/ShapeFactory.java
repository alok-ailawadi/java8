package com.bootcamptech.function;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 *  Implementing the factory pattern using the Supplier functional interface
 * @Author: Alok Kumar Ailawadi
 */
public class ShapeFactory {
    private static Map<String , Supplier<? extends Shape>> shapes = new HashMap<>();
    static {
        shapes.put("CIRCLE", Circle::new);
        shapes.put("SQUARE", Square::new);
        shapes.put("UNKNOWN", UnkownShape::new);
    }

    /**
     *
     * @param shapeType
     * @param supplier
     */
    public static void registerSupplier(String shapeType, Supplier<? extends Shape> supplier){
        shapes.put(shapeType, supplier);
    }

    /**
     *  Factory get method using supplier instead of traditional if then else construct used earlier
     */
    public static Shape getShape(String shapeType){

         Optional<Supplier<? extends Shape>> opt = Optional.ofNullable(shapes.get(shapeType));
         if(opt.isPresent()){
             return opt.get().get();
         }
         return shapes.get("UNKNOWN").get();
    }

    public static void main(String[] args) {

        System.out.println(ShapeFactory.getShape("CIRCLE").getDescription());
        System.out.println(ShapeFactory.getShape("RECTANGLE").getDescription());

    }
}

interface Shape{

    default String getDescription(){
        return "This is an unknown shape";
    }
}

class Circle implements Shape{

    @Override
    public String getDescription(){
        return  "This is circle";
    }
}

class Square implements Shape {

    @Override
    public String getDescription() {
        return "This is square";
    }
}

class UnkownShape implements Shape {


}