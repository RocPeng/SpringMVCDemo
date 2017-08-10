import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * Created by roc_peng on 2017/8/10.
 * Email 18817353729@163.com
 * Url https://github.com/RocPeng/
 * Description 这个世界每天都有太多遗憾,所以你好,再见!
 */

public class test {
    @Test
    public void tets(){
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1,22);
        map.put(12,122);
        map.put(1,5);
        System.out.println(map);
    }
}
