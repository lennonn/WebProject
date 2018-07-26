package ${basePackage}.service;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.Service;
import java.util.List;
/**
 *
 * Created by ${author} on ${date}.
 */
public interface ${modelNameUpperCamel}Service<${modelNameUpperCamel}> extends Service<${modelNameUpperCamel}> {



<#list tableInfo as item>
    <#if item_index = 0>...</#if>
    <#if !item_has_next>...</#if>
    <#if item??></#if>
    ${item.colName!}---${item.remark!}
</#list>


}
