# Сервис перевода денег с карты на карту
Курсовой проект по курсу "Java-разработчик с нуля" в Нетологии. 

## Технические характеристики

   - Язык: Java
   - IDE: Idea
   - Framework: Spring Boot
   - Управление проектом: Maven
   - Управление версиями: github
   - Тестирование: Mock
   - Порт работы back end: 5500
   - Настройки: application.yml
   
## Функциональность

#### Перевод денег с карты на карту.

  - Пользователь может через клиентский интерфейс (демо front end: https://serp-ya.github.io/card-transfer/) выполнить перевод с карты на карту
  - Запрос на адрес методом POST: http://localhost:5500/transfer
  - Пример тела запроса: 
  ```JSON
{
    "cardFromNumber": "4875130166305242",
    "cardFromValidTill": "05/26",
    "cardFromCVV": "166",
    "cardToNumber": "4832137002407290",
    "amount": {
        "value": 100,
        "currency": "RUB"
    }
}
  ````
#### Получение кода подтверждения успешной транзакции

  - При успешном переводе для подтверждения текуей операции передается код подтверждения.
  - Запрос на адрес методом POST: http://localhost:5500/confirmOperation
  - Пример тела запроса: 
 ```JSON
 {
    "operationId": "1",
    "code": "0001"
}
````
#### Хранилище
- В качестве хранилища используется файл logs/storage.txt

#### Логирование

  - На стороне сервера происходит сохранение информации о платеже, ИД операции в ./log/app.log. 


