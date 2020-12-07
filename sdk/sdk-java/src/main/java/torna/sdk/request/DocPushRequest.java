package torna.sdk.request;

import lombok.Getter;
import lombok.Setter;
import torna.sdk.param.DocItem;
import torna.sdk.response.DocPushResponse;

import java.util.List;

/**
 * 推送文档
 * 接口名	doc.push	版本号	1.0
 * @author tanghc
 */
@Setter
@Getter
public class DocPushRequest extends BaseRequest<DocPushResponse> {

    /** baseUrl */
    private String baseUrl;

    /** 接口项 */
    private List<DocItem> apis;

    public DocPushRequest(String token) {
        super(token);
    }

    @Override
    public String name() {
        return "doc.push";
    }
}