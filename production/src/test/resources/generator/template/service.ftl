package ${basePackage}.${sign}.service;
import ${basePackage}.${sign}.model.${modelNameUpperCamel};
import ${basePackage}.Service;
import java.util.List;
/**
 *
 * Created by ${author} on ${date}.
 */
public interface ${modelNameUpperCamel}Service extends Service<${modelNameUpperCamel}> {
   List<${modelNameUpperCamel}> findAll();
}
