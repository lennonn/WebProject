package ${basePackage}.${modules}service;
import ${basePackage}.model.${modules}${modelNameUpperCamel};
import com.zlennon.Service;
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
