package torna.web.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import torna.common.bean.Result;
import torna.common.enums.ModuleConfigTypeEnum;
import torna.common.util.CopyUtil;
import torna.dao.entity.Module;
import torna.dao.entity.ModuleConfig;
import torna.service.ModuleConfigService;
import torna.service.ModuleService;
import torna.web.controller.param.DebugHostParam;
import torna.web.controller.param.ModuleAllowMethodSetParam;
import torna.web.controller.param.ModuleConfigParam;
import torna.web.controller.vo.ModuleConfigVO;
import torna.web.controller.vo.ModuleSettingVO;
import torna.web.controller.vo.ModuleVO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tanghc
 */
@RestController
@RequestMapping("project/module/setting")
public class ProjectModuleSettingController {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private ModuleConfigService moduleConfigService;

    /**
     * 获取模块配置
     * @param moduleId 模块id
     * @return
     */
    @GetMapping("get")
    public Result<ModuleSettingVO> info(long moduleId) {
        Module module = moduleService.getById(moduleId);
        ModuleVO moduleVO = CopyUtil.copyBean(module, ModuleVO::new);
        List<ModuleConfig> globalHeaders = moduleConfigService.listGlobalHeaders(moduleId);
        String allowMethods = moduleConfigService.getAllowMethods(moduleId);
        List<String> methodList = Stream.of(allowMethods.split(",")).collect(Collectors.toList());
        String debugHost = moduleConfigService.getDebugHost(moduleId);
        ModuleSettingVO moduleSettingVO = new ModuleSettingVO();
        moduleSettingVO.setGlobalHeaders(CopyUtil.copyList(globalHeaders, ModuleConfigVO::new));
        moduleSettingVO.setAllowMethods(methodList);
        moduleSettingVO.setDebugHost(debugHost);
        moduleSettingVO.setModuleVO(moduleVO);
        return Result.ok(moduleSettingVO);
    }

    /**
     * 允许方法设置
     * @param param
     * @return
     */
    @PostMapping("/allowMethod/set")
    public Result allowMethod(@RequestBody ModuleAllowMethodSetParam param) {
        Long moduleId = param.getModuleId();
        ModuleConfig commonConfig = moduleConfigService.getCommonConfig(moduleId, ModuleConfigService.KEY_ALLOW_METHODS);
        List<String> list = param.getList();
        if (CollectionUtils.isEmpty(list)) {
            list = Collections.singletonList("GET");
        }
        String value = String.join(",", list);
        if (commonConfig == null) {
            commonConfig = new ModuleConfig();
            commonConfig.setModuleId(moduleId);
            commonConfig.setType(ModuleConfigTypeEnum.COMMON.getType());
            commonConfig.setConfigKey(ModuleConfigService.KEY_ALLOW_METHODS);
            commonConfig.setConfigValue(value);
            moduleConfigService.saveIgnoreNull(commonConfig);
        } else {
            commonConfig.setConfigValue(value);
            moduleConfigService.update(commonConfig);
        }
        return Result.ok();
    }

    /**
     * 设置调试host
     * @param param
     * @return
     */
    @PostMapping("/debughost/set")
    public Result debughost(@RequestBody DebugHostParam param) {
        Long moduleId = param.getModuleId();
        String key = ModuleConfigService.getDebugHostKey(moduleId);
        ModuleConfig commonConfig = moduleConfigService.getCommonConfig(moduleId, key);
        String value = param.getDebugHost();
        if (commonConfig == null) {
            commonConfig = new ModuleConfig();
            commonConfig.setModuleId(moduleId);
            commonConfig.setType(ModuleConfigTypeEnum.COMMON.getType());
            commonConfig.setConfigKey(key);
            commonConfig.setConfigValue(value);
            moduleConfigService.saveIgnoreNull(commonConfig);
        } else {
            commonConfig.setConfigValue(value);
            moduleConfigService.update(commonConfig);
        }
        return Result.ok();
    }

    @PostMapping("/globalHeader/add")
    public Result addHadder(@RequestBody ModuleConfigParam systemConfigParam) {
        ModuleConfig systemConfig = new ModuleConfig();
        BeanUtils.copyProperties(systemConfigParam, systemConfig);
        systemConfig.setModuleId(systemConfigParam.getModuleId());
        systemConfig.setType(ModuleConfigTypeEnum.GLOBAL_HEADERS.getType());
        moduleConfigService.saveIgnoreNull(systemConfig);
        return Result.ok();
    }

    @GetMapping("/globalHeader/list")
    public Result<List<ModuleConfigVO>> listHeader(long moduleId) {
        List<ModuleConfig> moduleConfigs = moduleConfigService.listGlobalHeaders(moduleId);
        List<ModuleConfigVO> moduleConfigVOS = CopyUtil.copyList(moduleConfigs, ModuleConfigVO::new);
        return Result.ok(moduleConfigVOS);
    }

    @PostMapping("/globalHeader/update")
    public Result updateHeader(@RequestBody ModuleConfig systemConfig) {
        moduleConfigService.updateIgnoreNull(systemConfig);
        return Result.ok();
    }

    @PostMapping("/globalHeader/delete")
    public Result deleteHeader(@RequestBody ModuleConfig systemConfig) {
        moduleConfigService.delete(systemConfig);
        return Result.ok();
    }

}
