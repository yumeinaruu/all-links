API, позволяющее пользователям оставлять ссылки на свои профили/каналы/ресурсы в социальных сетях

**Правила установки**
---
 На локальной машине:
  1. Установить docker
  2. git clone https://github.com/yumeinaruu/all-links
  3. docker-compose up -d
  4. Открыть Postman, выбрать Collections, а потом import. В директории postman-collection находится JSON. Этот файл нужно будет перетащить в окошко в import
  5. Описание модели (1 задание) находится в директории project-description
  
 На удаленном сервере:
 1. создать droplet на сервисе DigitalOcean
  2. подключиться к серверу командой root@ip_adress_of_droplet через консоль используя wsl (просто консоль если используется linux)
  3. curl -fsSL https://get.docker.com -o get-docker.sh
  4. sudo sh get-docker.sh
  5. git clone https://github.com/yumeinaruu/all-links
  6. docker-compose up -d
  7. Открыть Postman, выбрать Collections, а потом import. В директории postman-collection находится JSON. Этот файл нужно будет перетащить в окошко в import
  8. Описание модели (1 задание) находится в директории project-description



**Информация о проекте**
---

1. Что нужно знать перед запуском
    + Где находится информция для .properties и docker-compose?
        - В .env файле.
2. Какие технологии были использованы?
    + PostgreSQL
    + Spring Framework 
        - Spring Boot
        - Spring MVC
        - Spring Data
    + Hibernate
    + Slf4g for logging
    + Liquibase
    + Docker
