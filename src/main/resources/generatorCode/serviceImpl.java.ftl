package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import com.hanxun.blog.utils.PageUtils;
import com.hanxun.blog.entity.base.PageInfo;
import com.hanxun.blog.enums.BackEnum;
import com.hanxun.blog.exception.CustomException;

import javax.annotation.Resource;
/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Slf4j
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} implements ${table.serviceName} {

    @Resource
    private ${table.mapperName} ${table.mapperName?uncap_first};
    /**
    * ${table.comment!}分页列表
    * @param param 根据需要进行传值
    * @return
    */
    @Override
    public PageInfo<${entity}> page(${entity} param) {

        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
        <#list table.fields as field>
         // ${field.comment}
         <#if !entityLombokModel>
          <#if field.propertyType == "Boolean">
           <#assign getprefix="is"/>
          <#else>
           <#assign getprefix="get"/>
          </#if>
          <#if field.propertyType == "String">
           .eq(!StringUtils.isEmpty(param.${getprefix}${field.capitalName}()), ${entity}::${getprefix}${field.capitalName}, param.${getprefix}${field.capitalName}())
          <#else>
           .eq(param.${getprefix}${field.capitalName}() != null, ${entity}::${getprefix}${field.capitalName}, param.${getprefix}${field.capitalName}())
          </#if>
         <#else>
          <#if field.propertyType == "String">
           .eq(!StringUtils.isEmpty(param.get${field.capitalName}()), ${entity}::get${field.capitalName}, param.get${field.capitalName}())
          <#else>
           .eq(param.get${field.capitalName}() != null, ${entity}::get${field.capitalName}, param.get${field.capitalName}())
          </#if>
         </#if>
        </#list>;

        Page<${entity}> page = new Page<>(param.getPageNum(),param.getPageSize());
        IPage<${entity}> ipage = ${table.mapperName?uncap_first}.page(page, queryWrapper);

        PageInfo pageInfo = PageUtils.getPage(ipage);
        return pageInfo;
    }

    /**
    * ${table.comment!}新增
    * @param param 根据需要进行传值
    * @return
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(${entity} param) {

        if (!${table.mapperName?uncap_first}.save(param)) {
            throw new CustomException(BackEnum.INSERT_FAILED);
        }
    }

    /**
    * ${table.comment!}修改
    * @param param 根据需要进行传值
    * @return
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(${entity} param) {
        if (!${table.mapperName?uncap_first}.updateById(param)) {
            throw new CustomException(BackEnum.UPDATE_FAILED);
        }
    }

    /**
    * ${table.comment!}删除(单个条目)
    * @param id
    * @return
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeById(Long id) {
        if(!${table.mapperName?uncap_first}.removeById(id)){
            throw new CustomException(BackEnum.DELETE_FAILED);
        }
    }
}
</#if>
