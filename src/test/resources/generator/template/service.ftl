package ${basePackage}.service;
import com.zlennon.Service;
import java.util.List;
/**
 *
 * Created by ${author} on ${date}.
 */
public interface ${modelNameUpperCamel}Service<${modelNameUpperCamel}> extends Service<${modelNameUpperCamel}> {

    int deleteByPrimaryKey(String id);

    int insert(${modelNameUpperCamel} ${modelNameUpperCamel?uncap_first});

    ${modelNameUpperCamel} selectByPrimaryKey(String id);

    List<${modelNameUpperCamel}> selectAll();

    int updateByPrimaryKey(${modelNameUpperCamel} ${modelNameUpperCamel?uncap_first});
}
