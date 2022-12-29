package com.longke.manager.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.longke.entity.DemoInfoEntity;
import com.longke.manager.DemoServiceManager;
import com.longke.mapper.DemoInfoMapper;
import org.springframework.stereotype.Service;

/**
 * demo信息表服务接口实现
 * @author Alex
 */
@Service
public class DemoServiceManagerImpl extends ServiceImpl<DemoInfoMapper, DemoInfoEntity> implements DemoServiceManager {
}
