package ${basePackage}.${modules}service.impl;

import ${basePackage}.${modules}mapper.${modelNameUpperCamel}Mapper;
import ${basePackage}.${modules}model.${modelNameUpperCamel};
import ${basePackage}.${modules}service.${modelNameUpperCamel}Service;
import com.zlennon.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by ${author} on ${date}.
 */
@Service
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service<${modelNameUpperCamel}> {

    @Autowired
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel?uncap_first}Mapper;

    public ${modelNameUpperCamel}Mapper get${modelNameUpperCamel}Mapper() {
        return ${modelNameLowerCamel?uncap_first}Mapper;
    }

    public void set${modelNameUpperCamel}Mapper(${modelNameUpperCamel}Mapper ${modelNameLowerCamel?uncap_first}Mapper) {
        this.${modelNameLowerCamel?uncap_first}Mapper = ${modelNameLowerCamel?uncap_first}Mapper;
    }

    public int deleteByPrimaryKey(Short id){
      return  ${modelNameLowerCamel}Mapper.deleteByPrimaryKey(id);
    }

    public int insert(${modelNameUpperCamel} ${modelNameUpperCamel?uncap_first}){
       return ${modelNameLowerCamel}Mapper.insert(${modelNameUpperCamel?uncap_first});
    }

    public ${modelNameUpperCamel} selectByPrimaryKey(Short id){
       return  ${modelNameLowerCamel}Mapper.selectByPrimaryKey(id);
    }

    public List<${modelNameUpperCamel}> selectAll(){
       return ${modelNameLowerCamel}Mapper.selectAll();
    }

    public int updateByPrimaryKey(${modelNameUpperCamel} ${modelNameUpperCamel?uncap_first}){
       return ${modelNameLowerCamel}Mapper.updateByPrimaryKey(${modelNameUpperCamel?uncap_first});
    }
}
