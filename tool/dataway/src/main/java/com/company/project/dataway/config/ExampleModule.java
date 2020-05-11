package com.company.project.dataway.config;

import com.company.project.base.common.entity.Result;
import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.dataway.spi.ApiInfo;
import net.hasor.dataway.spi.ResultProcessChainSpi;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Map;

@DimModule
@Component
public class ExampleModule implements SpringModule {
    @Autowired
    private DataSource dataSource;

    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        // .DataSource form Spring boot into Hasor
        apiBinder.installModule(new JdbcModule(Level.Full, this.dataSource));
        apiBinder.bindSpiListener(ResultProcessChainSpi.class, new ResultProcessChainSpi() {
            @Override
            public Object callAfter(boolean formPre, ApiInfo apiInfo, Object result) {
                Map<String, Object> optionMap = apiInfo.getOptionMap();
                optionMap.put("resultStructure", false);
                apiInfo.setOptionMap(optionMap);
                return Result.ok(result);
            }
        });
    }
}