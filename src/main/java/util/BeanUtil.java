package util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by cong on 2018-03-24.
 */
public class BeanUtil {

    public static void copyProperties(Object des,Object src){
        try {
            BeanUtils.copyProperties(des,src);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
