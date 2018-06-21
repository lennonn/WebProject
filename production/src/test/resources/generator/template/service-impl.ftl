package ${basePackage}.${sign}.service.impl;

import ${basePackage}.${sign}.mapper.${modelNameUpperCamel}Mapper;
import ${basePackage}.${sign}.model.${modelNameUpperCamel};
import ${basePackage}.${sign}.service.${modelNameUpperCamel}Service;
import ${basePackage}.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by ${author} on ${date}.
 */
@Service
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {

    @Autowired
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

    List<${modelNameUpperCamel}> findAll(){
      return   ${modelNameLowerCamel}Mapper.findAll();
    }
}
