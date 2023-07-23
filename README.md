## Spring-приложение. Генератор вопросов.

### Путь пользователя

1. Пользователь обращается к некому эндпоинту по адресу (”/exam/get/{amount}”)
2. Пользователь получает ответ в виде списка случайных вопросов-ответов, количество которых равно amount из прошлого шага
3. Пользователь должен иметь возможность добавить, получить и удалить вопросы из хранилища вопросов (”/exam/java/(add/remove/find)”)

________

### Реализация приложения и архитектура

1. Сущность Question реализована с двумя полями: question и answer. Данная сущность будет использоваться в качестве хранителя данных по вопросу.

   <img width="300" alt="image" src="https://github.com/KrozhDev/questGen/assets/118728485/bbcdb23c-1164-48c5-b022-7841aa0d9e32">

2. Интерфейс QuestionService будет содержать в себе все методы по работе с вопросами определенного предмета.

   <img width="600" alt="image" src="https://github.com/KrozhDev/questGen/assets/118728485/844e976e-4be1-43a0-ac07-8ec4616d1b5c">
   
   **сплошная использует, пунктирная реализует*

3. Cервис JavaQuestionService реализует QuestionService и хранить в себе список вопросов по Java, а также осуществлять всю работу с этим списком.
    
   Реализация метода getRandomQuestion осуществляется с помощью класса Random и его метода nextInt, который в качестве параметра принимает максимальное число, а затем возвращает результат в виде случайного числа от 0 до максимального числа из параметров (не включительно).

   <img width="500" alt="image" src="https://github.com/KrozhDev/questGen/assets/118728485/2ec24d26-633f-4278-9e3c-a58282378937">

4. Контроллер JavaQuestionController предоставляет возможность пользователю добавлять, просматривать и удалять вопросы по Java в соответствующем QuestionService.
    
    Контроллер должен иметь три метода: добавить, удалить и получить все вопросы.
    
    Эндпоинты методов:
    
    + Добавить: “/exam/java/add?question=QuestionText&answer=QuestionAnswer”
    
    + Удалить: “/exam/java/remove?question=QuestionText&answer=QuestionAnswer”
    
    + Получить все вопросы: “/exam/java”
  
    <img width="500" alt="image" src="https://github.com/KrozhDev/questGen/assets/118728485/92af72e9-d02d-44af-a256-109821d7ef5c">

5. Интерфейс ExaminerService с одним методом getQuestions.
    
   Интерфейс содержит один метод, который вернет список вопросов.

   <img width="500" alt="image" src="https://github.com/KrozhDev/questGen/assets/118728485/6ca48516-13c9-488a-822c-5f3a1427a56f">

6. ExaminerServiceImpl сервис внутри себя хранит поля типа QuestionService.
    
    Его задача: создать коллекцию и заполнить её с помощью вызова getRandomQuestion у QuestionService случайными вопросами. 
    
    1.  Вопросы должны быть уникальные, следовательно, для получения 5 вопросов может потребоваться более 5 вызовов метода getRandomQuestion сервиса вопросов.
    2. Если запрошено большее количество вопросов, чем хранится в сервисе, нужно выкинуть исключение. Для этого, соответственно, нужно написать свое исключение со статусом BAD_REQUEST.
    
    <img width="600" alt="image" src="https://github.com/KrozhDev/questGen/assets/118728485/f4e1a3fd-7e88-4a98-bf2d-e6f69be6014d">
        
7. Контроллер ExamController с одним методом getQuestions(int amount).
    
    Контроллер обращается к ExaminerService, получает от сервиса коллекцию вопросов и возвращает пользователю.
    
8. JavaQuestionService и ExaminerServiceImpl покрыт юнит-тестами с мокитированием.




