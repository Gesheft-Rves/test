###В приложении есть 3 endpoint _- a_

####`/start` 
-  запрос "start" запускает задачу для переданного в параметрах id жанра.
-  например `"localhost:8080/start?genreId=14"` Вернет json ответ такого вида:
-           
           `{
                "msg": "The task is started for a genre with an id = 14"
            }`
            
- если пользователь пытается запустить задачу с таким же id, 
  не остановив предыдущую, он получит следующий json ответ:
-           
            `{
                "msg": "A task with this id = 14 is already running"
             }`
- если пользователь пытается запустить задачу с таким же id, остановив предыдущее вычисление для этого id, то задача будет запущена сначала. 
           
           
 ####`/getInfo` 
- запрос "getInfo" возвращает промежуточный результат вычислений для переданного в параметрах id жанра.
-  например `"localhost:8080/getInfo?genreId=14"` Вернет json ответ такого вида:
-           
        `{
             "quantityMoviesRead": 501,
             "averageRatingByGenre": 6.315369261477049,
             "msg": "in progress..."
         }`
         
         `quantityMoviesRead`   - счетчик прочитанных с момента запуска задачи фильмов, подходящих по id
         `averageRatingByGenre` - средний рейтинг для переданного в getInfo id жанра. 
- в случае, когда задача не запущена, а пользователь пытается получить информацию об этой задаче возвращает такой ответ: 
-   
        например: `localhost:8080/getInfo?genreId=15`
        `{
            "quantityMoviesRead": null,
            "averageRatingByGenre": 0.0,
            "msg": "Not started task for genre id = 15"
         }`
 
 ####`/stop`   
 - запрос "stop" останавливает преждевременно задачу для переданного в параметрах id жанра 
 - выводит результат вычислений.
 -  например `"localhost:8080/stop?genreId=14"` Вернет json ответ такого вида:
 -           
         `{
              "quantityMoviesRead": 1528,
              "averageRatingByGenre": 6.087630890052365,
              "msg": "interrupted by the user"
          }`
           
 - в случае, когда задача не запущена, а пользователь пытается остановить её, он получит такой ответ: 
 -   
         например: `localhost:8080/getInfo?genreId=15`
         `{
              "quantityMoviesRead": null,
              "averageRatingByGenre": 0.0,
              "msg": "The task with this id = 15 is not running"
          }`  
          
