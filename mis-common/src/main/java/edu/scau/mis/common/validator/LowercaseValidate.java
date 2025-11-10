package edu.scau.mis.common.validator;

import edu.scau.mis.common.annotation.Lowercase;
import edu.scau.mis.common.exception.LowercaseException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
public class LowercaseValidate {

    public static void validate(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Lowercase.class)) {
           validateFields(clazz);
           validateMethods(clazz);
        }
    }

        private static void validateFields(Class<?> clazz) {
            for (Field field : clazz.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                // 跳过常量和静态属性
                if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
                    continue;
                }
                String name = field.getName();
                // 检查首字母是否为小写
                if (!name.isEmpty() && Character.isUpperCase(name.charAt(0))) {
                    throw new LowercaseException(
                            String.format("属性 '%s' 在类 %s 中必须以小写字母开头", name, clazz.getName())
                    );
                }
            }
        }

        private static void validateMethods(Class<?> clazz) {
            for (Method method : clazz.getDeclaredMethods()) {
                String name = method.getName();
                // 跳过构造方法
                if (name.equals(clazz.getSimpleName())) continue;
                // 检查首字母是否为小写
                if (!name.isEmpty() && Character.isUpperCase(name.charAt(0))) {
                    throw new LowercaseException(
                            String.format("方法 '%s' 在类 %s 中必须以小写字母开头", name, clazz.getName())
                    );
                }
            }
        }
}
