package torna.api.open.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.gitee.easyopen.doc.DataType;
import com.gitee.easyopen.doc.annotation.ApiDocField;
import lombok.Data;
import torna.common.support.IdCodec;

import java.util.Date;
import java.util.List;

/**
 * @author tanghc
 */
@Data
public class DocInfoDetailResult {
    @ApiDocField(description = "文档id", example = "je24ozLJ", required = true)
    @JSONField(serializeUsing = IdCodec.class, deserializeUsing = IdCodec.class)
    private Long id;

    /** 文档名称 name */
    @ApiDocField(description = "文档名称", required = true, example = "获取商品信息")
    private String name;

    /** 文档概述 description */
    @ApiDocField(description = "文档概述", example = "获取商品信息")
    private String description;

    /** 访问URL url */
    @ApiDocField(description = "url", example = "/goods/get")
    private String url;

    /** http方法 http_method */
    @ApiDocField(description = "http方法", example = "GET")
    private String httpMethod;

    /** contentType content_type */
    @ApiDocField(description = "contentType", example = "application/json")
    private String contentType;

    /** 是否是分类，0：不是，1：是 is_folder */
    @ApiDocField(description = "是否是分类，0：不是，1：是", example = "1")
    private Byte isFolder;

    /** 父节点 parent_id */
    @JSONField(serializeUsing = IdCodec.class, deserializeUsing = IdCodec.class)
    @ApiDocField(description = "父节点, 没有填空字符串", dataType = DataType.STRING, example = "")
    private Long parentId;

    /** 是否显示 is_show */
    @ApiDocField(description = "是否显示，1：显示，0：不显示", example = "1")
    private Byte isShow;

    /**  数据库字段：gmt_create */
    @ApiDocField(description = "创建时间")
    private Date gmtCreate;

    /**  数据库字段：gmt_modified */
    @ApiDocField(description = "最后修改时间")
    private Date gmtModified;

    @ApiDocField(description = "请求头", elementClass = DocHeaderResult.class)
    private List<DocHeaderResult> headerParams;

    @ApiDocField(description = "请求参数", elementClass = DocParamResult.class)
    private List<DocParamResult> requestParams;

    @ApiDocField(description = "返回参数", elementClass = DocParamResult.class)
    private List<DocParamResult> responseParams;

    @ApiDocField(description = "错误码", elementClass = DocCodeResult.class)
    private List<DocCodeResult> errorCodeParams;
}