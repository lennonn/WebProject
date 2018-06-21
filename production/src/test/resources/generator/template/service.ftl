package ${basePackage}.${sign}.service;
import ${basePackage}.${sign}.model.${modelNameUpperCamel};
import ${basePackage}.Service;
import java.util.List;
/**
 *
 * Created by ${author} on ${date}.
 */
public interface ${modelNameUpperCamel}Service<${modelNameUpperCamel}> extends Service<${modelNameUpperCamel}> {

    int deleteByPrimaryKey(Short id);

    int insert(${modelNameUpperCamel} ${modelNameUpperCamel?uncap_first});

    ${modelNameUpperCamel} selectByPrimaryKey(Short id);

    List<${modelNameUpperCamel}> selectAll();

    int updateByPrimaryKey(${modelNameUpperCamel} ${modelNameUpperCamel?uncap_first});
}
