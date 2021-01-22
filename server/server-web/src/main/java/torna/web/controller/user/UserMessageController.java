package torna.web.controller.user;

import com.gitee.fastmybatis.core.query.param.PageParam;
import com.gitee.fastmybatis.core.support.PageEasyui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import torna.common.bean.Result;
import torna.common.bean.User;
import torna.common.context.UserContext;
import torna.common.util.CopyUtil;
import torna.dao.entity.UserMessage;
import torna.service.UserMessageService;
import torna.web.controller.system.param.IdParam;
import torna.web.controller.user.vo.UserMessageVO;

import java.util.List;

/**
 * @author tanghc
 */
@RestController
@RequestMapping("user/message")
public class UserMessageController {

    @Autowired
    private UserMessageService userMessageService;

    /**
     * 查询未读信息
     */
    @GetMapping("unread")
    public Result<List<UserMessageVO>> unread() {
        User user = UserContext.getUser();
        List<UserMessage> userMessages = userMessageService.listUserUnReadMessage(user.getUserId());
        List<UserMessageVO> userMessageVOS = CopyUtil.copyList(userMessages, UserMessageVO::new);
        return Result.ok(userMessageVOS);
    }

    @PostMapping("page")
    public Result<PageEasyui<UserMessageVO>> page(@RequestBody PageParam param) {
        User user = UserContext.getUser();
        PageEasyui<UserMessage> pageEasyui = userMessageService.pageMessage(user.getUserId(), param);
        PageEasyui copyPage = CopyUtil.copyPage(pageEasyui, UserMessageVO::new);
        return Result.ok(copyPage);
    }

    @PostMapping("setRead")
    public Result setRead(@RequestBody IdParam param) {
        userMessageService.setRead(param.getId());
        return Result.ok();
    }

    @PostMapping("setReadAll")
    public Result setReadAll() {
        User user = UserContext.getUser();
        userMessageService.setReadAll(user.getUserId());
        return Result.ok();
    }


}