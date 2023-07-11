package com.example.demo;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/generator")
public class GeneratorRest {


    final static String  basePackage = "com.example.demo";


    @PostMapping("/")
    public JsonNode generate(@RequestBody JsonNode jsonNode) throws IOException {
        String packageName = "com.example.demo";

        for (JsonNode entityNode : jsonNode) {
            String entityName = entityNode.get("nameEntity").asText();
            List<String> attributes = new ArrayList<>();
            List<String> attributesDto = new ArrayList<>();
            List<String> attributesGenerateFindDaoEtFacade = new ArrayList<>();
            List<String> attributesGenerateFindImpl = new ArrayList<>();
            List<String> attributesGenerateFindController = new ArrayList<>();
            JsonNode attributesNode = entityNode.get("attributes");
            for (JsonNode attributeNode : attributesNode) {
                String attributeName = attributeNode.get("nameAttribute").asText();
                String attributeType =  attributeNode.get("type").asText();
                boolean isRelational = attributeNode.get("isRelational").asBoolean();
                boolean generateFind = attributeNode.get("generateFind").asBoolean();

                if (generateFind){
                    String findmethod = "    public " + entityName  + " find" + entityName +
                            "By" + attributeName.substring(0,1).toUpperCase() + attributeName.substring(1) + "(" + attributeType + " " + attributeName + ");\n";
                    attributesGenerateFindDaoEtFacade.add(findmethod);

                    String findmethodImpl = "    @Override \n" + "    public " + entityName  + " find" + entityName +
                            "By" + attributeName.substring(0,1).toUpperCase() + attributeName.substring(1).toLowerCase() + "(" + attributeType + " " + attributeName + ")"
                            + "{\n"+ "      return  " + entityName.toLowerCase() + "Dao." + "find" + entityName + "By" + attributeName.substring(0,1).toUpperCase() + attributeName.substring(1).toLowerCase() +
                            "("+ attributeName + " );\n}\n";

                    attributesGenerateFindImpl.add(findmethodImpl);

                    String findmethodController = "    @GetMapping(\"/" +attributeName+"/{" + attributeName + "}\")\n"
                            + "    public " + entityName  + " find" + entityName +
                            "By" + attributeName + "(@PathVariable " + attributeType + " " + attributeName + ")"
                            + "{\n"+ "     return  " + entityName.toLowerCase() + "Service." + "find" + entityName + "By" + attributeName.substring(0,1).toUpperCase() + attributeName.substring(1).toLowerCase() +
                            "( "  + attributeName + " );\n}\n";

                    attributesGenerateFindController.add(findmethodController);

                }
                if (isRelational){
                    attributeType = attributeNode.get("relation").asText() + " \n private " + " " + attributeType;
                }else {
                    attributeType = "private " + attributeType;
                }
                String attributeDeclaration =  attributeType + " " + attributeName + ";\n\n";
                attributes.add(attributeDeclaration);
            }
            for (JsonNode attributeNode : attributesNode) {
                String attributeName = attributeNode.get("nameAttribute").asText();
                boolean isRelational = attributeNode.get("isRelational").asBoolean();
                String attributeType = attributeNode.get("type").asText();

                if (isRelational){
                    if (attributeType.contains("List")){
                        attributeType = attributeType.substring(0,attributeType.length()-1) + "Dto" + ">";
                        attributeName = attributeName + "ListDto";
                    }
                    else{
                        attributeType = attributeType + "Dto";
                        attributeName = attributeName + "Dto";
                    }
                }

                String attributeDeclaration = "private " + attributeType + " " + attributeName + ";\n\n";
                attributesDto.add(attributeDeclaration);
            }

            generateEntityClass(packageName, entityName, attributes);
            generateDtoClass(packageName, entityName, attributesDto);
            generateDaoInterface(packageName + ".dao", entityName, attributesGenerateFindDaoEtFacade);
            generateServiceFacadeInterface(packageName + ".service.facade", entityName,attributesGenerateFindDaoEtFacade);
            generateServiceImplementationClass(packageName + ".service.implementation", entityName,attributesGenerateFindImpl);
            generateControllerClass(packageName + ".controller", packageName + ".service.facade", entityName,attributesGenerateFindController);
        }
        return jsonNode;
    }

    public  void generateEntityClass(String packageName, String entityName, List<String> attributes) throws IOException {
        String attributeDeclarations = String.join("\n    ", attributes);
        String entityClassContent = "package " + packageName + ".entities;\n\n" +
                "import javax.persistence.*;\n" +
                "import java.util.List;\n\n" +
                "import java.time.LocalDate;\n" +
                "import java.time.LocalDateTime;\n" +
                "import java.util.Date;\n" +
                "import lombok.AllArgsConstructor;\n" +
                "import lombok.Data;\n" +
                "import lombok.NoArgsConstructor;\n\n" +
                "@Entity\n" +
                "@Data\n" +
                "@AllArgsConstructor\n" +
                "@NoArgsConstructor\n" +
                "public class " + entityName + " {\n" +
                "    @Id\n" +
                "    @GeneratedValue(strategy = GenerationType.AUTO)\n" +
                "    private Long id;\n" +
                "    " + attributeDeclarations + "\n" +
                "}";
        writeFile(packageName + ".entities", entityName , entityClassContent);
    }

    public  void generateDtoClass(String packageName, String entityName, List<String> attributes) throws IOException {
        String attributeDeclarations = String.join("\n    ", attributes);
        String dtoClassContent = "package " + packageName + ".dto;\n\n" +
                "import java.util.List;\n\n" +
                "import java.time.LocalDate;\n" +
                "import java.time.LocalDateTime;\n" +
                "import java.util.Date;\n" +
                "import lombok.AllArgsConstructor;\n" +
                "import lombok.Data;\n" +
                "import lombok.NoArgsConstructor;\n\n" +
                "@Data\n" +
                "@AllArgsConstructor\n" +
                "@NoArgsConstructor\n" +
                "public class " + entityName + "Dto {\n" +

                "    private Long id;\n" +
                "    " + attributeDeclarations + "\n" +
                "}";
        writeFile(packageName + ".dto", entityName + "Dto" , dtoClassContent);
    }


    public  void generateDaoInterface(String packageName, String entityName,  List<String> methods) throws IOException {
        String daoInterfaceName = entityName + "Dao";
        String daoInterfaceContent = "package " + packageName + ";\n\n" +
                "import " + "org.springframework.data.jpa.repository.JpaRepository;\n" +
                "import com.example.demo.dto." + entityName + "Dto;\n\n" +
                "import org.springframework.stereotype.Repository;\n"+
                "import java.util.List;\n" +
                "import java.time.LocalDate;\n" +
                "import java.time.LocalDateTime;\n" +
                "import java.util.Date;\n" +
                "import " + GeneratorRest.basePackage + ".entities." + entityName + ";\n\n" +
                "@Repository\n"+
                "public interface " + daoInterfaceName + " extends JpaRepository<" + entityName + ", Long> {\n" +
                "    " +   String.join("\n    ", methods)+ "\n" +

                "}";
        writeFile(packageName, daoInterfaceName, daoInterfaceContent);
    }

    public  void generateServiceFacadeInterface(String packageName, String entityName,  List<String> methods) throws IOException {
        String facadeInterfaceName = entityName + "Service";
        String facadeInterfaceContent = "package " + packageName + ";\n\n" +
                "import " + GeneratorRest.basePackage + ".entities." + entityName + ";\n\n" +
                "import com.example.demo.dto." + entityName + "Dto;\n\n" +
                "import java.util.List;\n\n" +
                "import java.time.LocalDate;\n" +
                "import java.time.LocalDateTime;\n" +
                "import java.util.Date;\n" +
                "public interface " + facadeInterfaceName + " {\n" +
                "    void save(" + entityName + " " + entityName.toLowerCase() + ");\n" +
                "    void edit(" + entityName + " " + entityName.toLowerCase() + ");\n" +
                "    void deleteById(Long id);\n" +
                "    " + entityName + " findById(Long id);\n" +
                "    List<" + entityName + "> findAll();\n" +
                String.join("\n    ", methods) + "\n" +
                "}";
        writeFile(packageName, facadeInterfaceName, facadeInterfaceContent);
    }

    public  void generateServiceImplementationClass(String packageName, String entityName,  List<String> methods) throws IOException {
        String facadeInterfaceName = entityName + "Service";
        String implementationClassName = entityName + "ServiceImplementation";
        String implementationClassContent = "package " + packageName + ";\n\n" +
                "import java.util.List;\n\n" +
                "import com.example.demo.dto." + entityName + "Dto;\n\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.stereotype.Service;\n" +
                "import com.example.demo.service.facade."+ entityName +"Service;\n\n"+
                "import " + GeneratorRest.basePackage + ".dao." + entityName + "Dao;\n" +
                "import " + GeneratorRest.basePackage + ".entities." + entityName + ";\n\n" +
                "import java.time.LocalDate;\n" +
                "import java.time.LocalDateTime;\n" +
                "import java.util.Date;\n\n" +
                "@Service\n" +
                "public class " + implementationClassName + " implements " + facadeInterfaceName + " {\n" +
                "    @Autowired\n" +
                "    private " + entityName + "Dao " + entityName.toLowerCase() + "Dao;\n\n" +

                "    @Override\n" +
                "    public void save(" + entityName + " " + entityName.toLowerCase() + ") {\n" +
                "        " + entityName.toLowerCase() + "Dao.save(" + entityName.toLowerCase() + ");\n" +
                "    }\n\n" +
                "    @Override\n" +
                "    public void edit(" + entityName + " " + entityName.toLowerCase() + ") {\n" +
                "        " + entityName.toLowerCase() + "Dao.save(" + entityName.toLowerCase() + ");\n" +
                "    }\n\n" +
                "    @Override\n" +
                "    public void deleteById(Long id) {\n" +
                "        " + entityName.toLowerCase() + "Dao.deleteById(id);\n" +
                "    }\n\n" +
                "    @Override\n" +
                "    public " + entityName + " findById(Long id) {\n" +
                "        return " + entityName.toLowerCase() + "Dao.findById(id).orElse(null);\n" +
                "    }\n\n" +
                "    @Override\n" +
                "    public List<" + entityName + "> findAll() {\n" +
                "        return " + entityName.toLowerCase() + "Dao.findAll();\n" +

                "    }\n\n" +
                String.join("\n    ", methods) + "\n" +
                "}";
        writeFile(packageName, implementationClassName, implementationClassContent);
    }

    public  void generateControllerClass(String packageName, String facadePackageName, String entityName,  List<String> methods) throws IOException {
        String controllerClassName = entityName + "Controller";
        String controllerClassContent = "package " + packageName + ";\n\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import com.example.demo.dto." + entityName + "Dto;\n\n" +
                "import org.springframework.web.bind.annotation.*;\n" +
                "import java.util.List;\n" +
                "import java.time.LocalDate;\n" +
                "import java.time.LocalDateTime;\n" +
                "import java.util.Date;\n\n" +
                "import " + facadePackageName + "." + entityName + "Service;\n" +
                "import " + GeneratorRest.basePackage + ".entities." + entityName + ";\n\n" +
                "@RestController\n" +
                "@RequestMapping(\"/" + entityName.toLowerCase() + "\")\n" +
                "public class " + controllerClassName + " {\n\n" +
                "    @Autowired\n" +
                "    private " + entityName + "Service " + entityName.toLowerCase() + "Service;\n\n" +
                "    @PostMapping(\"/\")\n" +
                "    public void save(@RequestBody " + entityName + " " + entityName.toLowerCase() + ") {\n" +
                "        " + entityName.toLowerCase() + "Service.save(" + entityName.toLowerCase() + ");\n" +
                "    }\n\n" +
                "    @PutMapping(\"/\")\n" +
                "    public void edit(@RequestBody " + entityName + " " + entityName.toLowerCase() + ") {\n" +
                "        " + entityName.toLowerCase() + "Service.edit(" + entityName.toLowerCase() + ");\n" +
                "    }\n\n" +
                "    @DeleteMapping(\"/{id}\")\n" +
                "    public void deleteById(@PathVariable Long id) {\n" +
                "        " + entityName.toLowerCase() + "Service.deleteById(id);\n" +
                "    }\n\n" +
                "    @GetMapping(\"/{id}\")\n" +
                "    public " + entityName + " findById(@PathVariable Long id) {\n" +
                "        return " + entityName.toLowerCase() + "Service.findById(id);\n" +
                "    }\n\n" +
                "    @GetMapping(\"/\")\n" +
                "    public List<" + entityName + "> findAll() {\n" +
                "        return " + entityName.toLowerCase() + "Service.findAll();\n" +

                "    }\n" +
                String.join("\n    ", methods) +
                "}";
        writeFile(packageName, controllerClassName, controllerClassContent);
    }

    public void generateCretiriaClass(String packageName, String criteriaPackageName, String entityName, List<String> attributes){

    }



    public  void writeFile(String packageName, String fileName, String content) throws IOException {
        File packageDir = new File("src/main/java/" + packageName.replace(".", "/"));
        packageDir.mkdirs();
        File file = new File(packageDir, fileName + ".java");
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        writer.close();
    }

}
