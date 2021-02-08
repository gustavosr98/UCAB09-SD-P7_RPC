# Requirements

- Java Open SDK v11.0.9.1+
- Apache Maven v3.6.0+
- PostgreSQL 12+

## Instala los requerimientos básicos

```bash
  sudo apt install default-jdk
  java -version
```

```bash
  sudo apt install maven
  mvn -version
```

```bash
$ sudo apt update
$ sudo apt install postgresql postgresql-contrib
$ sudo -u postgres psql -c "SELECT version();"
```

## Crear una base de datos
- Crea una base de datos en PostgreSQL
## Archivo de configuración
```bash
cd src/main 
cp example.hibernate.cfg.xml hibernate.cfg.xml
```
Cambiar las propiedades del USERNAME,PASSWORD y DABATASE_NAME archivo hibarnate.cfg.xml
```xml
  <property name="hibernate.connection.username">USERNAME</property>
  <property name="hibernate.connection.password">PASSWORD</property>
  <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/DABATASE_NAME</property> 
```

## Ejecutar
### 0. Compilar
Se instalan las dependencias y se compila el sistema generando archivos class de Java en la carpeta target
```bash
mvn compile
```

### 1. RMI Registry
Luego de que compile y se generen los archivos class de Java. Ir a la siguiente carpeta
```bash
cd /target/classes
```

> IMPORTATE: El RMI Registry se debe ejecutar dentro de esta carpeta  `{project_root}/target/classes`
```bash
rmiregistry &
```


### 2. Servidor
Levanta el servidor
```bash
  mvn exec:java
```

### 3. Cliente
Ejecuta el cliente
```bash
  mvn exec:java -Dexec.mainClass=com.team5.client.Client
```