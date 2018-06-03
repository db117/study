package org.study;


import lombok.Data;

/**
 * 模板
 *
 * @author 大兵
 * @date 2018-05-03 13:33
 **/
@Data
public class Norm {
    /**
     * 指标名称
     */
    private String normName;
    /**
     * 指标类型
     */
    private String normType;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 可选择的(多个#隔开)
     */
    private String optional;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 字典标签
     */
    private String dictInfo;


    /**
     * 模型ID
     */
    private String modelId;
    /**
     * 指标ID
     */
    private String modelConfigId;

}
