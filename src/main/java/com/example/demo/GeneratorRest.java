package com.example.demo;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/generator")
public class GeneratorRest {


    final static String  basePackage = "com.example.test";
    static final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/")
    public String generate() throws IOException {
        String packageName = "com.example.test";

        String jsonContent = new String(Files.readAllBytes(Paths.get("src/main/resources/entities.json")));

        JsonNode entitiesNode = objectMapper.readTree(jsonContent);

        for (JsonNode entityNode : entitiesNode) {
            String entityName = entityNode.get("nameEntity").asText();
            List<String> attributes = new ArrayList<>();
            JsonNode attributesNode = entityNode.get("attributes");
            for (JsonNode attributeNode : attributesNode) {
                String attributeName = attributeNode.get("nameAttribute").asText();
                String attributeType = attributeNode.get("type").asText();
                String attributeDeclaration = "private " + attributeType + " " + attributeName + ";\n\n";
                attributes.add(attributeDeclaration);
            }

            generateEntityClass(packageName, entityName, attributes);
            generateDaoInterface(packageName + ".dao", entityName);
            generateServiceFacadeInterface(packageName + ".service.facade", entityName);
            generateServiceImplementationClass(packageName + ".service.implementation", entityName);
            generateControllerClass(packageName + ".controller", packageName + ".service.facade", entityName);
        }
        return jsonContent;
    }

    public static void generateEntityClass(String packageName, String entityName, List<String> attributes) throws IOException {
        String attributeDeclarations = String.join("\n    ", attributes);
        String entityClassContent = "package " + packageName + ".entities;\n\n" +
                "import javax.persistence.*;\n" +
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

    public static void generateDaoInterface(String packageName, String entityName) throws IOException {
        String daoInterfaceName = entityName + "Dao";
        String daoInterfaceContent = "package " + packageName + ";\n\n" +
                "import " + "org.springframework.data.jpa.repository.JpaRepository;\n" +
                "import org.springframework.stereotype.Repository;\n"+
                "import java.util.List;\n" +
                "import " + GeneratorRest.basePackage + ".entities." + entityName + ";\n\n" +
                "@Repository\n"+
                "public interface " + daoInterfaceName + " extends JpaRepository<" + entityName + ", Long> {\n" +
                "}";
        writeFile(packageName, daoInterfaceName, daoInterfaceContent);
    }

    public static void generateServiceFacadeInterface(String packageName, String entityName) throws IOException {
        String facadeInterfaceName = entityName + "Service";
        String facadeInterfaceContent = "package " + packageName + ";\n\n" +
                "import " + GeneratorRest.basePackage + ".entities." + entityName + ";\n\n" +
                "import java.util.List;\n\n" +

                "public interface " + facadeInterfaceName + " {\n" +
                "    void save(" + entityName + " " + entityName.toLowerCase() + ");\n" +
                "    void edit(" + entityName + " " + entityName.toLowerCase() + ");\n" +
                "    void deleteById(Long id);\n" +
                "    " + entityName + " findById(Long id);\n" +
                "    List<" + entityName + "> findAll();\n" +
                "}";
        writeFile(packageName, facadeInterfaceName, facadeInterfaceContent);
    }

    public static void generateServiceImplementationClass(String packageName, String entityName) throws IOException {
        String facadeInterfaceName = entityName + "Service";
        String implementationClassName = entityName + "ServiceImplementation";
        String implementationClassContent = "package " + packageName + ";\n\n" +
                "import java.util.List;\n\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.stereotype.Service;\n" +
                "import com.example.test.service.facade."+ entityName +"Service;\n\n"+
                "import " + GeneratorRest.basePackage + ".dao." + entityName + "Dao;\n" +
                "import " + GeneratorRest.basePackage + ".entities." + entityName + ";\n\n" +
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
                "    }\n" +
                "}";
        writeFile(packageName, implementationClassName, implementationClassContent);
    }

    public static void generateControllerClass(String packageName, String facadePackageName, String entityName) throws IOException {
        String controllerClassName = entityName + "Controller";
        String controllerClassContent = "package " + packageName + ";\n\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.web.bind.annotation.*;\n" +
                "import java.util.List;\n" +
                "import " + facadePackageName + "." + entityName + "Service;\n" +
                "import " + GeneratorRest.basePackage + ".entities." + entityName + ";\n\n" +
                "@RestController\n" +
                "@RequestMapping(\"/" + entityName.toLowerCase() + "\")\n" +
                "public class " + controllerClassName + " {\n" +
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
                "}";
        writeFile(packageName, controllerClassName, controllerClassContent);
    }

    public static void writeFile(String packageName, String fileName, String content) throws IOException {
        File packageDir = new File("src/" + packageName.replace(".", "/"));
        packageDir.mkdirs();
        File file = new File(packageDir, fileName + ".java");
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        writer.close();
    }

}
