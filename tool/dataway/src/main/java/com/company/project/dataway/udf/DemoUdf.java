package com.company.project.dataway.udf;

import com.company.project.dataway.bean.User;
import net.hasor.dataql.Hints;
import net.hasor.dataql.Udf;

/**
 * @author laoliangliang
 * @since 2020-05-10 14:54
 */
public class DemoUdf implements Udf {
    @Override
    public Object call(Hints hints, Object... objects) throws Throwable {
        String[] hints1 = hints.getHints();
        return new User();
    }

}
