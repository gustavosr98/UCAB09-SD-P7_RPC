# Requirements

- Java Open SDK v11.0.9.1+
- Apache Maven v3.6.0+

## Instalation of requirments
```bash 
  sudo apt install default-jdk
  java -version
```

```bash 
  sudo apt install maven
  mvn -version
```

# Run
```bash 
  mvn compile
  mvn exec:java -Dexec.mainClass=com.team5.Server
  mvn exec:java -Dexec.mainClass=com.team5.Client
```

You should see Hello World!