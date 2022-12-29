package com.longke.service.impl.simple;

import com.longke.entity.DemoInfoEntity;
import com.longke.manager.DemoServiceManager;
import com.longke.service.api.simple.SimpleService;
import com.longke.service.data.simple.input.DemoInput;
import com.longke.service.data.simple.output.DemoOutput;
import com.longke.service.impl.base.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 */
@Slf4j
@RefreshScope
@RestController
public class SimpleServiceImpl extends BaseServiceImpl implements SimpleService {

    @Autowired
    private DemoServiceManager demoServiceManager;

    @Override
    public List<DemoOutput> list() {
        List<DemoOutput> list = new ArrayList<>();

        List<DemoInfoEntity> dataList = demoServiceManager.list();

        if (!CollectionUtils.isEmpty(dataList)) {
            dataList.forEach(data -> {
                DemoOutput item = new DemoOutput();
                BeanUtils.copyProperties(data, item);
                item.setName(data.getUsername());
                list.add(item);
            });
        }

        return list;
    }

    @Override
    public DemoOutput get(Long id) {
        DemoInfoEntity data = demoServiceManager.getById(id);
        if (data != null) {
            DemoOutput result = new DemoOutput();
            BeanUtils.copyProperties(data, result);
            result.setName(data.getUsername());
            return result;
        }
        return null;
    }

    @Override
    public Long count() {
        return demoServiceManager.count();
    }

    @Override
    public Boolean add(DemoInput demoInput) {
        DemoInfoEntity save = new DemoInfoEntity();
        BeanUtils.copyProperties(demoInput, save);
        save.setUsername(demoInput.getName());
        save.setPassword("123456");
        demoServiceManager.save(save);
        return true;
    }

    @Override
    public Boolean update(DemoInput demoInput) {
        DemoInfoEntity save = new DemoInfoEntity();
        BeanUtils.copyProperties(demoInput, save);
        save.setUsername(demoInput.getName());
        save.setPassword("123456");
        demoServiceManager.updateById(save);
        return true;
    }

    @Override
    public Boolean del(Long id) {
        demoServiceManager.removeById(id);
        return true;
    }
}
