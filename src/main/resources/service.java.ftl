package ${package.Service};

import ${package.Entity}.${entity};
import com.bluelight.tsp.common.web.PageInfo;
/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} {

    /**
    * ${table.comment!}分页列表
    * @param param 根据需要进行传值
    * @return
    */
    PageInfo<${entity}> page(${entity} param);

    /**
    * ${table.comment!}新增
    * @param param 根据需要进行传值
    * @return
    */
    void add(${entity} param);

    /**
    * ${table.comment!}修改
    * @param param 根据需要进行传值
    * @return
    */
    void updateById(${entity} param);

    /**
    * ${table.comment!}删除(单个条目)
    * @param id
    * @return
    */
    void removeById(Long id);
}
</#if>
