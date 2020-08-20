package 注解;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 用注解可以标记方法，使方法有了特殊的含义，比如这个方法是处理协议的，那个方法是处理gm工具命令的，什么什么的
 * des: 静态方法在invoke的时候，参数可以是null, 写this也可以。
 * 但是如果不是静态方法就要是调用他的对象，比如本例中的this.
 * created by miapoeng on 2020/4/11 15:28
 */
public class AnnotationTest {

    public AnnotationTest () {

    }

    private Map<Integer, Method> methodHashMap = new HashMap<>();

    /**
     * 根据协议号，调用相关的方法
     * @param code
     */
    public void invokeMethodByCode(int code) {
        if (methodHashMap.containsKey(code)) {
            try {
                Method method = methodHashMap.get(code);
                method.invoke(this, code);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void invokeMethod1 () {
        Method[] methods = AnnotationTest.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals("method1")) {
                try {
                    method.invoke(null, 123);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * 组织注解
     */
    public void orgAnnotationData () {
        Method[] methods = AnnotationTest.class.getDeclaredMethods();
        for (Method method : methods) {
            OP op = method.getAnnotation(OP.class);
            if (op != null) {
                methodHashMap.put(op.code(), method);
            }
        }
    }

    /**
     * 打印所有有注解的方法
     */
    public void printAllAnnotationMethod () {
        for (Map.Entry<Integer, Method> entity : methodHashMap.entrySet()) {
            System.out.println(entity.getValue().getName());
        }
    }

    @OP(code = 1024, des = "1024号协议")
    private static void method1 (int code) {
        System.out.println("method1" + code);
    }

    @OP(code = 1025, des = "1025号协议")
    public void method2 (int code) {
        System.out.println("method1" + code);
    }

    @OP(code = 1026, des = "1026号协议")
    public void method3 (int code) {
        System.out.println("method1" + code);
    }

    @OP(code = 1027, des = "1027号协议")
    public void method4 (int code) {
        System.out.println("method1" + code);
    }

    public void method5 (int code) {
        System.out.println("method1" + code);
    }

    public static void main(String[] args) {
        AnnotationTest annotationTest = new AnnotationTest();
        annotationTest.orgAnnotationData();
        annotationTest.printAllAnnotationMethod();
        annotationTest.invokeMethodByCode(1024);
//        annotationTest.invokeMethod1();
    }
}
